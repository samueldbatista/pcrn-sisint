<%--
  Created by IntelliJ IDEA.
  User: samue
  Date: 15/09/2017
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
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
<tags:layout>
    <jsp:attribute name="cabecalho">
        <!-- CSS Files -->
        <%--<link href="${ctx}/resources/x-bootstrap-wizard-v1.1.1/assets/css/bootstrap.min.css" rel="stylesheet" />--%>
        <link href="${ctx}/resources/x-bootstrap-wizard-v1.1.1/assets/css/gsdk-bootstrap-wizard.css" rel="stylesheet"/>
        <link href="${ctx}/resources/plugins/dataPicker/dataPicker.css" rel="stylesheet"/>
        <%--<link href="${ctx}/resources/x-bootstrap-wizard-v1.1.1/assets/css/demo.css" rel="stylesheet" />--%>


        <%--<!-- CSS Just for demo purpose, don't include it in your project -->--%>
	    <%--<link href="${ctx}/resources/x-bootstrap-wizard-v1.1.1/assets/css/demo.css" rel="stylesheet"/>--%>
    </jsp:attribute>
    <jsp:attribute name="rodape">
        <!--   Core JS Files   -->
	<script src="${ctx}/resources/x-bootstrap-wizard-v1.1.1/assets/js/jquery.bootstrap.wizard.js"></script>
        <script src="${ctx}/resources/plugins/dataPicker/dataPicker-bootstrap.js"></script>

	<!--  Plugin for the Wizard -->
	<script src="${ctx}/resources/x-bootstrap-wizard-v1.1.1/assets/js/gsdk-bootstrap-wizard.js"></script>

	<!--  More information about jquery.validate here: http://jqueryvalidation.org/	 -->
	<script src="${ctx}/resources/x-bootstrap-wizard-v1.1.1/assets/js/jquery.validate.min.js"></script>

    <script>

        $(document).ready( function () {
            console.log("Entrou");

//            $('.datapicker').datepicker();


        } );

    </script>
    </jsp:attribute>

    <jsp:body>

        <nav class="breadcrumb">
            <a class="breadcrumb-item" href="#">Home</a>
            <a class="breadcrumb-item" href="#">Servicos</a>
            <a class="breadcrumb-item active" href="#">Cadastro</a>
        </nav>
        <div class="image-container set-full-height">
            <!--   Big container   -->

            <!--      Wizard container        -->
            <div class="wizard-container">
                <div class="card wizard-card" data-color="azzure" id="wizard">
                    <form action="${linkTo[ServicosController].salvar}" method="post">
                        <!--        You can switch ' data-color="azzure" '  with one of the next bright colors: "blue", "green", "orange", "red"          -->
                        <div class="wizard-header">
                            <h3>
                                <b>Cadastro de serviço</b>
                                <br/>
                                <small>Área para cadastro e atribuição de tarefas de serviços externos</small>
                            </h3>
                        </div>
                        <div class="wizard-navigation">
                            <ul>
                                <li><a href="#details" data-toggle="tab">Cadastrar serviço</a></li>
                                <li><a href="#captain" data-toggle="tab">Cadastrar tarefas</a></li>
                            </ul>
                        </div>
                        <div class="tab-content">
                            <div class="tab-pane" id="details">
                                <div class="container">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group" >
                                                <label for="tituloServico">Título do serviço</label>
                                                <input type="text" class="form-control" id="tituloServico" name="servico.titulo"
                                                       placeholder="Titulo do serviço">
                                            </div>
                                        </div>

                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="tecnicoResponsavel">Técnico</label>

                                                <select class="form-control" id="tecnicoResponsavel">
                                                    <option value=""></option>
                                                    <option value="Bruno">Bruno</option>
                                                    <option value="Felipe">Felipe</option>
                                                    <option value="Flavio">Flavio</option>
                                                    <option value="Miguel">Miguel</option>
                                                    <option value="Nilton">Nilton</option>
                                                    <option value="Rodrigo">Rodrigo</option>
                                                    <option value="Samuel">Samuel</option>
                                                </select>
                                            </div>
                                        </div>

                                        <div class="col-md-3">
                                            <div class="form-group date" data-provide="datepicker">
                                                <label for="dataAbertura">Data de abertura</label>
                                                <input name="servico.dataAbertura" type="text" class="form-control datapicker"
                                                       id="dataAbertura"/>
                                            </div>
                                        </div>

                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label for="dataFinalizacao">Previsão de finalização</label>
                                                <input name="servico.dataFechamento" type="text" class="form-control datapicker" id="dataFinalizacao">
                                            </div>
                                        </div>

                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="situacao">Situação</label>
                                                <select class="form-control" id="situacao">
                                                    <option value=""></option>
                                                    <option value="Cancelado">Cancelado</option>
                                                    <option value="Em espera">Em espera</option>
                                                    <option value="Em execução">Em execução</option>
                                                    <option value="Concluído">Concluído</option>
                                                </select>
                                            </div>
                                        </div>

                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label for="solicitante">Solicitante</label>
                                                <input type="text" class="form-control" id="solicitante"></input>
                                            </div>
                                        </div>
                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label for="setor">Setor do solicitante</label>
                                                <input name="servico.setor.nome" type="text" class="form-control" id="setor"></input>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="descricao">Descricao</label>
                                                <textarea name="servico.descricao" type="text" class="form-control" id="descricao"></textarea>
                                            </div>
                                        </div>

                                    </div>
                                </div>
                            </div>
                            <div class="tab-pane" id="captain">
                                <div class="container">
                                <div class="row">
                                <div class="col-md-4 offset-md-2">
                                    <div class="form-group">
                                        <label for="tituloTarefa">Título da tarefa</label>
                                        <input type="text" class="form-control" id="tituloTarefa"></input>
                                    </div>
                                        <div class="form-group">
                                            <label for="tecnicoResp">Técnico responsável</label>
                                            <select class="form-control" id="tecnicoResp">
                                                <option value=""></option>
                                                <option value="Bruno">Bruno</option>
                                                <option value="Felipe">Felipe</option>
                                                <option value="Flavio">Flavio</option>
                                                <option value="Miguel">Miguel</option>
                                                <option value="Nilton">Nilton</option>
                                                <option value="Rodrigo">Rodrigo</option>
                                                <option value="Samuel">Samuel</option>
                                            </select>
                                        </div>
                                </div>
                                </div>
                                </div>
                            </div>
                        </div>
                        <div class="wizard-footer">
                            <div class="pull-right">
                                <input type='button' class='btn btn-next btn-fill btn-info btn-wd btn-sm'
                                       name='next' value='Next'/>
                                <input type='submit' class='btn btn-finish btn-fill btn-info btn-wd btn-sm'
                                       name='finish' value='Finish'/>
                            </div>
                            <div class="pull-left">
                                <input type='button'
                                       class='btn btn-previous btn-fill btn-default btn-wd btn-sm'
                                       name='previous' value='Previous'/>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                    </form>
                </div>
            </div> <!-- wizard container -->

                <%--<div class="footer">--%>
                <%--<div class="container">--%>
                <%--Made with <i class="fa fa-heart heart"></i> by <a href="http://www.creative-tim.com">Creative Tim</a>. Free download <a href="http://www.creative-tim.com/product/bootstrap-wizard">here.</a>--%>
                <%--</div>--%>
                <%--</div>--%>


        </div>

    </jsp:body>
</tags:layout>
