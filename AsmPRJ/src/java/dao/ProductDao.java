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

    public List<Product> getListProductPerPage(int numberProductPerPage, int pageCur, String priceFrom, String priceTo) {

        String sql = ""
                + "Select DISTINCT\n"
                + "	p.productId,\n"
                + "	p.productName,\n"
                + "	p.productImg,\n"
                + "	p.AuthorName,\n"
                + "	p.productPrice,\n"
                + "	p.productDescription,\n"
                + "	p.GenreId,\n"
                + "	p.productIsFeatured,\n"
                + "	p.productIsSaleOff,\n"
                + "	p.productDeleted\n"
                + "from product p \n"
                + " Where p.productPrice between ? and ? ";
        sql += " Order BY p.productId\n"
                + "OFFSET ? ROWS \n"
                + "FETCH NEXT ? ROWS ONLY";
        try ( Connection connection = SQLServerConnection.getConnection();  PreparedStatement ps = connection.prepareStatement(sql);) {
            ps.setObject(1, priceFrom);
            ps.setObject(2, priceTo);
            ps.setObject(3, pageCur * numberProductPerPage - numberProductPerPage);
            ps.setObject(4, numberProductPerPage);
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

    public List<Product> getListProductPerPageBygenreId(int numberProductPerPage, int pageCur, int genreId, String priceFrom, String priceTo) {

        String sql = ""
                + "Select DISTINCT\n"
                + "	p.productId,\n"
                + "	p.productName,\n"
                + "	p.productImg,\n"
                + "	p.AuthorName,\n"
                + "	p.productPrice,\n"
                + "	p.productDescription,\n"
                + "	p.GenreId,\n"
                + "	p.productIsFeatured,\n"
                + "	p.productIsSaleOff,\n"
                + "	p.productDeleted\n"
                + "from product p \n"
                + " Where GenreId = ? And p.productPrice between ? and ? ";
        sql += " Order BY p.productId\n"
                + "OFFSET ? ROWS \n"
                + "FETCH NEXT ? ROWS ONLY";

        try ( Connection connection = SQLServerConnection.getConnection();  PreparedStatement ps = connection.prepareStatement(sql);) {
            ps.setObject(1, genreId);
            ps.setObject(2, priceFrom);
            ps.setObject(3, priceTo);
            ps.setObject(4, pageCur * numberProductPerPage - numberProductPerPage);
            ps.setObject(5, numberProductPerPage);
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

    public List<Product> getListProductPerPageBySeachValue(int numberProductPerPage, int pageCur, String searchValue) {

        String sql = "  Select * from \n"
                + "Product p Join Genre g ON p.GenreId = c.GenreId \n"
                + "WHERE p.productName LIKE ? OR g.GenreName LIKE ?"
                + "	Order BY p.productId\n"
                + "OFFSET ? ROWS \n"
                + "FETCH NEXT ? ROWS ONLY";//

        try ( Connection connection = SQLServerConnection.getConnection();  PreparedStatement ps = connection.prepareStatement(sql);) {
            ps.setObject(1, "%" + searchValue + "%");
            ps.setObject(2, "%" + searchValue + "%");
            ps.setObject(3, pageCur * numberProductPerPage - numberProductPerPage);
            ps.setObject(4, numberProductPerPage);
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

    public int sizeByGenre(int genreId, String priceFrom, String priceTo) {

        String sql = "SELECT COUNT(a.productId) as total from("
                + "Select DISTINCT\n"
                + "	p.productId,\n"
                + "	p.productName,\n"
                + "	p.productImg,\n"
                + "	p.AuthorName,\n"
                + "	p.productPrice,\n"
                + "	p.productDescription,\n"
                + "	p.GenreId,\n"
                + "	p.productIsFeatured,\n"
                + "	p.productIsSaleOff,\n"
                + "	p.productDeleted\n"
                + "from product p \n"
                + " Where GenreId = ? and p.productPrice between ? and ? ";

        try ( Connection connection = SQLServerConnection.getConnection();  PreparedStatement ps = connection.prepareStatement(sql);) {
            ps.setObject(1, genreId);
            ps.setObject(2, priceFrom);
            ps.setObject(3, priceTo);
            ResultSet rs = ps.executeQuery();
            int total = 0;
            while (rs.next()) {
                total = rs.getInt("total");
            }
            return total;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return 0;
    }

    public int sizeBySearchValue(String searchValue) {

        String sql = "SELECT COUNT(p.productId) as total from\n"
                + "Product p Join Genre g ON p.GenreId = c.GenreId \n"
                + "WHERE p.productName LIKE ? OR c.GenreName LIKE ?";

        try ( Connection connection = SQLServerConnection.getConnection();  PreparedStatement ps = connection.prepareStatement(sql);) {
            ps.setObject(1, "%" + searchValue + "%");
            ps.setObject(2, "%" + searchValue + "%");
            ResultSet rs = ps.executeQuery();
            int total = 0;
            while (rs.next()) {
                total = rs.getInt("total");
            }
            return total;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return 0;
    }

    public int size(String priceFrom, String priceTo) {

        String sql = "SELECT COUNT(a.productId) as total from("
                + "Select DISTINCT\n"
                + "	p.productId,\n"
                + "	p.productName,\n"
                + "	p.productImg,\n"
                + "	p.AuthorName,\n"
                + "	p.productPrice,\n"
                + "	p.productDescription,\n"
                + "	p.GenreId,\n"
                + "	p.productIsFeatured,\n"
                + "	p.productIsSaleOff,\n"
                + "	p.productDeleted\n"
                + "from product p \n"
                + " Where p.productPrice between ? and ? ) as a";
        try ( Connection connection = SQLServerConnection.getConnection();  PreparedStatement ps = connection.prepareStatement(sql);) {
            ps.setObject(1, priceFrom);
            ps.setObject(2, priceTo);
            ResultSet rs = ps.executeQuery();
            int total = 0;
            while (rs.next()) {
                total = rs.getInt("total");
            }
            return total;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new ProductDao().size("0", "100"));
    }
}
