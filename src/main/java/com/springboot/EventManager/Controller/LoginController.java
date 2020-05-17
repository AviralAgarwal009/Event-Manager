package com.springboot.EventManager.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@GetMapping("/admin")
	public String login(Model model, String error, String logout) {

		if (error != null)
			model.addAttribute("error", "Your username and password is invalid.");

		if (logout != null)
			model.addAttribute("message", "Your username and password is invalid.");

		return "login";
	}

	@GetMapping("/participants")
	public String Welcome(Model model) {
		return "admin";
	}

	/*@RequestMapping("/access-denied")
	public String showAccessDenied() {

		return "access-denied";

	}*/

}
