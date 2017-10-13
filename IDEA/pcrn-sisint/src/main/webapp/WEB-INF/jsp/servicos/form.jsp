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
        <%--<link href="${ctx}/resources/plugins/x-bootstrap-wizard-v1.1.1/assets/css/gsdk-bootstrap-wizard.css"--%>
        <%--rel="stylesheet"/>--%>
        <!-- CSS Just for demo purpose, don't include it in your project -->
        <%--<link href="${ctx}/resources/plugins/x-bootstrap-wizard-v1.1.1/assets/css/demo.css" rel="stylesheet"/>--%>
        <link href="${ctx}/resources/css/servicos/wizard.css" rel="stylesheet"/>
        <link href="${ctx}/resources/css/componentes/checkbox.css" rel="stylesheet"/>
        <style>
            label {
                font-weight: 600;
                font-size: 12px;
            }
        </style>
    </jsp:attribute>

    <jsp:attribute name="rodape">

        <script src="${ctx}/resources/js/servicos/form.js"></script>
        <script src="${ctx}/resources/js/servicos/saveAjax.js"></script>
        <script src="${ctx}/resources/js/ConverterObjetoParaVRaptor.js"></script>
        <script src="${ctx}/resources/plugins/jquerySteps/jquery.steps.min.js"></script>
        <script src="${ctx}/resources/plugins/dataPicker/dataPicker-bootstrap.js"></script>
    </jsp:attribute>

    <jsp:body>
        <div class="panel" style="box-shadow: 0 0 15px rgba(0, 0, 0, 0.15), 0 0 1px 1px rgba(0, 0, 0, 0.1);">
            <div class="panel-heading">
                <div class="stepwizard" style="margin-top: 15px;">
                    <div class="stepwizard-row setup-panel">
                        <div class="stepwizard-step">
                            <a id="btnServico" href="#step-1" type="button" class="btn btn-primary btn-circle">1</a>
                            <p>Serviços</p>
                        </div>
                        <div class="stepwizard-step">
                            <a id="btnTarefa" href="#step-2" type="button" class="btn btn-default btn-circle">2</a>
                            <p>Tarefas</p>
                        </div>
                    </div>
                </div>
            </div>
            <input id="urlSalvar" type="hidden" value="${linkTo[ServicosController].salvar}"/>
            <form>
                <div class="panel-content" style="min-height: 500px;">
                    <div class="setup-content" id="step-1">
                        <div class="container">
                            <div class="col-md-6">
                                <div class="form-group col-md-6">
                                    <label for="titulo-servico">Título</label>
                                    <input type="text" class="form-control input-sm" id="titulo-servico" required="true"
                                           value="${servico.titulo}"
                                           placeholder="Titulo do serviço"
                                           name="servico.titulo"/>
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="tecnico-servico">Ténico Responsável</label>
                                    <input type="text" class="form-control" id="tecnico-servico" required="true"
                                           placeholder="Técnico responsável"/>
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="status-servico">Status</label>
                                    <select type="text" class="form-control" id="status-servico" placeholder="Status" required="true"
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
                                <div class="form-group col-md-6">
                                    <label for="prioridade-servico">Prioridade</label>
                                    <select type="text" class="form-control" id="prioridade-servico" required="true"
                                            placeholder="Prioridade"
                                            name="servico.prioridade">
                                        <option value=""></option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group col-md-6">
                                    <label for="data-abertura-servico">Data de Abertura</label>
                                    <input type="text" class="form-control datePicker" id="data-abertura-servico"
                                           value="${servico.dataAbertura}"
                                           placeholder="Data de abertura" name="servico.dataAbertura"/>
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="data-fechamento-servico">Data de Finalização</label>
                                    <input type="text" class="form-control datePicker" id="data-fechamento-servico" required="true"
                                           value="${servico.dataFechamento}"
                                           placeholder="Data de finalização" name="servico.dataFechamento"/>
                                </div>

                                <div class="form-group col-md-12">
                                    <label for="setor-servico">Setor</label>
                                    <input type="text" class="form-control" id="setor-servico" value=""
                                           placeholder="Setor solicitante" name="servico.setor.nome"/>
                                </div>

                            </div>
                            <div class="col-md-12">
                                <div class="form-group col-md-12">
                                    <label for="descricao">Descrição:</label>
                                    <textarea class="form-control" name="servico.descricao" rows="5" required="true"
                                              id="descricao">${servico.descricao}</textarea>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="setup-content" id="step-2">
                        <div class="container">
                            <div >
                                <h6 style="border-bottom: 1px solid rgba(45,106,237,0.78); font-weight: 400; font-size: 18px;">
                                    Adicionar tarefas</h6>
                            </div>
                            <div id="registro-tarefas">
                                <div class="row">
                                        <%--<div class="form-group col-md-3">--%>
                                        <%--<label for="nome-tarefa">Nome</label>--%>
                                        <%--<input type="text" class="form-control" id="nome-tarefa" name="tarefa.titulo" value="${tarefa.titulo}"--%>
                                        <%--placeholder="Nome da tarefa"/>--%>
                                        <%--</div>--%>
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
                                    <div class="form-group col-md-4">
                                        <label for="descricao-tarefa">Descricao</label>
                                        <textarea class="form-control" id="descricao-tarefa" row="1"
                                                  name="tarefa.descricao"
                                        ></textarea>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-2" style="padding-bottom: 16px;">
                                        <input type="hidden" name="tarefa.id" value="${tarefa.id}"/>
                                        <a id="btnAdicionar" class="btn btn-primary"
                                           href="javascript:void(0)">Adicionar</a>
                                    </div>
                                </div>
                                <c:if test="${not empty servico.tarefas}">
                                    <c:forEach items="${servico.tarefas}" var="tarefa">
                                        <div class="panel-group">
                                            <div class="panel panel-default">
                                                <div class="panel-heading">
                                                    <h4 class="panel-title">
                                                        <a data-toggle="collapse"
                                                           href="#collapse${tarefa.id}">Tarefa T${tarefa.id}</a>
                                                    </h4>
                                                </div>
                                                <div id="collapse${tarefa.id}" class="panel-collapse collapse">
                                                    <div class="panel-body">
                                                        Teste
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </c:if>
                            </div>
                        </div>
                    </div>

                </div>
                <div class="panel-footer">
                    <button id="anterior" class="btn btn-primary pull-left" type="button">Anterior</button>
                    <button id="proximo" class="btn btn-primary pull-right" type="button">Próxima</button>
                    <input type="hidden" name="servico.id" value="${servico.id}"/>
                    <a id="btnSalvarServico" type="button" class="btn btn-success pull-right" href="#">Salvar</a>
                    <div class="clearfix"></div>
                </div>
            </form>
        </div>
    </jsp:body>
</tags:teste>
