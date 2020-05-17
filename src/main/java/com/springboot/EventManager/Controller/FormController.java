package com.springboot.EventManager.Controller;

import java.io.FileOutputStream;
import java.util.Base64;
import javax.sql.rowset.serial.SerialBlob;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.springboot.EventManager.entity.Participants;

@Controller
public class FormController {

	@GetMapping("/")
	public String showHome(Model model) {

		Participants participants = new Participants();
		model.addAttribute("participant", participants);
		return "home";
	}

	@PostMapping("/preview")
	public String showPreview(@RequestParam("imageFile") MultipartFile file,
			@ModelAttribute("participant") Participants participants, Model model) {

		System.out.println("Here is all the data");
		System.out.println(participants.getName() + "\n" + participants.getEmail());
		System.out.println(participants.getRegType());
		System.out.println(participants.getTicketsQty());
		System.out.println(participants.getContact());
		System.out.println(participants.getIdentity());
		System.out.println(file.getOriginalFilename());

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
		model.addAttribute("participantDetail", participants);
		try {

			image = Base64.getEncoder().encodeToString(file.getBytes());
			FileOutputStream f = new FileOutputStream("src//main//resources//static//images//temp2.jpg");
			f.write(file.getBytes());
			f.close();

		} catch (Exception e) {
			System.out.println("Exception inside preview controller" + e.getMessage());
		}

		model.addAttribute("image", image);

		return "show";
	}
}