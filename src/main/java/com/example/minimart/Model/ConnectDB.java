package com.example.minimart.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectDB {
    private Connection connection;

    public ConnectDB() {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/minimart",
                    "root",
                    ""
            );
            System.out.println("Connected Database");
        } catch (Exception e) {
            connection = null;
            System.out.println(e);
        }

    }
    public List<Admin> getAdmin(){
        ArrayList<Admin> admins = new ArrayList<>();
        try {
            var result = connection.prepareStatement("Select * from admin").executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                String password = result.getString("password");
                System.out.println(id);
                System.out.println(name);
                System.out.println(password);
                admins.add(new Admin(id, name,password));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return admins;
    }
    public List<Product> getProduct(){
        ArrayList<Product> product = new ArrayList<>();
        try {
            var result = connection.prepareStatement("Select * from products").executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                String image = result.getString("image");
                int id_type = result.getInt("id_type");
                String proName = result.getString("proName");
                Float price = result.getFloat("price");
                String des = result.getString("des");
                System.out.println(id);
                System.out.println(id_type);
                System.out.println(proName);
                System.out.println(price);
                System.out.println(des);
                product.add(new Product(id, image, id_type,proName,price,des));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return product;
    }
    void insertPro(Product product){
        String sql = "INSERT INTO products(id_type,proName,price,des) VALUES(" +product.id_type+ ","+product.proName+","+product.price+","+product.des+")";
        System.out.println(sql);
        try {
            connection.prepareStatement(sql).executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    void updatePro(Product product){
        String sql= "UPDATE products SET id_type="+product.id_type+",proName="+product.proName+",price="+product.price+",des="+product.des+" WHERE id="+product.id;
        System.out.println(sql);
        try {
            connection.prepareStatement(sql).executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    void DeletePro(int  id){
        String sql= "DELETE FROM products WHERE id="+id+"" ;
        System.out.println(sql);
        try {
            connection.prepareStatement(sql).executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}