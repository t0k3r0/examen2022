package eus.birt.dam.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("productos")
public class Producto {

  @Id private String id;

  private String name;

  private String descripcion;

  private String precio;

  private Categoria categoria;

  public Producto(String name, String descripcion, String precio,
                  Categoria categoria) {
    super();
    this.name = name;
    this.descripcion = descripcion;
    this.precio = precio;
    this.categoria = categoria;
  }

  @Override
  public String toString() {
    return String.format(
        "Producto[id=%s, name='%s', descripcion='%s',precio='%s',  categoria='%s']",
        id, name, descripcion, precio, categoria);
  }
}
