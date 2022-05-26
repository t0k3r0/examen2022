package eus.birt.dam.bootstrap;

import eus.birt.dam.domain.Categoria;
import eus.birt.dam.domain.Producto;
import eus.birt.dam.repository.productoRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

  @Autowired private productoRepository productoRepository;

  @Override
  public void run(String... args) throws Exception {

    productoRepository.deleteAll();

    Categoria apple = new Categoria(new ObjectId().toString(), "Apple");
    Categoria huawei = new Categoria(new ObjectId().toString(), "Huawei");

    productoRepository.save(new Producto(
        "Iphone 13 Pro", "146,7x71,5x7,65 mm 204 gramos", "1000 €", apple));
    productoRepository.save(new Producto(
        "P30 lite", "107,2x61,4x5,63 mm 188 gramos", "120 €", huawei));
    productoRepository.save(new Producto(
        "Iphone 12", "137,7x61,5x5,55 mm 187 gramos", "890 €", apple));
    productoRepository.save(new Producto(
        "P30 Pro", "107,2x61,4x5,63 mm 188 gramos", "75 €", huawei));

    System.out.println("Productos encontrados con findAll():");
    System.out.println("-------------------------------");
    for (Producto producto : productoRepository.findAll()) {
      System.out.println(producto);
    }
  }
}