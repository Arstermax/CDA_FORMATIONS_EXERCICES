package org.example.observer;

import org.example.Observer;
import org.example.Product;

public class StockManager implements Observer {

    @Override
    public void update(Product updateProduct) {

        System.out.println("Le stock à"+ updateProduct);
    }
}
