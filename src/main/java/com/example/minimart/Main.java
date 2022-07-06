package com.example.minimart;

import com.example.minimart.Controller.Admin.AddPro;
import com.example.minimart.Controller.Admin.ShowPro;
import com.example.minimart.Model.ConnectDB;
import com.example.minimart.Model.Product;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(10);
        ConnectDB DB = new ConnectDB();
        ArrayList<Product> productList = DB.getProduct();

        grid.add(new Label("Image"), 3, 0);
        grid.add(new Label("Image:"), 0, 2);
        var tfImage = new TextField();
        grid.add(tfImage, 1, 2);
        //
        grid.add(new Label("Type"),4,0);
        grid.add(new Label("Type:"),0,3);
        var tfIdType = new TextField();
        grid.add(tfIdType,1,3);
        //
        grid.add(new Label("Product name"), 5, 0);
        grid.add(new Label("Product name:"), 0, 4);
        var tfName = new TextField();
        grid.add(tfName, 1, 4);
        //
        grid.add(new Label("Price"), 6, 0);
        grid.add(new Label("Price:"), 0, 5);
        var tfPrice = new TextField();
        grid.add(tfPrice, 1, 5);
        //
        grid.add(new Label("Description"),7,  0);
        grid.add(new Label("Description:"),0,  6);
        var tfDes = new TextField();
        grid.add(tfDes, 1, 6);
        //


        // add
        var btnAdd = new Button("Add");
        ShowPro showPro = new ShowPro(stage);
        showPro.showPro(productList,grid,btnAdd,DB);
        btnAdd.setPadding(new Insets(5, 15, 5, 15));
        btnAdd.setOnAction(e -> {
            String image = tfImage.getText();
            Integer id_type = Integer.valueOf(tfIdType.getText());
            String name = tfName.getText();
            Integer price = 0;
            try {
                price = Integer.parseInt(tfPrice.getText());
            } catch (Exception ex) {

            }
            String des = tfDes.getText();

            var addPro = new AddPro(stage);
            addPro.addProFunction(image,id_type,name,price,des,DB);
        });
        grid.add(btnAdd, 1, 7);

        Scene scene = new Scene(grid, 1500, 700);
        stage.setTitle("Products");
        stage.setScene(scene);
        stage.show();
    }
}
