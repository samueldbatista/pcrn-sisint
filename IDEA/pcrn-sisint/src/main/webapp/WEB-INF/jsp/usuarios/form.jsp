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
        <div class="panel col-md-6 col-md-offset-3" style="margin-top: 50px;">
            <div class="panel-heading">
                <div class="panel-title">Cadastrar usuários</div>
            </div>
            <div class="panel-body" style="padding-top: 0px;">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Nome</label>
                        <div class="col-sm-10">
                            <input class="form-control" id="nome-usuario" type="text" value="">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Tipo</label>
                        <div class="col-sm-10">
                            <input class="form-control" id="tipo-usuario" type="text" value="">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Telefone</label>
                        <div class="col-sm-10">
                            <input class="form-control" id="contato-usuario" type="text" value="">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">M</label>
                        <div class="col-sm-10">
                            <input class="form-control" id="focusedInput" type="text" value="">
                        </div>
                    </div>

                </form>
            </div>

        </div>
    </jsp:body>
</tags:teste>
