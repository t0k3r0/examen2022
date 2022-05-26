package eus.birt.dam.controller;

import eus.birt.dam.domain.Categoria;
import eus.birt.dam.repository.CategoriaRepository;
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
@RequestMapping("api/categoria")                                                          // ruta en localhost (en nuestro caso)
public class CategoriaController {

  @Autowired CategoriaRepository categoriaRepository;                                     // autocablear con categoriaRepository      

  @GetMapping({"/", ""})                                                                  // metodo GET con findAll, equivalente a SELECT * FROM categoria
  public List<Categoria> index() {
    return categoriaRepository.findAll();
  }

  @GetMapping("/{id}")                                                                    // metodo GET por id, para mostrar una categoria
  public Categoria show(@PathVariable("id") Long id) {
    return categoriaRepository.findById(id).orElse(null);
  }

  @PostMapping("/")                                                                       // metodo POST para crear una categoria
  @ResponseStatus(HttpStatus.CREATED)
  public Categoria create(@RequestBody Categoria categoria) {
    return categoriaRepository.save(categoria);
  }

  @PutMapping("/{id}")                                                                    // metodo PUT por id, que sobreescribe todos los campos esten o no esten editados
  @ResponseStatus(HttpStatus.CREATED)
  public Categoria update(@RequestBody Categoria categoria,
                          @PathVariable("id") Long id) {
    Categoria tempCategoria = categoriaRepository.findById(id).orElse(null);

    tempCategoria.setNombre(categoria.getNombre());

    return categoriaRepository.save(tempCategoria);
  }

  @DeleteMapping("/{id}")                                                                 // metodo DELETE por id para eliminar una categoria
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable("id") Long id) {
    categoriaRepository.deleteById(id);
  }

  @PreDestroy                                                                             // eliminar todos los datos precargando, para evitar errores
  public void removeData() {
    categoriaRepository.deleteAll();
  }
}
