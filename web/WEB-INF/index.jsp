<%--
  Created by IntelliJ IDEA.
  User: Michiels Yan
  Date: 19/04/2020
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="dao.pojo.*" language="java" %>
<%
    //Initialisation des paramètres de session
    Humain humain = (Humain) request.getSession().getAttribute(("humain"));
    if(humain == null) {
        response.sendRedirect("login");
    }
%>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Michiels Yan & Cebollado Johann">
    <link rel="icon" href="medias/img/favicon.png">

    <title>Belote</title>

    <%@include file="common/include.jsp" %>
</head>
<body>
<div class="wrapper">
    <%@include file="common/sidebar.jsp" %>
    <div id="myContent"><%@include file="common/dashboard_content.jsp"%></div>
    <%@include file="common/logoutModal.jsp" %>
</div>
</body>
</html>
