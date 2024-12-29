/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author HC
 */
public class LoginServlet extends HttpServlet{
protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        
        //Authenticate the user
        
 try(Connection connection=DriverManager.getConnection("jdbc::mysql:://localhost:3306/vulneravbleweapp","root","password")){
            PreparedStatement statement=connection.prepareStatement("SELECT * FROM users WHERE username=? AND password=?");
            statement.setString(1, username);
            ResultSet resultSet=statement.executeQuery();
            
            if(resultSet.next()){
                HttpSession session=request.getSession();
                session.setAttribute("username", "password");
                response.sendRedirect("account.jsp");
            }else{
                response.sendRedirect("login.jsp? error=invalid_credentials");
            }
        }catch (SQLException e){
            System.out.println("Error authenticating user:" + e.getMessage());
        }
        
}
public static void main(String[] args){
    
}
}