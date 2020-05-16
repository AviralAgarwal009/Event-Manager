package com.springboot.EventManager.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.EventManager.Service.DetailsService;
import com.springboot.EventManager.entity.Participants;

@Controller
public class FormController {

	@Autowired
	DetailsService detailsService;

	@GetMapping("/home")
	public String showHome(Model model) {

		Participants theParticipants = new Participants();
		model.addAttribute("participant", theParticipants);
		return "home";
	}

	@PostMapping("/saveParticipant")
	public String saveParticipant(@ModelAttribute("participant") Participants theParticipants) {
		detailsService.saveParticipants(theParticipants);
		return "redirect:/  ";
	}

}
