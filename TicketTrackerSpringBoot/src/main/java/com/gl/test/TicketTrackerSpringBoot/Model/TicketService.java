package com.gl.test.TicketTrackerSpringBoot.Model;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
	@Autowired
	TicketRepo repo;
	
	//add function
	public void add(TicketTracker ticketTracker) {
		repo.save(ticketTracker);
	}
	//update function
	public void update(TicketTracker ticketTracker) {
		repo.save(ticketTracker);
	}
	//select all function
	public List<TicketTracker> getAll(){
		return repo.findAll();
	}
	//delete function
	public void delete(TicketTracker ticketTracker) {
		repo.delete(ticketTracker);
	}
	public TicketTracker getById(int id) {
		Optional<TicketTracker> tic=repo.findById(id);
		TicketTracker temp=null;
		if(tic.get()!=null) {
			temp=tic.get();
		}
		return temp;
	}
	
	//search the data 
	public List<TicketTracker> search(String searchkey) {

		// 1.create a dummy object based on the searchKey
		TicketTracker dummy = new TicketTracker();
		dummy.setTicketTitle(searchkey);

		// 2.Create example jpa-where
		ExampleMatcher em = ExampleMatcher.matching()
				.withMatcher("ticketTitle", ExampleMatcher.GenericPropertyMatchers.contains())
				.withIgnorePaths("id", "ticketShortDiscription", "ticketCreatedOn");

		// 3. combining Dummy with where
		Example<TicketTracker> example = Example.of(dummy, em);
		// System.out.println("here");
		return repo.findAll(example);
	}
	

}
