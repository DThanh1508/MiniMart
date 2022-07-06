package com.example.minimart.Controller.Admin;

import com.example.minimart.Main;
import com.example.minimart.Model.ConnectDB;
import com.example.minimart.Model.Product;
import javafx.stage.Stage;

public class UpdatePro {
    private Stage stage ;
    public UpdatePro(Stage stage){
        this.stage = stage;
    }
    void updateProFunction(int Newid, String Newimage, int Newid_type, String Newname, int Newprice, String Newdes , ConnectDB DB){
        DB.updatePro(new Product( Newid, Newimage, Newid_type, Newname, Newprice, Newdes));
        try {
            new Main().start(this.stage);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
