<%--
  Created by IntelliJ IDEA.
  User: nguyenvv
  Date: 1/13/26
  Time: 12:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="">
    <label>Id: <input type="text" name="id"></label> <br>
    <label>Fullname: <input type="text" name="fullname"></label> <br>
    <label>Password: <input type="text" name="password"></label> <br>
    <label>Email: <input type="text" name="email"></label> <br>
    <label>Role: <input type="radio" name="admin" value="true">Admin
        <input type="radio" name="admin" value="false">User</label> <br>
    <button type="submit">Create</button>

</form>
<table>
    <thead>
    <tr>
        <td>Id</td>
        <td>Fullname</td>
        <td>Email</td>
        <td>Role</td>
        <td></td>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${list}">
        <tr>
            <td>${user.id}</td>
            <td>${user.fullName}</td>
            <td>${user.email}</td>
            <td>${user.admin == true ? 'Admin':'User'}</td>
            <td>Edit</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
