<%@ page import="com.kamil.jsp_sklep.models.Product" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>in.jsp</title>
</head>
<body>
<h1>Products store</h1>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Price</th>
            <th>Quantity</th>
        </tr>
        <%
            List<Product>products = (List<Product>)request.getAttribute("productList");

            for(Product product : products) {
        %>
        <form action="AddProduct" method="post">
        <tr>
            <td><input name="product" value="<%=product.getId()%>"readonly/></td>
            <td><%=product.getName()%></td>
            <td><%=product.getDescription()%></td>
            <td><%=product.getPrice()%></td>
            <td><%=product.getQuantity()%></td>
            <td><input type="submit" value="Add"/></td>
        </tr>
        </form>
        <%}%>
    </table>
</body>
</html>
