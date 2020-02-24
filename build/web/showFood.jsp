<%--
    Document   : showFood
    Created on : Feb 21, 2020, 4:37:03 PM
    Author     : Haryx_PurpleSoft
--%>

<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>Palm on Code</title>
   </head>
   <body>
      <h1 align ="center">Menu</h1>
      <table border ="1" bordercolor ="purple" cellpadding ="20%" align ="center">
         <tr>
            <th>s/No</th>
            <th>Item</th>
            <th>Price</th>
         </tr>

         <c:forEach var="items" items="${foodItems}">
            <tr>
               <td>${items.id}</td>
               <td>${items.item} </td>
               <td>${items.price}</td>
            </tr>
         </c:forEach>


      </table>
      <% response.sendRedirect("http://www.w3adda.com");%>
   </body>
</html>
