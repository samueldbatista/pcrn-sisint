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
<tags:layout>

    <jsp:attribute name="cabecalho">
        <link href="${ctx}/resources/plugins/dataPicker/dataPicker.css" rel="stylesheet"/>
        <link href="${ctx}/resources/plugins/x-bootstrap-wizard-v1.1.1/assets/css/gsdk-bootstrap-wizard.css"
              rel="stylesheet"/>
	    <!-- CSS Just for demo purpose, don't include it in your project -->
	    <link href="${ctx}/resources/plugins/x-bootstrap-wizard-v1.1.1/assets/css/demo.css" rel="stylesheet"/>
	    <link href="${ctx}/resources/css/servicos/wizard.css" rel="stylesheet"/>
        <style>
            label{
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
            <div class="panel-content" style="min-height: 350px;">
                <div class="setup-content" id="step-1">
                    <div class="form-group col-md-4">
                        <label for="titulo-servico">Título</label>
                        <input type="text" class="form-control" id="titulo-servico"
                               placeholder="Titulo do serviço"
                               name="servico.titulo"/>
                    </div>
                    <div class="form-group col-md-4">
                        <label for="status-servico">Status</label>
                        <select type="text" class="form-control" id="status-servico" placeholder="Status"
                               name="servico.statusServico">
                            <option value=""></option>
                            <c:forEach items="${status}" var="s">
                                <option value="${s.valor}">${s.chave}</option>
                            </c:forEach>

                        </select>
                    </div>

                    <div class="form-group col-md-4">
                        <label for="tecnico-servico">Ténico Responsável</label>
                        <input type="text" class="form-control" id="tecnico-servico"
                               placeholder="Técnico responsável"/>
                    </div>
                    <div class="form-group col-md-4">
                        <label for="data-abertura-servico">Data de Abertura</label>
                        <input type="text" class="form-control datePicker" id="data-abertura-servico"
                               placeholder="Data de abertura" name="servico.dataAbertura"/>
                    </div>
                    <div class="form-group col-md-4">
                        <label for="data-fechamento-servico">Data de Finalização</label>
                        <input type="text" class="form-control datePicker" id="data-fechamento-servico"
                               placeholder="Data de finalização" name="servico.dataFechamento"/>
                    </div>

                    <div class="form-group col-md-4">
                        <label for="setor-servico">Setor</label>
                        <input type="text" class="form-control" id="setor-servico"
                               placeholder="Setor solicitante" name="servico.setor.nome"/>
                    </div>

                    <div class="form-group col-md-8">
                        <label for="descricao">Descrição:</label>
                        <textarea class="form-control" name="servico.descricao" rows="5"
                                  id="descricao"></textarea>
                    </div>
                </div>
                <div class="setup-content" id="step-2">
                    <div class="col-md-12">
                        <h6 style="border-bottom: 2px solid #E6E9ED; font-weight: 400; font-size: 18px;">
                            Adicionar tarefas</h6>
                    </div>
                    <div id="registro-tarefas">
                        <div class="form-group col-md-3">
                            <label for="tecnico-tarefa">Técnico</label>
                            <input type="text" class="form-control" id="tecnico-tarefa" name="tarefa.tecnico"
                                   placeholder="Técnico" />
                        </div>
                        <div class="form-group col-md-2">
                            <label for="prazo-tarefa">Prazo</label>
                            <input type="text" class="form-control datePicker" id="prazo-tarefa" name="tarefa.prazo"
                                   placeholder="Data" />
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
                            <textarea class="form-control" id="descricao-tarefa" row="1" name="tarefa.descricao"
                                      ></textarea>
                        </div>
                        <div class="col-md-2">
                            <input type="hidden" name="tarefa.id" value="${tarefa.id}" />
                            <a id="btnAdicionar" class="btn btn-primary" href="javascript:void(0)" >Adicionar</a>
                        </div>
                    </div>
                </div>

            </div>
            <div class="panel-footer">
                <button id="anterior" class="btn btn-primary pull-left" type="button">Anterior</button>
                <button id="proximo" class="btn btn-primary pull-right" type="button" >Próxima</button>
                <input type="hidden" name="servico.id" value="${servico.id}" />
                <a  id="btnSalvarServico" type="button" class="btn btn-success pull-right" href="#" >Salvar</a>
                <div class="clearfix"></div>
            </div>
            </form>
        </div>
    </jsp:body>
</tags:layout>
