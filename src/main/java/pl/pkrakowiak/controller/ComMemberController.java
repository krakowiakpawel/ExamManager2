package pl.pkrakowiak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.pkrakowiak.entity.ComMember;
import pl.pkrakowiak.repo.ComMemberRepo;

@Controller
@RequestMapping("/comMember")
public class ComMemberController {

	@Autowired
	ComMemberRepo comMemberRepo;
	
	
	@GetMapping("/add")
	public String addExam(Model model) {
		ComMember comMember = new ComMember();
		model.addAttribute("comMember", comMember);
		return "comMemberForm";
	}
	@PostMapping("/add")
	public String addNew(@ModelAttribute ComMember comMember, Model model) {
		comMemberRepo.save(comMember);
		return "redirect:/comMember/";
	}
	
	@GetMapping("/")
	public String show(Model model) {
		model.addAttribute("comMembers", comMemberRepo.findAll());
		return "comMembers";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteComMember(@PathVariable int id) {
		ComMember comMember = comMemberRepo.findById(id);
		try {
		comMemberRepo.delete(comMember);
		
		} catch (Exception JpaSystemException) {
			System.out.println("nie da się");
		} finally {
			return "redirect:/comMember/";
		}
		
		
	}

	@GetMapping("/edit/{id}")
	public String editComMember(@PathVariable int id, Model model) {
		ComMember comMember = comMemberRepo.findById(id);
		model.addAttribute("comMember", comMember);
		return "comMemberForm";
	}

	@PostMapping("/edit/{id}")
	public String updateComMember(@ModelAttribute ComMember comMember) {

		comMemberRepo.save(comMember);

		return "redirect:/comMember/";
	}
	
	
}
// @RequestMapping("/")
// public String hello() {
// return "index";
// }