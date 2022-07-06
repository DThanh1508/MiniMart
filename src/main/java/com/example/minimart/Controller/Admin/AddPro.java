package com.example.minimart.Controller.Admin;

import com.example.minimart.Main;
import com.example.minimart.Model.ConnectDB;
import com.example.minimart.Model.Product;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AddPro {
    private Stage stage;
    public AddPro(Stage stage){
        this.stage = stage;
    }
    public void addProFunction(String image, int id_type, String name, int price, String des, ConnectDB DB){
        DB.insertPro(new Product( image, id_type, name, price, des));
//        System.out.println(image);
//        System.out.println(id_type);
//        System.out.println(name);
//        System.out.println(price);
//        System.out.println(des);
        try {
            new Main().start(this.stage);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
