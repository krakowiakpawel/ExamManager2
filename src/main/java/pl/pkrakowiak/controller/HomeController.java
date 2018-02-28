package pl.pkrakowiak.controller;

import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDTextField;
import org.apache.pdfbox.printing.PDFPageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import pl.pkrakowiak.entity.User;
import pl.pkrakowiak.repo.UserRepo;
import pl.pkrakowiak.service.DBService;

@Controller
public class HomeController {

	@Autowired
	UserRepo userRepo;

	@RequestMapping("/")
	public String hello() {
		return "index";
	}

	@RequestMapping("/pdf2")
	public String pdfAgain() throws IOException {
		InputStream is = (new ClassPathResource("PDFForm.pdf")).getInputStream();

		try (PDDocument pdfDocument = PDDocument.load(is)) {

			// get the document catalog
			PDAcroForm acroForm = pdfDocument.getDocumentCatalog().getAcroForm();

			// as there might not be an AcroForm entry a null check is necessary
			if (acroForm != null) {
				// Retrieve an individual field and set its value.
				PDTextField field = (PDTextField) acroForm.getField("Test1");
				field.setValue("Output1");
			}

			// Save and close the filled out form.
			pdfDocument.save("FillFormField.pdf");
		} catch (Exception e) {
			System.out.println(e);
		}

		return "index";
	}

	@RequestMapping("/callPrint")
	public String callPrint() throws Throwable, IOException {

		PDDocument document = PDDocument.load(new File("/media/pkrakowiak/Dane/JAVA/eclipse/Sailor_2.pdf"));

		PrintService myPrintService = findPrintService("hp-LaserJet-1012");

		PrinterJob job = PrinterJob.getPrinterJob();
		job.setPageable(new PDFPageable(document));
		job.setPrintService(myPrintService);
		job.print();

		return "index";
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession sess = request.getSession();
		sess.invalidate();
		return "redirect:/";
	}

	@PostMapping("/login")
	public String logincheck(Model model, @RequestParam String email, @RequestParam String password,
			HttpServletRequest request) {

		User user = userRepo.findOneByEmail(email);

		if (user != null && user.checkPassword(password)) {
			HttpSession sess = request.getSession();
			sess.setAttribute("user", user);
			return "redirect:/";
		}

		model.addAttribute("message", "Wprowadz poprawne dane");
		return "login";

	}

	@RequestMapping("/dumpSQL")
	public String dumpSQL(RedirectAttributes redirectAttributes) {
		try {
			DBService.dumpSQL();
			redirectAttributes.addFlashAttribute("message", "OK!");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("message", e.getMessage());
		}

		return "redirect:/";
	}

	@RequestMapping("/createPDF")
	
	public String createPDF() throws Exception, Exception {
//	final String RESULT  = "results/part1/chapter01/hello.pdf";
/**
 * Creates a PDF file: hello.pdf
 * @param    args    no arguments needed
 */
String filename = "hello3.pdf";
    // step 1
    Document document = new Document();
    // step 2
    PdfWriter.getInstance(document, new FileOutputStream(filename));
    // step 3
    document.open();
    // step 4
    document.add(new Paragraph("Ł - L"));
    document.add(new Paragraph("Ą - A"));
    // step 5
    document.close();

		return "index";
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
