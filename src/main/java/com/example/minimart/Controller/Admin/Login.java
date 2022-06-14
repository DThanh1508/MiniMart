package com.example.minimart.Controller.Admin;

import com.example.minimart.Model.Admin;
import com.example.minimart.Model.ConnectDB;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Login {
    private void checkLogin(ConnectDB db,TextField name, TextField pass,Stage window,Scene scene3){
        ArrayList<Admin> admin;
        admin = db.getAdmin();
        String inputName = name.getText();
        String inputPass = pass.getText();
        if(inputName.equals(admin.get(0).name)&& inputPass.equals(admin.get(0).password)){
            LoginSuccess(name);
            window.setScene(scene3);
        }else{
            LoginError();
        }
    }
    private void LoginSuccess(TextField name) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Login");
        alert.setHeaderText("Hi "+name.getText()+" admin!");
        alert.setContentText("Login successfully!");
        alert.show();
    }
    private void LoginError() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("ERROR");
        alert.setContentText("Login fail!");
        alert.show();
    }
    public VBox pageLogin(Stage window, Scene scene1,ConnectDB db,Scene scene3){
        Label labelLogin =new Label("LOGIN");
        Label lbname = new Label("Admin name: ");
        Label lbpass = new Label("Password: ");
        TextField tfname = new TextField();
        TextField tfpass = new TextField();
        HBox fieldName = new HBox();
        fieldName.getChildren().addAll(lbname,tfname);
        fieldName.setSpacing(10);
        fieldName.setAlignment(Pos.BASELINE_CENTER);
        HBox fieldPass = new HBox();
        fieldPass.getChildren().addAll(lbpass,tfpass);
        fieldPass.setSpacing(10);
        fieldPass.setAlignment(Pos.BASELINE_CENTER);
        Button btnGoBack = new Button("GO HOME");
        btnGoBack.setOnAction(actionEvent -> {
            window.setScene(scene1);
        });
        Button btnLogin = new Button("LOGIN");
        btnLogin.setOnAction(actionEvent -> {
            checkLogin(db,tfname,tfpass,window,scene3);
        });
        HBox btnLoginPage = new HBox();
        btnLoginPage.getChildren().addAll(btnLogin,btnGoBack);
        btnLoginPage.setSpacing(10);
        btnLoginPage.setAlignment(Pos.BASELINE_CENTER);
        VBox loginPage = new VBox();
        loginPage.getChildren().addAll(labelLogin,fieldName,fieldPass,btnLoginPage);
        loginPage.setSpacing(15);
        loginPage.setAlignment(Pos.BASELINE_CENTER);
        return loginPage;
    }
}
