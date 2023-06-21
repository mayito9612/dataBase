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

    public Product removeById(long id) {
    //Product product = db.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
        for (Product product : db) {
            if (product != null) {
                db.remove(product);
                return product;
            }
        }
        return null;
    }

    public void updateById(long id, Product product) {
        for (Product p : db) {
            if (p.getId() == id) {
                p.setName(product.getName());
                break;
            }
        }
    }
    public void clear() {
        db.clear();
    }
}
