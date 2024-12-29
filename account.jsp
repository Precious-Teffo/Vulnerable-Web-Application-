<%-- 
    Document   : account
    Created on : 29 Dec 2024, 14:57:26
    Author     : HC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Account</title>
    </head>
    <body>
        <h1>Account!</h1>
        <p>Balance: ${balance}</p>
        
        <form action="AccountServlet" method="post">
            <input type="hidden" name="action" value="deposit"><!-- comment -->
            <label for="amount">Deposit:</label>
            
            <input type="number" id="amount" name="amount"><br><br><!-- comment -->
            <input type="submit" value="Login">
           </form>
        <form action="AccountServlet" method="post">
            <input type="hidden" name="action" value="withdrwaw"><!-- comment -->
            <label for="amount">Withdraw:</label>
            
            <input type="number" id="amount" name="amount"><br><br><!-- comment -->
            <input type="submit" value="Login">
        </form>
    </body>
</html>
