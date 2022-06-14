package com.example.minimart;

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

        grid.add(new Label("Image:"), 0, 0);
        var tfImage = new TextField();
        grid.add(tfImage, 0, 1);
        //
        grid.add(new Label("Type:"),1,0);
        var tfIdType = new TextField();
        grid.add(tfIdType,1,1);
        //
        grid.add(new Label("Product name:"), 2, 0);
        var tfName = new TextField();
        grid.add(tfName, 2, 1);
        //
        grid.add(new Label("Price:"), 3, 0);
        var tfPrice = new TextField();
        grid.add(tfPrice, 3, 1);
        //
        grid.add(new Label("Description:"),4,  0);
        var tfDes = new TextField();
        grid.add(tfDes, 4, 1);
        //

        // add51
        var btnAdd = new Button("Add");
        btnAdd.setPadding(new Insets(5, 15, 5, 15));
        btnAdd.setOnAction(e -> {
            String image = tfImage.getText();
            Integer id_type = Integer.valueOf(tfIdType.getText());
            String name = tfName.getText();
            String price = tfPrice.getText();
            String des = tfDes.getText();
            DB.insertPro(new Product( image, id_type, name, price, des));
            try {
                start(stage);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
        grid.add(btnAdd, 5, 1);

        //show
        for(int i = 0; i < productList.size(); i++){

            Image image = new Image(productList.get(i).getImage());
            ImageView imageView = new ImageView();
            imageView.setImage(image);
            imageView.setFitWidth(90);
            imageView.setFitHeight(90);
            grid.add(imageView, 0, i+2);

            grid.add(new Label(String.valueOf(productList.get(i).getId_type())),1,i+2);
            grid.add(new Label (productList.get(i).getProName()), 2, i+2);
            grid.add(new Label ("$"+ productList.get(i).getPrice()), 3, i+2);
            grid.add(new Label (productList.get(i).getDes()), 4, i+2);

            // Update
            var btnUpdate = new Button("Update");
            btnUpdate.setId(String.valueOf(i));
            btnUpdate.setOnAction(e -> {
                btnAdd.setVisible(false);
                int id1 = Integer.parseInt(btnUpdate.getId());
                TextField tfimage = (TextField) grid.getChildren().get(1);
                tfimage.setText("" + productList.get(id1).getImage());

                TextField tfid_type = (TextField) grid.getChildren().get(3);
                tfid_type.setText("" + productList.get(id1).getId_type());

                TextField tfname = (TextField) grid.getChildren().get(5);
                tfname.setText("" + productList.get(id1).getProName());

                TextField tfprice = (TextField) grid.getChildren().get(7);
                tfprice.setText("" + productList.get(id1).getPrice());

                TextField tfdes = (TextField) grid.getChildren().get(9);
                tfdes.setText("" + productList.get(id1).getDes());
                var newbtnAdd = new Button("Update");
                newbtnAdd.setPadding(new Insets(5, 15, 5, 15));
                newbtnAdd.setOnAction(newe -> {
                    int Newid = productList.get(id1).id;
                    String Newimage = tfimage.getText();
                    int Newid_type = Integer.parseInt(tfid_type.getText());
                    String Newname = tfname.getText();
                    String Newprice = tfprice.getText();
                    String Newdes = tfdes.getText();
                    DB.updatePro(new Product( Newid, Newimage, Newid_type, Newname, Newprice, Newdes));
                    try {
                        start(stage);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                });
                grid.add(newbtnAdd, 5, 1);
            });
            grid.add(btnUpdate, 5, i+2);

            // Delete
            var btnDelete = new Button("Delete");
            btnDelete.setId(String.valueOf(productList.get(i).id));
            btnDelete.setOnAction(e -> {
                int id3 = Integer.parseInt(btnDelete.getId());
                DB.deletePro(id3);
                var alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("Deleted!");
                alert.showAndWait();
                try {
                    start(stage);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            });
            grid.add(btnDelete, 6, i+2);
        }

        Scene scene = new Scene(grid, 1500, 1000);
        stage.setTitle("Products");
        stage.setScene(scene);
        stage.show();
    }
}
