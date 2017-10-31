/**
 * Created by samue on 15/09/2017.
 */

$(function () {

    console.log('Carregou com sucesso!');
    var tarefas = [];
    var btnSalvarTarefas = $('#btnt');
    var btnServico = $('#btnServico');
    
    $('#btnSalvarTarefa').click(function (e) {
        e.preventDefault();

        var id = $("input[name='tarefa.id']");
        var titulo = $("input[name='tarefa.titulo']");
        var tecnico = $("select[name='tarefa.tecnico']");
        var descricao = $("textarea[name='tarefa.descricao']");
        var dataFechamento = $("input[name='tarefa.dataFechamento']");
        var pendencia = $("input[name='tarefa.pendencia']");
        var status = $("select[name='tarefa.statusTarefa']");

        var urlTarefa = $("#urlSalvarTarefa").val();
        var tecnicoResponsaval = {
            id:tecnico.val()
        }

        var prazo = moment(dataFechamento.val(), 'DD/MM/YYYY').format('YYYY-MM-DD');
        var dateteste =  moment.utc(prazo);
        var prazo = dateteste.toISOString();

        console.log(prazo);
        var tarefa = {};
        console.log(tecnico.val());
        tarefa.id = id.val();
        tarefa.titulo = titulo.val();
        tarefa.tecnico = tecnicoResponsaval;
        tarefa.descricao = descricao.val();
        tarefa.dataFechamento = prazo;
        tarefa.statusTarefa = status.val();
        tarefa.pendencia = pendencia.val();

        tarefas.push(tarefa);
        // var data = tarefa;

        // var data = $.ConverterObjetoParaVraptor("tarefa",tarefa);

        // $.ajax({
        //     url: urlTarefa,
        //
        //     type: 'POST',
        //
        //     data: data
        //
        // }).done(function(data) {
        //     alert('Deu certo');
        //     //gerarAccodion de tarefa;
        //     // window.location.href = "http://localhost:8080/servicos/lista"
        // }).fail(function(jqXHR, textStatus, errorThrown) {
        //
        //     alert("O serviço não foi salvo!");
        //
        // });
    });


    btnServico.click(function(evento) {
        evento.preventDefault();

        var id = $("input[name='servico.id']");
        var titulo = $("input[name='servico.titulo']");
        var dataFechamento = $("input[name='servico.dataFechamento']");
        var descricao = $("textarea[name='servico.descricao']");
        var prioridade = $("select[name='servico.prioridade']");
        var tecnico = $("select[name='servico.tecnico']");
        var setor = $("select[name='servico.setor']");

        var obj = moment(dataFechamento.val(), 'DD/MM/YYYY').format('YYYY-MM-DD');
        var dateteste =  moment.utc(obj);
        var obj = dateteste.toISOString();
        console.log(obj);
        var tecnicoResp = {};
        tecnicoResp.id = tecnico.val();
        var setorSolicitante = {};
        setorSolicitante.id = setor.val();

        console.log("ID DO SETOR: " + setor.val());

        var objeto = {};
        objeto.titulo = titulo.val();
        objeto.dataFechamento = obj;
        objeto.descricao = descricao.val();
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