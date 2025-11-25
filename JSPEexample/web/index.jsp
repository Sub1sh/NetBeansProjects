<%-- 
    Document   : index
    Created on : Nov 25, 2025, 7:39:33 AM
    Author     : subas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    <%! int day = 3; %> 
    <html>
   <head><title>IF...ELSE Example</title></head> 
   
   <body>
      <% if (day == 1 || day == 7) { %>
         <p> Today is weekend</p>
      <% } else { %>
         <p> Today is not weekend </p>
      <% } %>
   </body> 
</html>>

