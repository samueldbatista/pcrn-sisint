<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="ThemeBucket">
    <link rel="shortcut icon" href="images/favicon.png">

    <c:set var="ctx" value="${pageContext.request.contextPath}" />
	<%--CSS bootstrap--%>
	<link href="${ctx}/resources/bootstrap-4.0.0-alpha.6-dist/css/bootstrap.min.css" rel="stylesheet">
	<link href="${ctx}/resources/bootstrap-4.0.0-alpha.6-dist/css/bootstrap-grid.min.css" rel="stylesheet">
	<link href="${ctx}/resources/bootstrap-4.0.0-alpha.6-dist/css/bootstrap-reboot.min.css" rel="stylesheet">

	<%--JS bootstrap--%>
	<link href="${ctx}/resources/bootstrap-4.0.0-alpha.6-dist/js/bootstrap.js">
<title>VRaptor Blank Project</title>
</head>
<body>
<h1>Sistema de Integração SisInt</h1>
<a class="btn btn-info">teste</a>
	It works!! ${variable} ${linkTo[IndexController].index}
</body>
</html>