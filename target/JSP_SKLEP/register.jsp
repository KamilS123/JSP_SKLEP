<%--
  Created by IntelliJ IDEA.
  User: Kamil
  Date: 2018-12-16
  Time: 09:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
    <form action="Register" method="post">

        <label>Name</label>
        <input type="text" name="name" required/> <br/><br/>

        <label>Surname</label>
        <input type="text" name="surname" required/> <br/> <br/>

        <label>Username</label>
        <input type="text" name="username" required/> <br/><br/>

        <label>Password</label>
        <input type="password" name="password" required/> <br/><br/>

        <input type="submit" value="Register"/>

    </form>
</body>
</html>
