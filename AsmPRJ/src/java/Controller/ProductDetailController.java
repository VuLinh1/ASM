/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import dao.GenreDAO;
import dao.ProductDao;
import entity.Cart;
import entity.Genre;
import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @author ADMIN
 */
@WebServlet(name="ProductDetailController", urlPatterns={"/product-detail"})
public class ProductDetailController extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProductDetailController</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductDetailController at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
       ProductDao productDAO = new ProductDao();
        int productId = Integer.parseInt(request.getParameter("productId"));
       Product product = productDAO.getOne(productId);
        request.setAttribute("lstGenre", lstGenre);
         request.setAttribute("product", product);
         request.getRequestDispatcher("product-detail.jsp").forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
         HttpSession session = request.getSession();
        List<Cart> lstCart = (List<Cart>) session.getAttribute("lstCart");
        int productId = Integer.parseInt(request.getParameter("productId"));
        int orderDetailQuantity = Integer.parseInt(request.getParameter("orderDetailQuantity"));
        String orderDetailProductName = request.getParameter("orderDetailProductName");
        String orderDetailProductImg = request.getParameter("orderDetailProductImg");
        int orderDetailPriceProduct = Integer.parseInt(request.getParameter("orderDetailPriceProduct"));
        int index = getOneCart(lstCart, productId);
        if (index == -1) {
            Cart cart = Cart.builder()
                    .orderDetailPriceProduct(orderDetailPriceProduct)
                    .orderDetailProductImg(orderDetailProductImg)
                    .orderDetailProductName(orderDetailProductName)
                    .orderDetailQuantity(orderDetailQuantity)
                    .productId(productId)
                    .build();
            lstCart.add(cart);
        } else {
            lstCart.get(index).setOrderDetailQuantity(orderDetailQuantity + lstCart.get(index).getOrderDetailQuantity());
        }
        response.sendRedirect("product-detail?productId=" + productId);

    }

    private int getOneCart(List<Cart> lstCart, int productId) {
        for (int i = 0; i < lstCart.size(); i++) {
            if (lstCart.get(i).getProductId() == productId ) {
                return i;
            }
        }
        return -1;
    }
    

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
