/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import dao.AccountContactDAO;
import dao.GenreDAO;
import dao.OrderDAO;
import dao.OrderDetailDAO;
import entity.Account;
import entity.AccountContact;
import entity.Cart;
import entity.Genre;
import entity.Order;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "CheckoutController", urlPatterns = {"/checkout"})
public class CheckoutController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CheckoutController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CheckoutController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GenreDAO genreDAO = new GenreDAO();
        List<Genre> lstGenre = genreDAO.getAllbyGenre();
        request.setAttribute("lstGenre", lstGenre);
        HttpSession session = request.getSession();
        List<Cart> lstCart = (List<Cart>) session.getAttribute("lstCart");
        Account account = (Account) session.getAttribute("accountCur");
        AccountContactDAO accountContactDAO = new AccountContactDAO();
        AccountContact accountContact = accountContactDAO.getOne(account.getAccountId(), true);

        request.setAttribute("accountContact", accountContact);
        int totalPrice = 0;
        for (Cart c : lstCart) {
            totalPrice += c.getOrderDetailPriceProduct() * c.getOrderDetailQuantity();
        }
        request.setAttribute("totalPrice", totalPrice);
        request.getRequestDispatcher("checkout.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        OrderDAO orderDAO = new OrderDAO();
        OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
        Account account = (Account) session.getAttribute("accountCur");
            List<Cart> lstCart = (List<Cart>) session.getAttribute("lstCart");
        Order order = Order.builder()
                .account(account)
                .orderNameContact(request.getParameter("accountContactName"))
                .orderPhoneContact(request.getParameter("accountContactMobile"))
                .orderAddressContact(request.getParameter("accountContactAddress"))
                .build();
        int orderId = orderDAO.add(order);
        for (Cart c : lstCart) {
            orderDetailDAO.add(c, orderId);
        }

        lstCart = new ArrayList<>();
        session.setAttribute("lstCart", lstCart);
        response.sendRedirect("thank-you.jsp");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}