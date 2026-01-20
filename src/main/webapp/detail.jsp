<%--
  Created by IntelliJ IDEA.
  User: nguyenvv
  Date: 1/20/26
  Time: 12:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/user/update?id=${user.id}" method="post">
    <label>Id: <input type="text" name="id" value="${user.id}" readonly></label> <br>
    <label>Fullname: <input type="text" name="fullName" value="${user.fullName}"></label> <br>
    <label>Pw: <input type="text" name="password" value="${user.password}"></label> <br>
    <label>Email: <input type="text" name="email" value="${user.email}"></label> <br>
    <label>Role: <input type="radio" name="admin" value="true" ${user.admin == true ? "checked":""}>Admin
        <input type="radio" name="admin" value="false" ${user.admin == false ? "checked":""}>User</label> <br>
    <button type="submit">Update</button>

</form>
</body>
</html>
