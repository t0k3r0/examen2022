package eus.birt.dam.domain;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document ("cyclists")
public class Cyclist  {
	
	@Id
	private String id; //Puede ser también ObjectId o BigInt
	
	private String firstName;
	
	private String lastName;
	
	@DateTimeFormat (pattern = "yyyy-MM-dd")
	private LocalDate birthDate;
	
	private String nationality;
	
	private Team team;
	

	public Cyclist(String firstName, String lastName, LocalDate birthDate, String nationality, Team team) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.nationality = nationality;
		this.team = team;
	}
	
	@Override
	  public String toString() {
	    return String.format(
	        "Cyclist[id=%s, firstName='%s', lastName='%s', birthDate='%s', nationality='%s']",
	        id, firstName, lastName, birthDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), nationality);
	  }
	
}
