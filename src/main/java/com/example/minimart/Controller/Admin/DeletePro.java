package com.example.minimart.Controller.Admin;

import com.example.minimart.Main;
import com.example.minimart.Model.ConnectDB;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class DeletePro {
    private Stage stage;
    public DeletePro(Stage stage){
        this.stage=stage;
    }
    public void deleteF(int id3, ConnectDB DB){
        DB.deletePro(id3);
        var alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("Deleted!");
        alert.showAndWait();
        try {
            new Main().start(this.stage);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
