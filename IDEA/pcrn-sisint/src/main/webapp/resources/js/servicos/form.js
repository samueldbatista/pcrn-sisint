/**
 * Created by samue on 15/09/2017.
 */

$(function () {

    console.log('Carregou com sucesso!');
    var tarefas = [];
    var btnSalvarTarefas = $('#btnAdicionar');
    var btnServico = $('#btnServico');

    btnSalvarTarefas.click(function(evento) {

        var statusTarefa = $("input[name = 'tarefa.statusTarefa']");
        var descricao = $("textarea[name = 'tarefa.descricao']");
        var prazo = $("input[name = 'tarefa.prazo']");
        var tecnico = $("input[name = 'tarefa.tecnico']");

        var obj = {};
        obj.tecnico = tecnico.val();
        obj.statusTarefa = statusTarefa.val();
        obj.descricao = descricao.val();
        obj.prazo = prazo.val();

        tarefas.push(obj);
        var data = $.ConverterObjetoParaVraptor("tarefa", obj);

        var url = $("#urlSalvar").val();

        statusTarefa.val('');
        descricao.val('');
        prazo.val('');
        tecnico.val('');
    });

    btnServico.click(function(evento) {
        evento.preventDefault();
        console.log("TESTESTESTE")
        var titulo = $("input[name='servico.titulo']");
        var dataFechamento = $("input[name='servico.dataFechamento']");
        var pendencia = $("input[name='servico.pendencia']");
        var descricao = $("textarea[name='servico.descricao']");
        var statusServico = $("select[name='servico.statusServico']");
        var prioridade = $("select[name='servico.prioridade']");
        var tecnico = $("select[name='servico.tecnico']");
        var setor = $("select[name='servico.setor']");

        var obj = moment(dataFechamento.val(), 'DD/MM/YYYY').format('YYYY/MM/DD')
        var dateteste =  moment.utc(obj);
        var obj = dateteste.toISOString();
        var tecnicoResp = {};
        tecnicoResp.id = tecnico.val();
        var setorSolicitante = {};
        setorSolicitante.id = setor.val();



        console.log("ID DO SETOR: " + setor.val());

        var objeto = {};
        objeto.titulo = titulo.val();
        objeto.dataFechamento = obj;
        objeto.pendencia = pendencia.val();
        objeto.descricao = descricao.val();
        objeto.statusServico = statusServico.val();
        objeto.prioridade = prioridade.val();
        objeto.tecnico = tecnicoResp;
        objeto.tarefas = tarefas;
        objeto.setor = setorSolicitante;

        var servico = $.ConverterObjetoParaVraptor("servico", objeto);

        console.log("Teste form" + objeto);

        var url = $("#urlSalvar").val();

        data = servico;

        $.ajax({

            url: url,

            type: 'POST',

            data: data

        }).done(function(data) {
            window.location.href = "http://localhost:8080/servicos/lista"
        }).fail(function(jqXHR, textStatus, errorThrown) {

            alert("O serviço não foi salvo!");

        });
    });

    $(".datePicker").datepicker({
        format: "dd/mm/yyyy"
    });

});





