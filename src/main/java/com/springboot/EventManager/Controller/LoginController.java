package com.springboot.EventManager.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
<<<<<<< HEAD

=======
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
>>>>>>> 0de088c2cc774beed78601784fcacec7420cd488

@Controller
public class LoginController {

	@GetMapping("/adminlogin")
	public String login(Model model, String error, String logout) {

		if (error != null)
			model.addAttribute("error", "Your username and password is invalid.");

		if (logout != null)
			model.addAttribute("message", "Your username and password is invalid.");

		return "login";
	}

	@GetMapping("/entries")
	public String Welcome(Model model) {
		return "admin";
	}

<<<<<<< HEAD
}
=======
}
>>>>>>> 0de088c2cc774beed78601784fcacec7420cd488
