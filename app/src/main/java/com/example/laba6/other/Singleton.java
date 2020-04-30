package com.example.laba6.other;




//Класс Singleton нужен нам для того , чтобы передать наш массив данных из одного активити в другое

import java.util.List;

public class Singleton {
    private static Singleton singleObject;
    private List<ProductModel> items;

    public static Singleton getInstance() {
        if(singleObject == null)
        {
            singleObject = new Singleton();
        }
        return singleObject;
    }


    public void setItems(List<ProductModel> items) {
        this.items = items;
    }

    public List<ProductModel> getItems() {
        return items;
    }

    public ProductModel getItem(String name)
    {
        for(int i = 0; i < items.size(); i++)
        {
            if(items.get(i).getName().equals(name)) {
                return items.get(i);
            }
        }
        return null;
    }
}
