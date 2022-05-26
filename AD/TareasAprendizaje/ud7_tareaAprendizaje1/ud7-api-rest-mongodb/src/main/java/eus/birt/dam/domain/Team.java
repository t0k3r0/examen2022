package eus.birt.dam.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Team  {
	
	private String id;
	
	private String name;
	
	private String city;
	
	private String nationality;
	
	private String manager;

	public Team(String name, String city, String nationality, String manager) {
		super();
		this.name = name;
		this.city = city;
		this.nationality = nationality;
		this.manager = manager;
	}

	
}