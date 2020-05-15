package com.springboot.EventManager.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.springboot.EventManager.entity.Participants;

@Controller
public class FormController {
	
	@GetMapping("/home")
	public String showHome(Model model) {
		
		Participants participants=new Participants();
		model.addAttribute("participant",participants);
		return "home";
}

}
