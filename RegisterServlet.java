
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class RegisterServlet extends HttpServlet{
     protected void doPost(HttpSevletRequest request,HttpSevletResponse response) throws ServletException,IOException, SQLException{
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        
        //create a new user account
        try(Connection connection=DriverManager.getConnection("jdbc::mysql:://localhost:3306/vulneravbleweapp","root","password")){
            PreparedStatement statement=connection.prepareStatement("INSERT INTO users(username,password)VALUES(?,?)");
            statement.setString(1, username);
            statement.setString(2, password);
            statement.executeUpdate();
        }catch (SQLException e){
            System.out.println("Error creating user account:" + e.getMessage());
        }
        response.sendRedirect("login.jsp");
    }
    public static void main(String[] args){
    
}
}