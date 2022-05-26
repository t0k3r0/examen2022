package eus.birt.dam.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Categoria {

  private String id;

  private String nombre;

  public Categoria(String nombre) {
    super();
    this.nombre = nombre;
  }
}