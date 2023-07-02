/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import dao.GenreDAO;
import dao.ProductDao;
import entity.Genre;
import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import utils.Helper;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "ShopController", urlPatterns = {"/shop"})
public class ShopController extends HttpServlet {

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
            out.println("<title>Servlet ShopController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ShopController at " + request.getContextPath() + "</h1>");
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

        ProductDao productDAO = new ProductDao();
        GenreDAO genreDAO = new GenreDAO();
        List<Genre> lstGenre = genreDAO.getAllbyGenre();
        List<Product> lstProductSaleOff = productDAO.getAllBySaleOff();
        List<Integer> lstPage = new ArrayList<>();
        String href;
        int size = 0;
        int genreId = request.getParameter("GenreId") == null ? 0 : Integer.parseInt(request.getParameter("GenreId"));
        String searchValue = request.getParameter("searchValue");
        int numberProductPerPage = 9;
        int pageCur = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
        List<Product> lstProduct;
        String priceFrom = request.getParameter("priceFrom") == null ? "0" : request.getParameter("priceFrom");
        String priceTo = request.getParameter("priceTo") == null ? "540" : request.getParameter("priceTo");
        if (genreId != 0) {
            lstProduct = productDAO.getListProductPerPageBygenreId(numberProductPerPage, pageCur, genreId, priceFrom, priceTo);
            href = priceFrom.equals("0") ? "shop?genreId=" + genreId + "&" : "shop?genreId=" + genreId + "&priceFrom=" + priceFrom + "&priceTo=" + priceTo + "&";
            size = productDAO.sizeByGenre(genreId, priceFrom, priceTo);
        } else if (searchValue != null) {
            lstProduct = productDAO.getListProductPerPageBySeachValue(numberProductPerPage, pageCur, searchValue);
            href = "shop?searchValue=" + searchValue + "&";
            size = productDAO.sizeBySearchValue(searchValue);
        } else {
            lstProduct = productDAO.getListProductPerPage(numberProductPerPage, pageCur, priceFrom, priceTo);
            href = priceFrom.equals("0") ? "shop?" : "shop?priceFrom=" + priceFrom + "&priceTo=" + priceTo + "&";
            size = productDAO.size(priceFrom, priceTo);
        }
        int totalPage = size % numberProductPerPage == 0
                ? size / numberProductPerPage
                : size / numberProductPerPage + 1;
        for (int i = 1; i <= totalPage; i++) {
            lstPage.add(i);
        }
        System.out.println(lstPage);
        request.setAttribute("priceFrom", priceFrom);
        request.setAttribute("priceTo", priceTo);
        request.setAttribute("genreId", genreId);
        request.setAttribute("href", href);
        request.setAttribute("lstProduct", lstProduct);
        request.setAttribute("lstPage", lstPage);
        request.setAttribute("pageCur", pageCur);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("searchValue", searchValue);
        request.setAttribute("lstGenre", lstGenre);
        request.setAttribute("lstProductSaleOff", lstProductSaleOff);
        request.getRequestDispatcher("shop.jsp").forward(request, response);
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
