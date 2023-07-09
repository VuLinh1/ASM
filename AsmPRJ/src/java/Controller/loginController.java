package Controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import dao.AccountDAO;
import entity.Account;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author ADMIN
 */
@WebServlet(urlPatterns = {"/login"})
public class loginController extends HttpServlet {

    private static final String REMEMBER_ME_COOKIE_USERNAME = "rememberMeUsername";
    private static final String REMEMBER_ME_COOKIE_PASSWORD = "rememberMePasword";
    private static final int REMEMBER_ME_COOKIE_MAX_AGE = 3600 * 24 * 30; // 30 days

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
            out.println("<title>Servlet loginController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet loginController at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        AccountDAO accountDAO = new AccountDAO();
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
                response.sendRedirect("home");
                return;
            }
        }

        request.getRequestDispatcher("login.jsp").forward(request, response);
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
//         AccountDAO accountDAO = new AccountDAO();
//        HttpSession session = request.getSession();
//        String username = request.getParameter("email");
//        String password = request.getParameter("password");
//        
//        Account account = accountDAO.authenticate(username, password);
//        if(account == null){
//            request.setAttribute("msg", "login Fail email or pw wrong");
//           
//            request.getRequestDispatcher("login.jsp").forward(request, response);
//        }else{
//            response.sendRedirect("home.jsp");
//        }
        AccountDAO accountDAO = new AccountDAO();
        HttpSession session = request.getSession();

        String username = request.getParameter("email");
        String password = request.getParameter("password");
        boolean isRemeberMe = request.getParameter("isRemeberMe") != null;
        try {
            Account account = AccountDAO.authenticate(username, password);
            if (account == null) {
                 session.setAttribute("error", "password or Username wrong!!!" );
                 response.sendRedirect("login");
            } else {

                session.setAttribute("accountCur", account);
                if (isRemeberMe) {

                    Cookie cookieUsername = new Cookie(REMEMBER_ME_COOKIE_USERNAME, username);
                    cookieUsername.setMaxAge(REMEMBER_ME_COOKIE_MAX_AGE);
                    Cookie cookiePassword = new Cookie(REMEMBER_ME_COOKIE_PASSWORD, password);
                    cookiePassword.setMaxAge(REMEMBER_ME_COOKIE_MAX_AGE);
                    response.addCookie(cookieUsername);
                    response.addCookie(cookiePassword);
                }
                response.sendRedirect("home");
            }
        }catch(Exception e){
          
           
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
