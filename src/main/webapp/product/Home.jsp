<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html>
    <html>

    <head>
      <meta charset="ISO-8859-1">
      <title>Insert title here</title>
    </head>

    <body>

      ay s
      <c:forEach items="${products}" var="p" varStatus="ps">
        <div class="product">
          ${p.name }
          brand ${p.brand.name }
        </div>
      </c:forEach>
    </body>

    </html>