/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AccountServlet extends HttpServlet{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        HttpSession session=request.getSession();
        String username= (String) session.getAttribute("username");
        
        
        //Retrive the user's account balance
         try(Connection connection=DriverManager.getConnection("jdbc::mysql:://localhost:3306/vulneravbleweapp","root","password")){
            PreparedStatement statement=connection.prepareStatement("SELECT balance FROM accountrs WHERE user_id=(SELECT id FROM users WHERE username=?)");
         statement.setString(1,username);
         ResultSet resultSet=statement.executeQuery();
         
         if(resultSet.next()){
            double balance=resultSet.getDouble("balance"); 
            request.setAttribute("balance", balance);
            
            request.getRequestDispatcher("account.jsp").forward(request, response);
         }else{
             response.sendRedirect("login.jsp? error=account_not_found");
         }
         
        }
           catch (SQLException e){
            System.out.println("Error retrieving account balance"+ e.getMessage());          
    }
   String action= request.getParameter("action");
   double amount=Double.parseDouble(request.getParameter("amount"));
   
   //perform the desired action(deposit or withdraw)
    try(Connection connection=DriverManager.getConnection("jdbc::mysql:://localhost:3306/vulneravbleweapp","root","password")){
        PreparedStatement statement;
        if(action.equals("deposit")){
            statement= connection.prepareStatement("UPDATE account SET balance=balance +? WHERE user_id=(SELECT id FROM users WHERE username=?)");
            }else{
             statement= connection.prepareStatement("UPDATE account SET balance=balance +? WHERE user_id=(SELECT id FROM users WHERE username=?)");

        }
        statement.setDouble(1, amount);
        statement.setString(2, username);
        statement.executeUpdate();
    }catch (SQLException e){
        System.out.println("Error performing action:" + e.getMessage());
    }
    response.sendRedirect("account.jsp");
    }
    public static void main(String[] args){
    
}
    }
