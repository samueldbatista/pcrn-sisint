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
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="tags" uri="tagSisInt" %>
<!DOCTYPE html>
<tags:layout>
    <jsp:attribute name="cabecalho">

        <link rel="stylesheet" href="${ctx}/resources/plugins/dataTables/dataTables.css"/>
        <link rel="stylesheet" href="${ctx}/resources/plugins/dataTables/Buttons-1.4.2/css/buttons.bootstrap4.min.css"/>
    </jsp:attribute>
    <jsp:attribute name="rodape">
        <script src="${ctx}/resources/plugins/dataTables/datatables.js"></script>
        <script src="${ctx}/resources/plugins/dataTables/Buttons-1.4.2/js/buttons.bootstrap4.js"></script>
        <script src="${ctx}/resources/plugins/dataTables/Buttons-1.4.2/js/buttons.html5.min.js"></script>
        <script src="${ctx}/resources/plugins/dataTables/Buttons-1.4.2/js/buttons.print.min.js"></script>
        <script src="${ctx}/resources/plugins/dataTables/Buttons-1.4.2/js/buttons.colVis.min.js"></script>
        <script src="${ctx}/resources/plugins/dataTables/JSZip-2.5.0/jszip.min.js"></script>
        <script src="${ctx}/resources/plugins/dataTables/pdfmake-0.1.32/pdfmake.min.js"></script>
         <script>

             $(document).ready( function () {
                 console.log("ENTROU NO JS");
                 var table = $('#table_id').DataTable( {
//                     dom: 'Bfrtip',
                     buttons: [
                         'copy', 'excel', 'pdf'
                     ],
                     lengthChange: true
                 } );

                 table.buttons().container()
                     .appendTo( '#table_id_filter');

             } );
         </script>
    </jsp:attribute>

    <jsp:body>
        <style type="text/css">
            .container-fluid {
                    padding-left: 0px;
                    padding-right: 0px;
            }
            .btn-group {
                margin-left: 16px;
            }


        </style>
        <div class="card" style="margin-bottom: 8px; border-color: white;">
                <h4 class="display-5" style="margin: 8px;">Gerenciamento de serviços</h4>
        </div>
        <nav class="breadcrumb">
            <a class="breadcrumb-item" href="#">Home</a>
            <a class="breadcrumb-item" href="#">Library</a>
            <a class="breadcrumb-item" href="#">Data</a>
            <span class="breadcrumb-item active">Bootstrap</span>
        </nav>
        <div class="card" style="border-color: #78b3c1;">
            <div class="card-header card-header-sm" style="background-color: #78b3c1;" >
                <div class="card-title titulo-cartao">
                    <h6>Listagem de serviços</h6>
                </div>
            </div>
            <div class="card-body">
                <div id="cadastro-buttons" style="margin-bottom: 16px;">
                    <a href="${linkTo[ServicosController].form}" class="btn btn-primary btn-sm col-md-1">Casdastrar</a>
                </div>
                <table id="table_id" class="table table-striped table-bordered table-line-sm" cellspacing="0" width="100%">
                    <thead>
                    <tr>
                        <th>Título</th>
                        <th>Status</th>
                        <th>Código</th>
                        <th>Prioridade</th>
                        <th>Prazo de finalização</th>
                        <th>Ações</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${servicos}" var="servico">
                    <tr>
                        <td>${servico.titulo}</td>
                        <td>${servico.codigoServico}</td>
                        <td>${servico.descricao}</td>
                        <%--<td><fmt:formatDate value="${servico.dataAbertura}" type="date" pattern="dd/MM/yyyy"/></td>--%>
                        <td>
                            <a href="#"><i class="fa fa-pencil-square-o" aria-hidden="true"></i></a>
                            <a href="#"><i class="fa fa-eye" aria-hidden="true"></i></a>
                            <a href="#"><i class="fa fa-trash-o" aria-hidden="true"></i></a>
                        </td>
                    </tr></c:forEach>
                    <tr>
                        <td>Serviço de cabemento no setor XYZ</td>
                        <td>Em andamento</td>
                        <td>S02233</td>
                        <td>Máxima</td>
                        <td>3 dias</td>
                        <td><a href="#"><i class="fa fa-pencil-square-o" aria-hidden="true"></i></a>
                            <a href="#"><i class="fa fa-eye" aria-hidden="true"></i></a>
                            <a href="#"><i class="fa fa-trash-o" aria-hidden="true"></i></a></td>
                    </tr>
                    <tr>
                        <td>Serviço de cabemento no setor XYZ</td>
                        <td>Em andamento</td>
                        <td>S02233</td>
                        <td>Máxima</td>
                        <td>3 dias</td>
                        <td>Ações</td>
                    </tr>
                    <tr>
                        <td>Nome</td>
                        <td>Email</td>
                        <td>Telefone</td>
                    </tr>
                    <tr>
                        <td>Nome</td>
                        <td>Email</td>
                        <td>Telefone</td>
                    </tr>
                    </tbody>
                </table>
            </div>

        </div>

    </jsp:body>
</tags:layout>
