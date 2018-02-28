package pl.pkrakowiak.controller;

import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.printing.PDFPageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pl.pkrakowiak.entity.Sailor;
import pl.pkrakowiak.repo.ExamRepo;
import pl.pkrakowiak.repo.SailorRepo;

@Controller
@RequestMapping("/sailor")
public class SailorController {
	@Autowired
	SailorRepo sailorRepo;
	@Autowired
	ExamRepo examRepo;

	@GetMapping("/add")
	public String addExam(Model model) {
		Sailor sailor = new Sailor();
		model.addAttribute("sailor", sailor);
		model.addAttribute("exams", examRepo.findAll());
		return "sailorForm";
	}

	@PostMapping("/add")
	public String addNew(@ModelAttribute Sailor sailor, Model model) {
		sailorRepo.save(sailor);
		return "redirect:/";
	}

	@GetMapping("/")
	public String show(Model model) {
		model.addAttribute("sailors", sailorRepo.findAll());

		return "sailors";
	}

	@GetMapping("/delete/{id}")
	public String deleteSailor(@PathVariable int id) {
		Sailor sailor = sailorRepo.findById(id);
		sailorRepo.delete(sailor);
		return "redirect:/sailor/";
	}

	@GetMapping("/edit/{id}")
	public String editSailor(@PathVariable int id, Model model) {
		Sailor sailor = sailorRepo.findById(id);
		model.addAttribute("exams", examRepo.findAll());
		model.addAttribute("sailor", sailor);
		return "sailorForm";
	}

	@PostMapping("/edit/{id}")
	public String updateSailor(@ModelAttribute Sailor sailor) {

		sailorRepo.save(sailor);

		return "redirect:/sailor/";
	}

	@GetMapping("/pdf/{id}")
	public String pdfSailor(@PathVariable int id, Model model, RedirectAttributes redirectAttributes)
			throws IOException {

		Sailor sailor = sailorRepo.findById(id);
		InputStream is = (new ClassPathResource("Sailor.pdf")).getInputStream();

		try (PDDocument pdfDocument = PDDocument.load(is)) {
			PDAcroForm acroForm = pdfDocument.getDocumentCatalog().getAcroForm();
			// PDStream pdStream = new PDStream(pdfDocument);
			// PDSimpleFont font = PDType1Font.TIMES_ROMAN;

			if (acroForm != null) {
				System.out.println(sailor.getNameSurname());
				acroForm.getField("nameSurname").setValue(sailor.getNameSurname());
				acroForm.getField("dateOfBirth").setValue(sailor.getDateOfBirth().toString());

				List<PDField> pList = acroForm.getFields();

				for (PDField pdField : pList) {
					pdField.setReadOnly(true);

				}

			}
			pdfDocument.save("Sailor_" + sailor.getId() + ".pdf");

		} catch (Exception e) {
			System.out.println(e);
			redirectAttributes.addFlashAttribute("message", e.getMessage());
		}

		return "redirect:/sailor/";
	}

	@GetMapping("/print/{id}")
	public String printSailor(@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {

		try {
			PDDocument document = PDDocument
					.load(new File("/media/pkrakowiak/Dane/JAVA/eclipse/Sailor_" + id + ".pdf"));

			PrintService myPrintService = findPrintService("hp-LaserJet-1012");
			PrinterJob job = PrinterJob.getPrinterJob();
			job.setPageable(new PDFPageable(document));
			job.setPrintService(myPrintService);
			job.print();
		} catch (Exception e) {
			System.out.println(e);
			redirectAttributes.addFlashAttribute("message", e.getMessage());
		}

		return "redirect:/sailor/";
	}

	private static PrintService findPrintService(String printerName) {
		PrintService[] printServices = PrintServiceLookup.lookupPrintServices(null, null);
		for (PrintService printService : printServices) {
			if (printService.getName().trim().equals(printerName)) {
				return printService;
			}
		}
		return null;
	}
}
