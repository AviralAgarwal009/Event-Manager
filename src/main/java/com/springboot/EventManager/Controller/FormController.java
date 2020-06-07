package com.springboot.EventManager.Controller;

import java.sql.SQLException;
import java.util.Base64;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialBlob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.springboot.EventManager.Service.DetailsService;
import com.springboot.EventManager.entity.Participants;

@Controller
public class FormController {

	@Autowired
	DetailsService detailsService;

	@GetMapping(value= {"/","home"})
	public String showHome(Model model, HttpSession httpSession) {
		httpSession.setAttribute("begin", "true");
		Participants participants = new Participants();
		model.addAttribute("participant", participants);
		return "home";
	}

	@PostMapping("/preview")
	public String showPreview(@RequestParam("imageFile") MultipartFile file,
			@ModelAttribute("participant") Participants participants, Model model, HttpSession httpSession) {

		if (httpSession.getAttribute("begin") == null) {
			return "home";
		}

		if (participants.getRegType().equalsIgnoreCase("self")) {
			participants.setTicketsQty(1);
		}

		try {
			participants.setIdentity(new SerialBlob(file.getBytes()));
		} catch (Exception e) {
			System.out.println("Exception inside showPreview Controller blob" + e.getMessage());
		}
		// data will be saved after the user save inside this page

		String image = "";

		try {
			image = Base64.getEncoder().encodeToString(file.getBytes());

		} catch (Exception e) {
			System.out.println("Exception inside preview controller" + e.getMessage());
		}
		model.addAttribute("participantDetail", participants);// to see the changes made
		model.addAttribute("image", image);

		httpSession.setAttribute("participant", participants);// set data for registration controller
		return "preview";
	}

	@PostMapping("/registrationPage")
	public String registrationPage(@ModelAttribute("participantDetail") Participants p, HttpSession httpSession,Model model) {

		if (httpSession.getAttribute("begin") == null) {
			return "home";
		}

		Participants participants = (Participants) httpSession.getAttribute("participant");
		participants.setName(p.getName());
		participants.setContact(p.getContact());
		participants.setEmail(p.getEmail());
		participants.setRegType(p.getRegType());
		participants.setTicketsQty(p.getTicketsQty());

		// generate registration number
		// save data to database
		// display registration number
		int save = detailsService.saveParticipants(participants);
		model.addAttribute("registrationNumber", save);
		return "registration";

	}
	
	@GetMapping("/participantlogin")
	public String participantLogin(Model model) {
		
		
		model.addAttribute("checkCredentials",true);
		return "participantLogin";
		
	}
	
	
	@PostMapping("/participantauth")
	public String checkCredentials(@RequestParam("number")int regNo, Model model) {
		
		
		boolean check=detailsService.check(regNo);
		if(!check) {
			//does not exists
			model.addAttribute("checkCredentials", false);
			return "participantLogin";
		}
		else
		{
				
			Participants p=detailsService.getParticipants(regNo);
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
	
	
	

}