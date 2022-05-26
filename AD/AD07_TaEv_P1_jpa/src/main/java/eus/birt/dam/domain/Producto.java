package eus.birt.dam.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "producto")
public class Producto implements Serializable {

  private static final long serialVersionUID = 1L;                                  // atributo identificador para serializar/deserializar un objeto de una clase serializable

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;

  @Column(name = "nombre") private String nombre;

  @Column(name = "descripcion") private String descripcion;

  @Column(name = "precio") private String precio;

  @JsonBackReference
  @ManyToOne
  @JoinColumn(name = "categoria_id")                                                // insertar columna enlazada desde la tabla categoria
  private Categoria categoria;

  public Producto(String nombre, String descripcion, String precio,
                  Categoria categoria) {                                            // campos o columnas de la tabla producto
    super();
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.precio = precio;
    this.categoria = categoria;
  }
}
