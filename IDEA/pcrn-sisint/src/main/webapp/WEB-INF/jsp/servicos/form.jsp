<%--
  Created by IntelliJ IDEA.
  User: samue
  Date: 08/09/2017
  Time: 23:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" uri="tagSisInt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<tags:teste>

    <jsp:attribute name="cabecalho">
        <link href="${ctx}/resources/plugins/dataPicker/dataPicker.css" rel="stylesheet"/>
        <link href="${ctx}/resources/css/componentes/checkbox.css" rel="stylesheet"/>
        <style>
            label {
                font-weight: 600;
                font-size: 12px;
            }

            .panel-title {
                border-bottom: 1px solid;
            }
        </style>
    </jsp:attribute>

    <jsp:attribute name="rodape">

        <script src="${ctx}/resources/js/servicos/form.js"></script>
        <%--<script src="${ctx}/resources/js/servicos/saveAjax.js"></script>--%>
        <script src="${ctx}/resources/js/ConverterObjetoParaVRaptor.js"></script>
        <script src="${ctx}/resources/plugins/jquerySteps/jquery.steps.min.js"></script>
        <script src="${ctx}/resources/plugins/dataPicker/dataPicker-bootstrap.js"></script>
    </jsp:attribute>

    <jsp:body>
        <div class="panel">
            <form>
                <div class="panel-body">
                    <input id="urlSalvar" type="hidden" value="${linkTo[ServicosController].salvar}"/>
                    <input id="urlSalvarTarefa" type="hidden" value="${linkTo[ServicosController].salvarTarefa}"/>
                    <h4 class="tituloCadastro">Cadastro de Serviços</h4>
                    <div id="cadastro-servico">
                        <div class="row">
                            <input type="hidden" name="servico.id" value="${servico.id}"/>
                            <div class="form-group col-md-6">
                                <label for="titulo-servico">Título</label>
                                <input type="text" class="form-control input-sm" id="titulo-servico" required="true"
                                       value="${servico.titulo}"
                                       placeholder="Titulo do serviço"
                                       name="servico.titulo"/>
                            </div>
                            <div class="form-group col-md-6">
                                <label for="setor-servico">Setor solicitante</label>
                                <select class="form-control input-sm" id="setor-servico" name="servico.setor">
                                    <option value=""></option>
                                    <c:forEach items="${setores}" var="setor">
                                        <c:if test="${setor.valor == servico.setor.id}">
                                            <option value="${setor.valor}" selected="true">${setor.chave}</option>
                                        </c:if>
                                        <c:if test="${!(setor.valor == servico.setor.id)}">
                                            <option value="${setor.valor}">${setor.chave}</option>
                                        </c:if>
                                    </c:forEach>

                                </select>
                            </div>
                            <div class="form-group col-md-2">
                                <label for="status-servico">Status</label>
                                <select type="text" class="form-control" id="status-servico" placeholder="Status"
                                        required="true"
                                        name="servico.statusServico">
                                    <option value=""></option>
                                    <c:forEach items="${status}" var="s">
                                        <c:if test="${s.valor == servico.statusServico.valor}">
                                            <option value="${s.valor}" selected="true">${s.chave}</option>
                                        </c:if>
                                        <c:if test="${!(s.valor == servico.statusServico.valor)}">
                                            <option value="${s.valor}">${s.chave}</option>
                                        </c:if>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group col-md-2">
                                <label for="data-fechamento-servico">Data de Finalização</label>
                                <input type="text" class="form-control datePicker" id="data-fechamento-servico"
                                       required="true"
                                       value="${servico.dataFechamento}"
                                       placeholder="Data de finalização" name="servico.dataFechamento"/>
                            </div>

                            <div class="form-group col-md-2">
                                <label for="prioridade-servico">Prioridade</label>
                                <select class="form-control input-sm" id="prioridade-servico" name="servico.prioridade">
                                    <option value=""></option>
                                    <c:forEach items="${prioridades}" var="prioridade">
                                        <c:if test="${prioridade.valor == servico.prioridade.valor}">
                                            <option value="${prioridade.valor}"
                                                    selected="true">${prioridade.chave}</option>
                                        </c:if>
                                        <c:if test="${!(prioridade.valor == servico.prioridade.valor)}">
                                            <option value="${prioridade.valor}">${prioridade.chave}</option>
                                        </c:if>
                                    </c:forEach>

                                </select>
                            </div>
                            <div class="form-group col-md-4">
                                <label for="tecnico-servico">Ténico Responsável</label>
                                <select class="form-control input-sm" id="tecnico-servico" name="servico.tecnico">
                                    <option value=""></option>
                                    <c:forEach items="${usuarios}" var="usuario">
                                        <c:if test="${usuario.valor == servico.tecnico.id}">
                                            <option value="${usuario.valor}" selected="true">${usuario.chave}</option>
                                        </c:if>
                                        <c:if test="${!(usuario.valor == servico.tecnico.id)}">
                                            <option value="${usuario.valor}">${usuario.chave}</option>
                                        </c:if>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="checkbox col-md-2">
                                <label><input type="checkbox" name="servico.pendencia" value="${servico.pendencia}">Possui
                                    pendência</label>
                            </div>
                            <div class="form-group col-md-12">
                                <label for="descricao">Descrição:</label>
                                <textarea class="form-control" name="servico.descricao" rows="2" required="true"
                                          id="descricao">${servico.descricao}</textarea>
                            </div>
                        </div>
                    </div>
                    <div id="cadastro-tarefa">
                        <div class="row" align="right">
                            <button type="button" class="btn btn-success" data-toggle="modal" data-target="#myModal">
                                Adicionar
                            </button>
                        </div>
                    </div>
                </div>

                <!-- Modal -->
                <div class="modal fade" id="myModal" role="dialog">
                    <div class="modal-dialog">

                        <!-- Modal content-->
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                <h4 class="modal-title">Modal Header</h4>
                            </div>
                            <div class="modal-body">
                                <div class="form-horizontal">
                                    <div class="form-group">
                                        <label class="control-label col-sm-2" for="titulo-tarefa">Título:</label>
                                        <div class="col-sm-10">
                                            <input type="email" name="tarefa.descricao" class="form-control" id="titulo-tarefa" placeholder="Titulo">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-sm-2" for="pwd">Password:</label>
                                        <div class="col-sm-10">
                                            <input type="password" class="form-control" id="pwd" placeholder="Enter password">
                                        </div>
                                    </div>
                                </div>

                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                <button id="btnSalvarTarefa" type="button" class="btn btn-primary" data-dismiss="modal">Salvar</button>
                            </div>
                        </div>

                    </div>
                </div>
                <div class="panel-footer" align="right">
                    <button class="btn btn-primary" type="button" href="#" id="btnServico">Salvar</button>
                </div>
            </form>
        </div>
    </jsp:body>
</tags:teste>
