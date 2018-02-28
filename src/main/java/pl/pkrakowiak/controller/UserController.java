package pl.pkrakowiak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.pkrakowiak.entity.User;
import pl.pkrakowiak.repo.UserRepo;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserRepo userRepo;

	@GetMapping("/add")
	public String addUser(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "userForm";
	}

	@PostMapping("/add")
	public String addNew(@ModelAttribute User user, Model model) {
		userRepo.save(user);
		return "redirect:/";
	}
}
