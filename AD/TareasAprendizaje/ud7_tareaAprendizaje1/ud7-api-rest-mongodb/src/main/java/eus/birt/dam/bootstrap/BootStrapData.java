package eus.birt.dam.bootstrap;

import java.time.LocalDate;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import eus.birt.dam.domain.Cyclist;
import eus.birt.dam.domain.Team;
import eus.birt.dam.repository.CyclistRepository;


@Component
public class BootStrapData implements CommandLineRunner{
	
	@Autowired
	private CyclistRepository cyclistRepository;
	
	
	@Override
	public void run(String... args) throws Exception {

	  cyclistRepository.deleteAll();
      
	  Team team1 = new Team(new ObjectId().toString(),"Ineos","Manchester","UK","Dave Brailsford");
	  Team team2 = new Team(new ObjectId().toString(),"Movistar","Iruñea","Spain","Eusebio Unzue");
	 
	  cyclistRepository.save(new Cyclist("Geraint", "Thomas", LocalDate.parse("1986-05-25"), "UK",team1));
	  cyclistRepository.save(new Cyclist("Enric", "Mas", LocalDate.parse("1995-01-07"), "Spain",team2));
	  cyclistRepository.save(new Cyclist("Egan", "Bernal", LocalDate.parse("1997-01-13"), "Colombia",team1));
	  
	  System.out.println("Cyclists found with findAll():");
	  System.out.println("-------------------------------");
	  for (Cyclist cyclist : cyclistRepository.findAll()) {
      System.out.println(cyclist);
	    }

	  }
	
}