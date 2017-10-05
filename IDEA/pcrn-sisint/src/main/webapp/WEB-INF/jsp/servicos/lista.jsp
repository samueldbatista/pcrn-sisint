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
<%@ taglib prefix="td" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<tags:layout>
    <jsp:attribute name="cabecalho">

    </jsp:attribute>
    <jsp:attribute name="rodape">

    </jsp:attribute>

    <jsp:body>
        <div class="panel">
            <div class="panel-heading">
                <div class="panel-title">Gerenciamento de serviços</div>
            </div>
            <div class="panel-body" style="padding-top: 0px;">
                <a class="btn btn-info" style="margin-bottom: 16px;" href="${linkTo[ServicosController].form}">Cadastrar</a>
                <div class="tabela-servicos">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th>Titulo</th>
                            <th>Status</th>
                            <th>Data de Fechamento</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${servicos}" var="servico">
                        <tr>
                            <td>${servico.titulo}</td>
                            <td>${servico.statusServico.chave}</td>
                            <td>${servico.dataFechamento}</td>
                        </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </jsp:body>
</tags:layout>
