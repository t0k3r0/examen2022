package eus.birt.dam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import eus.birt.dam.domain.Cyclist;
import eus.birt.dam.repository.CyclistRepository;


@RestController
@RequestMapping ("api/cyclists")
public class CyclistController {
		
	@Autowired
	CyclistRepository cyclistRepository;
		
	@GetMapping({"/",""})
	public List <Cyclist> index() {
		return cyclistRepository.findAll();
	}
	
	/*@GetMapping("/{id}")
	public Cyclist showById(@PathVariable("id") String id) {
		return cyclistRepository.findById(id).orElse(null);
	}*/
	
	//Otra opción es usar el nombre como elemento de búsqueda en el EndPoint
	//Se crea el método findByFirstName en CyclistRepository (solamente cabecera es suficiente)
		
	@GetMapping("/{name}")
	public List <Cyclist> showByName(@PathVariable("name") String name) {
		return cyclistRepository.findByFirstName(name);
	}
	
	@PostMapping({"/",""})
	@ResponseStatus (HttpStatus.CREATED)
	public Cyclist create(@RequestBody Cyclist cyclist) {
		return cyclistRepository.save(cyclist);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus (HttpStatus.CREATED)
	public Cyclist update(@RequestBody Cyclist cyclist, @PathVariable("id") String id) {
		Cyclist tempCyclist = cyclistRepository.findById(id).orElse(null);
		
		tempCyclist.setFirstName(cyclist.getFirstName());
		tempCyclist.setLastName(cyclist.getLastName());
		tempCyclist.setBirthDate(cyclist.getBirthDate());
		tempCyclist.setNationality(cyclist.getNationality());
		tempCyclist.setTeam(cyclist.getTeam());
		
		return cyclistRepository.save(tempCyclist);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus (HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		cyclistRepository.deleteById(id);
	}
	
}