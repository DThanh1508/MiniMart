package com.example.minimart.Model;

public class Product {
    public int id;
    public String image;
    public int id_type;
    public String proName;
    public float price;
    public String des;

    public Product(int id, String image, int id_type, String proName, float price, String des) {
        this.id = id;
        this.image = image;
        this.id_type = id_type;
        this.proName = proName;
        this.price = price;
        this.des = des;
    }
}
