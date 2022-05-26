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

import eus.birt.dam.domain.Producto;
import eus.birt.dam.repository.productoRepository;


@RestController
@RequestMapping ("api/productos")
public class ProductoController {
		
	@Autowired
	productoRepository productoRepository;
		
	@GetMapping({"/",""})
	public List <Producto> index() {
		return productoRepository.findAll();
	}
	

		
	@GetMapping("/{name}")
	public List <Producto> showByName(@PathVariable("name") String name) {
		return productoRepository.findByName(name);
	}
	
	@PostMapping({"/",""})
	@ResponseStatus (HttpStatus.CREATED)
	public Producto create(@RequestBody Producto producto) {
		return productoRepository.save(producto);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus (HttpStatus.CREATED)
	public Producto update(@RequestBody Producto producto, @PathVariable("id") String id) {
		Producto tempProducto = productoRepository.findById(id).orElse(null);
		
		tempProducto.setName(producto.getName());
		tempProducto.setDescripcion(producto.getDescripcion());
		tempProducto.setPrecio(producto.getPrecio());
		tempProducto.setCategoria(producto.getCategoria());
		
		return productoRepository.save(tempProducto);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus (HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		productoRepository.deleteById(id);
	}
	
}
