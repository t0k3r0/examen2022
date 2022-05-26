package eus.birt.dam.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import eus.birt.dam.domain.Producto;


public interface productoRepository extends MongoRepository<Producto, String>{
	
	List<Producto> findByName(String name);
	
}