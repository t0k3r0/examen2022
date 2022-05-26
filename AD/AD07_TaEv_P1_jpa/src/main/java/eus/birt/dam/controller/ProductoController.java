package eus.birt.dam.controller;

import eus.birt.dam.domain.Producto;
import eus.birt.dam.repository.ProductoRepository;
import java.util.List;
import javax.annotation.PreDestroy;
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

@RestController
@RequestMapping("api/producto")                                                                   // ruta en localhost (en nuestro caso)
public class ProductoController {

  @Autowired ProductoRepository productoRepository;                                               // autocablear con productoRepository

  @GetMapping({"/", ""})                                                                          // metodo GET con findAll, equivalente a SELECT * FROM producto
  public List<Producto> index() {
    return productoRepository.findAll();
  }

  @GetMapping("/{id}")                                                                            // metodo GET por id, para mostrar un producto
  public Producto show(@PathVariable("id") Long id) {
    return productoRepository.findById(id).orElse(null);
  }

  @PostMapping("/")                                                                               // metodo POST para crear un producto
  @ResponseStatus(HttpStatus.CREATED)
  public Producto create(@RequestBody Producto producto) {
    return productoRepository.save(producto);
  }

  @PutMapping("/{id}")                                                                            // metodo PUT por id, que sobreescribe todos los campos esten o no esten editados
  @ResponseStatus(HttpStatus.CREATED)
  public Producto update(@RequestBody Producto producto,
                         @PathVariable("id") Long id) {
    Producto tempProducto = productoRepository.findById(id).orElse(null);

    tempProducto.setNombre(producto.getNombre());
    tempProducto.setDescripcion(producto.getDescripcion());
    tempProducto.setPrecio(producto.getPrecio());
    tempProducto.setCategoria(producto.getCategoria());

    return productoRepository.save(tempProducto);
  }

  @DeleteMapping("/{id}")                                                                         // metodo DELETE por id para eliminar un producto
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable("id") Long id) {
    productoRepository.deleteById(id);
  }

  @PreDestroy                                                                                     // eliminar todos los datos precargando, para evitar errores
  public void removeData() {
    productoRepository.deleteAll();
  }
}