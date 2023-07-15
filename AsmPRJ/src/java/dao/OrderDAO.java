/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.SQLServerConnection;
import entity.Account;
import entity.Order;
import entity.OrderDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class OrderDAO {

    public int add(Order obj) {
        int check = 0;
        String sql = "INSERT INTO [Order](accountId, orderCreateDate, orderExpectedDate, orderNameContact, orderPhoneContact, orderAddressContact, orderStatusId)"
                + " VALUES(?, GETDATE(), GETDATE() + 5, ?, ?, ?, 1)";
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = (con != null) ? con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS) : null;) {
            ps.setObject(1, obj.getAccount().getAccountId());
            ps.setObject(2, obj.getOrderNameContact());
            ps.setObject(3, obj.getOrderPhoneContact());
            ps.setObject(4, obj.getOrderAddressContact());

            check = ps.executeUpdate();
            if (check > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                rs.next();
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return 0;
    }

//    public List<OrderDetail> getAllOrderDetail(int orderId) {
//        String sql = "select * from OrderDetail where orderId = ? ";//
//
//        try ( Connection connection = SQLServerConnection.getConnection();  PreparedStatement ps = connection.prepareStatement(sql);) {
//            ps.setObject(1, orderId);
//            ResultSet rs = ps.executeQuery();
//            List<OrderDetail> list = new ArrayList<>();//
//            while (rs.next()) {
//                OrderDetail obj = OrderDetail.builder()
//                        .orderDetailId(rs.getInt("orderDetailId"))
//                        .orderId(rs.getInt("orderId"))
//                        .productId(rs.getInt("productId"))
//                        .orderDetailProductImg(rs.getString("orderDetailProductImg"))
//                        .orderDetailProductName(rs.getString("orderDetailProductName"))
//                        .orderDetailPriceProduct(rs.getInt("orderDetailPriceProduct"))
//                        .build();
//                list.add(obj);
//            }
//            return list;
//        } catch (SQLException e) {
//            e.printStackTrace(System.out);
//        }
//        return null;
//    }

    public List<Order> getAllByOrderStatusIdForAdmin() {
        String sql = "select * from [order] o join account a ON o.accountId = a.accountId\n";

        try ( Connection connection = SQLServerConnection.getConnection();  PreparedStatement ps = connection.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            List<Order> list = new ArrayList<>();//
            while (rs.next()) {
                Order obj = Order.builder()
                        .orderId(rs.getInt("orderId"))
                        .account(Account.builder()
                                .accountId(rs.getInt("accountId"))
                                .accountEmail(rs.getString("accountEmail"))
                                .accountPassword(rs.getString("accountPassword"))
                                .accountDeleted(rs.getBoolean("accountDeleted"))
                                .build())
                        .orderCreateDate(rs.getDate("orderCreateDate"))
                        .orderExpectedDate(rs.getDate("orderExpectedDate"))
                        .orderDoneDate(rs.getDate("orderDoneDate"))
                        .orderNameContact(rs.getString("orderNameContact"))
                        .orderPhoneContact(rs.getString("orderPhoneContact"))
                        .orderAddressContact(rs.getString("orderAddressContact"))
                        .orderStatusId(rs.getInt("orderStatusId"))
                        .build();
                list.add(obj);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new OrderDAO().getAllByOrderStatusIdForAdmin());
    }
}
