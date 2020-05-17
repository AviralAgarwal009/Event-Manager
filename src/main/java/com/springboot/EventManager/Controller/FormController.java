package com.springboot.EventManager.Controller;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Base64;

import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialBlob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;
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
	
	
	@GetMapping("/")
	public String showHome(Model model,HttpSession httpSession) {
		httpSession.setAttribute("begin", "true");
		Participants participants=new Participants();
		model.addAttribute("participant",participants);
		return "home";
	}
	
	
	
	
	@PostMapping("/preview")
	public String showPreview(@RequestParam("imageFile") MultipartFile file,@ModelAttribute("participant") Participants participants,Model model , HttpSession httpSession) {
		
		if(httpSession.getAttribute("begin")==null) {
			return "home";
		}

		
		if(participants.getRegType().equalsIgnoreCase("self")) {
			participants.setTicketsQty(1);
		}
		
		try {
			participants.setIdentity(new SerialBlob(file.getBytes()));
		}catch(Exception e) {
			System.out.println("Exception inside showPreview Controller blob"+e.getMessage());
		}
		//data will be saved after the user save inside this page
		System.out.println(participants.getIdentity());
		
		String image="";
		model.addAttribute("participantDetail", participants);
		try
		{
		     image=Base64.getEncoder().encodeToString(file.getBytes());
			 
		}catch(Exception e) {
			System.out.println("Exception inside preview controller"+e.getMessage()  );
		}
		
		model.addAttribute("image", image);
		
		httpSession.setAttribute("participant",participants );//set data for registration controller
		return "show";
	}
	
	
	@PostMapping("/registrationPage")
	public String registrationPage(HttpSession httpSession) {
		
		if(httpSession.getAttribute("begin")==null) {
			return "home";
		}
		

		Participants participants= (Participants)httpSession.getAttribute("participant");
		
		//generate registration number
		//save data to database
		//display registration number
		int save=detailsService.saveParticipants(participants);
		
		return "registration";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
