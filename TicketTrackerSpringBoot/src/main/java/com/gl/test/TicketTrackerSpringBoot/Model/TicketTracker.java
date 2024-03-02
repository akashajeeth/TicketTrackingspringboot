package com.gl.test.TicketTrackerSpringBoot.Model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketTracker {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String ticketTitle;
	private String ticketShortDiscription;
	private LocalDate ticketCreatedOn;

}
