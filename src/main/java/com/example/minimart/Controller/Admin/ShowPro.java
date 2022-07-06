package com.example.minimart.Controller.Admin;

import com.example.minimart.Main;
import com.example.minimart.Model.ConnectDB;
import com.example.minimart.Model.Product;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


import java.util.ArrayList;
import java.util.List;

public class ShowPro {
    private Stage stage;
    public  ShowPro (Stage stage){
        this.stage = stage;
    }
    public void showPro(ArrayList<Product> productList, GridPane grid, Button btnAdd, ConnectDB DB){
        for(int i = 0; i < productList.size(); i++){

            Image image = new Image(productList.get(i).getImage());
            ImageView imageView = new ImageView();
            imageView.setImage(image);
            imageView.setFitWidth(50);
            imageView.setFitHeight(50);
            grid.add(imageView, 3, i+2);

            grid.add(new Label(String.valueOf(productList.get(i).getId_type())),4,i+2);
            grid.add(new Label (productList.get(i).getProName()), 5, i+2);
            grid.add(new Label (productList.get(i).getPrice()+".000 VNĐ/Kg"), 6, i+2);
            grid.add(new Label (productList.get(i).getDes()), 7, i+2);

            // Update
            var btnUpdate = new Button("Update");
            btnUpdate.setId(String.valueOf(i));
            btnUpdate.setOnAction(e -> {
                btnAdd.setVisible(false);
                int id1 = Integer.parseInt(btnUpdate.getId());
                TextField tfimage = (TextField) grid.getChildren().get(2);
                tfimage.setText("" + productList.get(id1).getImage());

                TextField tfid_type = (TextField) grid.getChildren().get(5);
                tfid_type.setText("" + productList.get(id1).getId_type());

                TextField tfname = (TextField) grid.getChildren().get(8);
                tfname.setText("" + productList.get(id1).getProName());

                TextField tfprice = (TextField) grid.getChildren().get(11);
                tfprice.setText("" + productList.get(id1).getPrice());

                TextField tfdes = (TextField) grid.getChildren().get(14);
                tfdes.setText("" + productList.get(id1).getDes());
                var newbtnAdd = new Button("Update ne");
                newbtnAdd.setPadding(new Insets(5, 15, 5, 15));
                newbtnAdd.setOnAction(newe -> {
                  var updatePro = new UpdatePro(stage);
                  updatePro.updateProFunction(productList.get(id1).getId(),tfimage.getText(),
                          Integer.parseInt(tfid_type.getText()),
                          tfname.getText(),Integer.parseInt(tfprice.getText()),tfdes.getText(),DB);
                });
                grid.add(newbtnAdd, 1, 7);
            });
            grid.add(btnUpdate, 8, i+2);

            // Delete
            var btnDelete = new Button("Delete");
            btnDelete.setId(String.valueOf(productList.get(i).id));
            btnDelete.setOnAction(e -> {
                int id3 = Integer.parseInt(btnDelete.getId());
                var delete = new DeletePro(stage);
                delete.deleteF(id3,DB);
            });
            grid.add(btnDelete, 9, i+2);
        }
    }
}


