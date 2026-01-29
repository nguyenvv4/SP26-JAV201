<%--
  Created by IntelliJ IDEA.
  User: nguyenvv
  Date: 1/29/26
  Time: 12:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/favorite/save" method="post">
    Video: <select name="idVideo" id="">
    <c:forEach items="${listVideo}" var="video">
        <option value="${video.id}">${video.title}</option>
    </c:forEach>
</select> <br>
    User: <select name="idUser" id="">
    <c:forEach items="${listUSer}" var="user">
        <option value="${user.id}">${user.fullName}</option>
    </c:forEach>
</select> <br>
    <button type="submit">Save</button>
</form>
<table>
    <thead>
    <tr>
        <td>ID</td>
        <td>Video Name</td>
        <td>User name</td>
        <td>Like Date</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listFavorite}" var="f">
        <tr>
            <td>${f.id}</td>
            <td>${f.idVideo.title}</td>
            <td>${f.idUser.fullName}</td>
            <td>${f.likeDate}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
