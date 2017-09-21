<%--
  Created by IntelliJ IDEA.
  User: samue
  Date: 08/09/2017
  Time: 23:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" uri="tagSisInt" %>
<!DOCTYPE html>
<tags:teste>
    <jsp:attribute name="cabecalho">
    </jsp:attribute>
    <jsp:attribute name="rodape">

    </jsp:attribute>

    <jsp:body>
        <form method="post" action="${linkTo[UsuariosController].salvar}">
            <input type="hidden" name="usuario.id" value="${usuario.id}">
            <input type="text" name="usuario.nome" value="${usuario.nome}">
            <input class="btn btn-info" type="submit" value="Salvar"/>
        </form>

    </jsp:body>
</tags:teste>
