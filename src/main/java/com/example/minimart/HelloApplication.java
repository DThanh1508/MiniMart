package com.example.minimart;

import com.example.minimart.Controller.Admin.Login;
import com.example.minimart.Model.Admin;
import com.example.minimart.Model.ConnectDB;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HelloApplication extends Application {
    Stage window;
    TextField name, pass;
    Scene scene1, scene2, scene3;



    @Override
    public void start(Stage primaryStage) throws IOException {
        ConnectDB db = new ConnectDB();
        db.getAdmin();
        //Scene1
        Label labelStart =new Label("Welcome to DENDEN pharmacy");
        Button btnStart = new Button("Let's start");
        VBox layout1 = new VBox();
        layout1.setAlignment(Pos.BASELINE_CENTER);
        btnStart.setOnAction(actionEvent -> {
            window.setScene(scene2);
        });
        layout1.getChildren().addAll(labelStart,btnStart);
        layout1.setSpacing(10);

        //Scene2
        Login lg = new Login();
        VBox loginPage =  lg.pageLogin(window,scene1,db,scene3);
        window = primaryStage;
        window.setScene(scene2);


        //show up
        scene1 = new Scene(layout1, 300, 300);
        scene2 = new Scene(loginPage,300, 300);
        window = primaryStage;
        window.setScene(scene1);
        window.show();
    }

    public static void main(String[] args) {
        launch();
    }
}