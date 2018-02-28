package pl.pkrakowiak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.pkrakowiak.entity.Exam;
import pl.pkrakowiak.repo.ComMemberRepo;
import pl.pkrakowiak.repo.ExamRepo;

@Controller
@RequestMapping("/exam")
public class ExamController {

	@Autowired
	ExamRepo examRepo;
	@Autowired
	ComMemberRepo comMemberRepo;
	

	@GetMapping("/add")
	public String addExam(Model model) {
		Exam exam = new Exam();
		model.addAttribute("exam", exam);
		model.addAttribute("comMembers", comMemberRepo.findAll());
		return "examForm";
	}

	@PostMapping("/add")
	public String addNew(@ModelAttribute Exam exam, Model model) {
		System.out.println(exam.getDate().toString());
		examRepo.save(exam);
		return "redirect:/exam/";
	}
	
	@GetMapping("/")
	public String show(Model model) {
		model.addAttribute("exams", examRepo.findAll());
		return "exams";
	}
	
	
	@GetMapping("/delete/{id}")
	public String deleteExam(@PathVariable int id) {
		Exam exam = examRepo.findById(id);
		examRepo.delete(exam);
		return "redirect:/exam/";
	}

	@GetMapping("/edit/{id}")
	public String editExam(@PathVariable int id, Model model) {
		Exam exam = examRepo.findById(id);
		model.addAttribute("comMembers", comMemberRepo.findAll());
		model.addAttribute("exam", exam);
		return "examForm";
	}

	@PostMapping("/edit/{id}")
	public String updateExam(@ModelAttribute Exam exam) {

		examRepo.save(exam);

		return "redirect:/exam/";
	}
}
