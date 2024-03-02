package com.gl.test.TicketTrackerSpringBoot;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.test.TicketTrackerSpringBoot.Model.TicketService;
import com.gl.test.TicketTrackerSpringBoot.Model.TicketTracker;

@Controller
public class MyController {
	@Autowired
	TicketService service;
	
	@RequestMapping("/")
	public String homepage(Model data) {
		List<TicketTracker> ticketTracker=service.getAll();
		data.addAttribute("ticketTracker",ticketTracker);
		return "home";
	}
	@RequestMapping("/newTicket")
	public String newTicket() {
		return "addTickets";
	}
	@PostMapping("/add-ticket-form")
	public  String addticketform(@RequestParam String ticketTitle,@RequestParam String ticketShortDiscription,@RequestParam LocalDate ticketCreatedOn,Model data) {
		
		TicketTracker t1=new TicketTracker(0, ticketTitle, ticketShortDiscription, ticketCreatedOn);
		service.add(t1);
		
		List<TicketTracker> ticketTracker=service.getAll();
		data.addAttribute("ticketTracker",ticketTracker);
		
		return "home";
		
	}
	@GetMapping("/deletemethod")
	public String deleteTicket(@RequestParam int id,Model data) {
		
		TicketTracker d1=new TicketTracker(id, "", "", null);
		service.delete(d1);		
		
		List<TicketTracker> ticketTracker=service.getAll();
		data.addAttribute("ticketTracker",ticketTracker);
		return "home";
	}
	@GetMapping("/editmethod")
	public String editform(@RequestParam int id,Model data) {
		
		TicketTracker editid=service.getById(id);
		if(editid !=null) {
			data.addAttribute("editid",editid);
			return "editTickets";
		}
		else {
			return "home";
		}
	}
	@PostMapping("/edit-ticket-form")
	public String editform(@RequestParam int id,@RequestParam String ticketTitle,@RequestParam String ticketShortDiscription,@RequestParam LocalDate ticketCreatedOn,Model data) {
		
		TicketTracker ed=new TicketTracker(id, ticketTitle, ticketShortDiscription, ticketCreatedOn);
		service.add(ed);
		
		List<TicketTracker> ticketTracker=service.getAll();
		data.addAttribute("ticketTracker",ticketTracker);
		
		return "home"; 
		
	}
	@GetMapping("/searchfunction")
	public String search(@RequestParam String search,Model data) {
		
		List<TicketTracker> tt=service.search(search);
		data.addAttribute("ticketTracker",tt);
		return "home";
		 
	}  
	
	@GetMapping("/viewmethod")
	public String viewform(@RequestParam int id,Model data) {
		
		TicketTracker viewid=service.getById(id);
		if(viewid !=null) {
			data.addAttribute("viewid",viewid);
			return "viewTickets";
		}
		else {
			return "home";
		}
	}
	@PostMapping("/view-ticket-form")
	public String viewform(@RequestParam int id,@RequestParam String ticketTitle,@RequestParam String ticketShortDiscription,@RequestParam LocalDate ticketCreatedOn,Model data) {
		
		TicketTracker ed=new TicketTracker(id, ticketTitle, ticketShortDiscription, ticketCreatedOn);
		service.add(ed);
		
		List<TicketTracker> ticketTracker=service.getAll();
		data.addAttribute("ticketTracker",ticketTracker);
		
		return "home"; 
		
	}
	
}


