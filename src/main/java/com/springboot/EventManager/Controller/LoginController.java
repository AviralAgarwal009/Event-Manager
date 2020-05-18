package com.springboot.EventManager.Controller;

import java.sql.SQLException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.springboot.EventManager.Service.DetailsService;
import com.springboot.EventManager.entity.Participants;
import com.springboot.EventManager.model.RegTypeCount;



@Controller
public class LoginController {
	
	@Autowired
	DetailsService detailsService;

	@GetMapping("/adminlogin")
	public String login(Model model, String error, String logout) {

		if (error != null)
			model.addAttribute("error", "Your username and password is invalid.");

		if (logout != null)
			model.addAttribute("message", "Your username and password is invalid.");

		return "admin/login";
	}

	@GetMapping("/entries")
	public String Welcome(Model model) {
		
		RegTypeCount reg=detailsService.getCount();
		List<Participants> p=detailsService.getParticipants();
		
		model.addAttribute("regCount", reg);
		model.addAttribute("participant", p);
		
		return "admin/home";
	}
	
	@GetMapping("/showDetails")
	public String showDetails(@RequestParam("id")int id,Model model) {
		
		Participants p=detailsService.getParticipants(id);
		model.addAttribute("participant", p);
		byte imageArray[]= {};
		try {
			
			long length=p.getIdentity().length();
			imageArray=p.getIdentity().getBytes(1, (int)length);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		String image = Base64.getEncoder().encodeToString(imageArray);
		model.addAttribute("image", image);

		
		return "admin/participantDetails";
		
	}

}
