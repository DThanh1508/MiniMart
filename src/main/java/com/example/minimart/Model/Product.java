package com.example.minimart.Model;

public class Product {
    public int id;
    public String image;
    public int id_type;
    public String proName;
    public String price;
    public String des;

    public Product (int id, String image, int id_type, String proName, String price, String des) {
        this.id = id;
        this.image = image;
        this.id_type = id_type;
        this.proName = proName;
        this.price = price;
        this.des = des;
    }

    public Product (String image, int id_type, String proName, String price, String des) {
        this.image = image;
        this.id_type = id_type;
        this.proName = proName;
        this.price = price;
        this.des = des;
    }

    public int getId() {return id;}
    public void setId(int name) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }

    public int getId_type() {return id_type;}
    public void setId_type(int name) {
        this.id_type = id_type;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}