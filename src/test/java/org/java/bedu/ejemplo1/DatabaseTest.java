package org.java.bedu.ejemplo1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DatabaseTest {

    //Arrange
    private DataBase db;

    @BeforeEach
    public void setup(){
        db = new DataBase();
    }
    @Test
    @DisplayName("el tamaño de la base de datos nueva el tamaño es 0")
    public void sizeZero(){
        assertEquals(db.size(), 0);
    }
    @Test
    @DisplayName("Se inserto en la BD")
    public void insert(){
        db.insert(new Product(1, "Coca cola"));
        db.insert(new Product(2, "Gansito"));

        assertEquals(db.size(), 2);
    }
    @Test
    @DisplayName("Se inserto en la BD")
    public void findById(){
        db.insert(new Product(1, "Coca cola"));
        db.insert(new Product(2, "Gansito"));
        db.insert(new Product(3, "Mordisco"));
        db.insert(new Product(4, "Gansito"));

        Product p = db.getById(3);
        assertEquals(p.getId(), 3);
        assertEquals(p.getName(), "Mordisco");
    }
    @Test
    @DisplayName("Eliminar por id")
    public void removeById() {
        db.insert(new Product(1, "Coca Cola"));
        db.insert(new Product(2, "Gansito"));
        db.insert(new Product(3, "Mordisko"));

        Product p = db.removeById(2);

        assertEquals(p.getId(), 2);
        assertEquals(p.getName(), "Gansito");
        assertEquals(db.size(), 2);
    }

    @Test
    @DisplayName("modificar por id")
    public void updateById() {
        db.insert(new Product(1, "Coca Cola"));
        db.insert(new Product(2, "Gansito"));
        db.insert(new Product(3, "Mordisko"));

        db.updateById(3, new Product(3, "Mordisko"));

        assertEquals(db.getById(3).getId(), 3);
        assertEquals(db.getById(3).getName(), "Mordisko");
    }

}
