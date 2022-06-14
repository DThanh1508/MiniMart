package com.example.minimart.Controller.Admin;

import com.example.minimart.Model.ConnectDB;
import com.example.minimart.Model.Product;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.util.List;

public class ShowPro {
//    private void showPro(){
//        //show
//        for(int i = 0; i < paintingList.size(); i++){
//
//            Image image = new Image(paintingList.get(i).getImage());
//            ImageView imageView = new ImageView();
//            imageView.setImage(image);
//            imageView.setFitWidth(90);
//            imageView.setFitHeight(90);
//            grid.add(imageView, 0, i+2);
//
//            grid.add(new Label(String.valueOf(paintingList.get(i).getId_type())),1,i+2);
//            grid.add(new Label (paintingList.get(i).getProName()), 2, i+2);
//            grid.add(new Label ("$"+ paintingList.get(i).getPrice()), 3, i+2);
//            grid.add(new Label (paintingList.get(i).getDes()), 4, i+2);
//    }

//    public void getProductsDisplay(ConnectDB db, VBox vBox){
//        Label id = new Label("Id_product");
//        Label nameProduct = new Label("Name");
//        Label NSX = new Label("NSX");
//        Label ingredient = new Label("Ingredient");
//        Label instruction = new Label("Instruction");
//        Label edit = new Label("EDIT");
//        Label delete = new Label("DELETE");
//        GridPane table = new GridPane();
//        table.setMinSize(400, 200);
//        table.setPadding(new Insets(10, 10, 10, 10));
//        table.setVgap(10);
//        table.setHgap(10);
//        table.setAlignment(Pos.CENTER);
//        table.addRow(0,id,nameProduct,NSX,ingredient,instruction, edit,delete);
//        List<Product> listProducts = db.getProduct();
//        for(int i=0; i<listProducts.size();i++){
//            Label idPro = new Label(""+listProducts.get(i).id);
//            Label id_type = new Label(listProducts.get(i).id_type);
//            Label proName = new Label(listProducts.get(i).proName);
//            Label price = new Label(listProducts.get(i).price);
//            Label des = new Label(listProducts.get(i).des);
//            System.out.println(id_type);
////            Button btnEdit = new Button("EDIT");
////            btnEdit.setId(String.valueOf(listProducts.get(i).id));
////            int finalI = i;
////            btnEdit.setOnAction((ActionEvent e)->{
////                updateProduct(db, vBox,listProducts.get(finalI).id,listProducts.get(finalI).name,listProducts.get(finalI).NSX,listProducts.get(finalI).ingredient,listProducts.get(finalI).instruction);
////            });
////            Button btnDelete = new Button("DELETE");
////            btnDelete.setId(String.valueOf(listProducts.get(i).id));
////            btnDelete.setOnAction((ActionEvent e)->{
////                deleteProduct(db,Integer.parseInt(btnDelete.getId()),vBox);
////            });
////            table.addRow(i+1,idPro,namePro,NSXpro,ingre,instruct,btnEdit,btnDelete);
//        }
//        vBox.getChildren().addAll(table);
//    }

}


