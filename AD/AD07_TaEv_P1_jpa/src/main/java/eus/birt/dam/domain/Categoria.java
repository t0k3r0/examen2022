package eus.birt.dam.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categoria")
public class Categoria implements Serializable {

  private static final long serialVersionUID = 1L;										  // atributo identificador para serializar/deserializar un objeto de una clase serializable

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;

  private String nombre;

  @JsonManagedReference
  @OneToMany
  @JoinColumn(name = "categoria_id") 														// columna enlazada en la tabla producto
  List<Producto> productos = new ArrayList<>();

  public Categoria(String nombre) { 														// campos o columnas de la tabla categoria
    super();
    this.nombre = nombre;
  }
}
