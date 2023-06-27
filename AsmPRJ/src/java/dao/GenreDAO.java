/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.SQLServerConnection;
import entity.Genre;
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
public class GenreDAO {
     public List<Genre> getAllbyGenre() {

        String sql = "SELECT * FROM Genre";//

        try ( Connection connection = SQLServerConnection.getConnection();  PreparedStatement ps = connection.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();

            List<Genre> list = new ArrayList<>();//
            while (rs.next()) {
                 Genre g = Genre.builder()
                        .GenreId(rs.getInt("GenreId"))
                          .GenreName(rs.getString("GenreName"))
                        .build();
                list.add(g);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
     public static void main(String[] args) {
         System.out.println(new GenreDAO().getAllbyGenre());
    }
}
