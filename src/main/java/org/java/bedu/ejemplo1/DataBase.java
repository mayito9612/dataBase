package org.java.bedu.ejemplo1;

import java.util.LinkedList;
import java.util.List;

public class DataBase {
    private List<Product> db;

    public DataBase(){
        db = new LinkedList<>();
    }

    public void insert(Product data) {
        db.add(data);
    }

    public int size() {
        return db.size();
    }

    public Product getById(long id) {
        for (Product product : db) {
            if (product.getId() == id) {
                return product;
            }
        }

        return null;
    }

    public void clear() {
        db.clear();
    }
}
