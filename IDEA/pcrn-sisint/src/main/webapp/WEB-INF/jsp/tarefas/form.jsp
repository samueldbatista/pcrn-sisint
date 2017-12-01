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
<tags:teste>
    <jsp:attribute name="cabecalho">
    </jsp:attribute>
    <jsp:attribute name="rodape">

    </jsp:attribute>

    <jsp:body>
        <div class="panel painel-sisint">
            <div class="panel-heading">
                <h4 align="center"> Atualizar Tarefa</h4>
            </div>
            <div class="panel-body">
                <form class="form-horizontal" action="${linkTo[TarefaController].salvar}" method="post">
                    <input type="hidden" name="tarefa.id" value="${tarefa.id}">
                    <input type="hidden" name="tarefa.codigoTarefa" value="${tarefa.codigoTarefa}">
                    <input type="hidden" name="tarefa.servico.id" value="${tarefa.servico.id}">
                    <input type="hidden" name="tarefa.servico.id" value="${tarefa.dataAbertura}">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Título</label>
                        <div class="col-sm-10">
                            <input class="form-control" name="tarefa.titulo" type="text" value="${tarefa.titulo}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Prazo de finalização</label>
                        <div class="col-sm-10">
                            <input class="form-control datePicker" name="tarefa.dataFechamento" type="text" value="${tarefa.dataFechamento}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Status</label>
                        <div class="col-sm-10">
                            <select class="form-control" name="tarefa.statusTarefa" type="text">
                                <option value=""></option>
                                <c:forEach items="${status}" var="s">
                                    <c:if test="${s.valor == tarefa.statusTarefa.valor}">
                                        <option value="${s.valor}" selected="true">${s.chave}</option>
                                    </c:if>
                                    <c:if test="${!(s.valor == tarefa.statusTarefa.valor)}">
                                        <option value="${s.valor}">${s.chave}</option>
                                    </c:if>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Técnico</label>
                        <div class="col-sm-10">
                            <select class="form-control" name="tarefa.tecnico.id" type="text">
                                <option value=""></option>
                                <c:forEach items="${usuarios}" var="usuario">
                                    <c:if test="${usuario.valor == tarefa.tecnico.id}">
                                        <option value="${usuario.valor}" selected="true">${usuario.chave}</option>
                                    </c:if>
                                    <c:if test="${!(usuario.valor == tarefa.tecnico.id)}">
                                        <option value="${usuario.valor}">${usuario.chave}</option>
                                    </c:if>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Possui pendência: </label>
                        <div class="col-sm-10">
                            <input type="checkbox" name="tarefa.pendente" value="${tarefa.pendente}"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Descrição</label>
                        <div class="col-sm-10">
                             <textarea class="form-control" name="tarefa.descricao" rows="2"
                                       required="true" >${tarefa.descricao}</textarea>
                        </div>
                    </div>
                    <div align="right">
                        <button class="btn btn-primary" type="submit">Salvar</button>
                    </div>
                </form>
            </div>
        </div>
    </jsp:body>
</tags:teste>
