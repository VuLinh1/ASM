/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.SQLServerConnection;
import entity.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class ProductDao {
     public List<Product> getAllByFeatured() {

        String sql = "SELECT * FROM Product Where productIsFeatured = 1";//

        try ( Connection connection = SQLServerConnection.getConnection();  PreparedStatement ps = connection.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();

            List<Product> list = new ArrayList<>();//
            while (rs.next()) {
                Product s = Product.builder()
                        .productId(rs.getInt("productId"))
                        .productName(rs.getString("productName"))
                        .AuthorName(rs.getString("AuthorName"))
                        .productImg(rs.getString("productImg"))
                        .productPrice(rs.getInt("productPrice"))
                        .productDescription(rs.getString("productDescription"))
                        .GenreId(rs.getInt("GenreId"))
                        .productIsFeatured(rs.getBoolean("productIsFeatured"))
                        .productIsSaleOff(rs.getBoolean("productIsSaleOff"))
                        .productDeleted(rs.getBoolean("productDeleted"))
                        .build();
                list.add(s);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    public static void main(String[] args) {
       
        System.out.println(new ProductDao().getAllBySaleOff());
    }
     public List<Product> getAllBySaleOff() {

        String sql = "SELECT * FROM Product Where productIsSaleOff = 0";//

        try ( Connection connection = SQLServerConnection.getConnection();  PreparedStatement ps = connection.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();

            List<Product> list = new ArrayList<>();//
            while (rs.next()) {
                 Product s = Product.builder()
                        .productId(rs.getInt("productId"))
                        .productName(rs.getString("productName"))
                        .AuthorName(rs.getString("AuthorName"))
                        .productImg(rs.getString("productImg"))
                        .productPrice(rs.getInt("productPrice"))
                        .productDescription(rs.getString("productDescription"))
                        .GenreId(rs.getInt("GenreId"))
                        .productIsFeatured(rs.getBoolean("productIsFeatured"))
                        .productIsSaleOff(rs.getBoolean("productIsSaleOff"))
                        .productDeleted(rs.getBoolean("productDeleted"))
                        .build();
                list.add(s);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
}
