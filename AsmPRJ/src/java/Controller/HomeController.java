/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import dao.AccountDAO;
import dao.AccountDetailDAO;
import dao.GenreDAO;
import dao.ProductDao;
import entity.Account;
import entity.Cart;
import entity.Genre;
import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

import jakarta.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "HomeController", urlPatterns = {"/home"})
public class HomeController extends HttpServlet {

    private static final String REMEMBER_ME_COOKIE_USERNAME = "rememberMeUsername";
    private static final String REMEMBER_ME_COOKIE_PASSWORD = "rememberMePasword";

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
            out.println("<title>Servlet HomeController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HomeController at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        ProductDao productDAO = new ProductDao();
        Cookie[] cookies = request.getCookies();
        String username = null;
        String password = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(REMEMBER_ME_COOKIE_USERNAME)) {
                    username = cookie.getValue();
                }
                if (cookie.getName().equals(REMEMBER_ME_COOKIE_PASSWORD)) {
                    password = cookie.getValue();
                }
            }
            Account account = AccountDAO.authenticate(username, password);
            if (account != null) {

                session.setAttribute("accountCur", account);
                session.setAttribute("accountDetail", new AccountDetailDAO().getOne(account.getAccountId()));
            }
        }
        if (session.getAttribute("accountCur") != null) {
            try {
              
               if (session.getAttribute("lstCart") == null) {
                    session.setAttribute("lstCart", new ArrayList<Cart>());
                }
                 List<Product> lstProductFeatured = productDAO.getAllByFeatured();
                request.setAttribute("lstProductFeatured", lstProductFeatured);
                request.setAttribute("lstGenre", lstGenre);
                request.getRequestDispatcher("home.jsp").forward(request, response);
            } catch (Exception e) {
                // Handle the SQLException appropriately
            }
        } else {
            response.sendRedirect("login.jsp");
        }

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
        processRequest(request, response);
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
