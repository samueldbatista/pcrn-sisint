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
                                        <option value="${setor.valor}">${setor.chave}</option>
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
                                        <option value="${prioridade.valor}">${prioridade.chave}</option>
                                    </c:forEach>

                                </select>
                            </div>
                            <div class="form-group col-md-4">
                                <label for="tecnico-servico">Ténico Responsável</label>
                                <select class="form-control input-sm" id="tecnico-servico" name="servico.tecnico">
                                    <option value=""></option>
                                    <c:forEach items="${usuarios}" var="usuario">
                                        <option value="${usuario.valor}">${usuario.chave}</option>
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
                    <h4 class="tituloCadastro">Cadastro de Tarefas</h4>
                    <div id="cadastro-tarefa">
                        <input type="hidden" name="tarefa.id" value="${tarefa.id}"/>
                        <div class="row">
                            <div class="form-group col-md-4">
                                <label for="titulo-tarefa">Título</label>
                                <input type="text" class="form-control" id="titulo-tarefa"
                                       name="tarefa.tecnico"
                                       placeholder="Técnico"/>
                            </div>
                            <div class="form-group col-md-3">
                                <label for="tecnico-tarefa">Técnico</label>
                                <input type="text" class="form-control" id="tecnico-tarefa"
                                       name="tarefa.tecnico"
                                       placeholder="Técnico"/>
                            </div>
                            <div class="form-group col-md-2">
                                <label for="prazo-tarefa">Prazo</label>
                                <input type="text" class="form-control datePicker" id="prazo-tarefa"
                                       name="tarefa.prazo"
                                       placeholder="Data"/>
                            </div>
                            <div class="form-group col-md-3">
                                <label for="status-tarefa">Status</label>
                                <select type="text" class="form-control" id="status-tarefa" placeholder="Status"
                                        name="tarefa.statusTarefa">
                                    <option value=""></option>
                                    <c:forEach items="${statusTarefa}" var="s">
                                        <option value="${s.valor}">${s.chave}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group col-md-12">
                                <label for="descricao-tarefa">Descricao</label>
                                <textarea class="form-control" id="descricao-tarefa" row="1"
                                          name="tarefa.descricao"
                                ></textarea>
                            </div>
                        </div>
                        <div class="row" align="right">
                            <button class="btn btn-success" type="button">Adicionar</button>
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
