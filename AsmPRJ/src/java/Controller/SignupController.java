package Controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import dao.AccountDAO;
import dao.AccountDetailDAO;
import entity.Account;
import entity.AccountDetail;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author ADMIN
 */
@WebServlet(urlPatterns = {"/sign-up"})
public class SignupController extends HttpServlet {

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
        request.getRequestDispatcher("sign-up.jsp").forward(request, response);
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
        String email = request.getParameter("emailCreation");
        String password = request.getParameter("passwordCreation");
        String confirmpassword = request.getParameter("passwordConfirm");
        HttpSession session = request.getSession();
        if (password.equals(confirmpassword)) {
            if (AccountDAO.getOneByEmail(email) == null) {
                Account acc = Account.builder().accountPassword(password).accountEmail(email).build();
                int accountId = AccountDAO.register(acc);
                if (accountId > 0) {        
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                    AccountDetail accountDetail = AccountDetail.builder()
                            .accountId(accountId)
                            .build();
                    new AccountDetailDAO().add(accountDetail);
                }
            } else {
                  session.removeAttribute("msg1");
                session.setAttribute("msg", "Email already exist");
                request.getRequestDispatcher("sign-up.jsp").forward(request, response);
            }
        }else{
            session.removeAttribute("msg");
             session.setAttribute("msg1", "Confirm failed");
               request.getRequestDispatcher("sign-up.jsp").forward(request, response);
        }
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
