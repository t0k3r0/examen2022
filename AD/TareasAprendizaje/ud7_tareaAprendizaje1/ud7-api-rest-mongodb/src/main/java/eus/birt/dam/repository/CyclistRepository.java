package eus.birt.dam.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import eus.birt.dam.domain.Cyclist;


public interface CyclistRepository extends MongoRepository<Cyclist, String>{
	
	List<Cyclist> findByFirstName(String name);
	
}