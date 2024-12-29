
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="LoginServlet" method="post">
            <label for="Username">Username:</label>
            <input type="text" id="username" name="username"><br><br>
            
            <label for="password">Password:</label>
            <input type="password" id="password" name="password"><br><br><!-- comment -->
            
            <input type="submit" value="Login">
        </form>
        <%
            String error=(String) request.getAttribute("error");
            if(error != null){
            out.println("<p> style='color:red'" +error + "</p");
            }
                    %>
    </body>
</html>
