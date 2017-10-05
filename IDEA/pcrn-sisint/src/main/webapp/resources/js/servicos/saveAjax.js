
$(function () {
    console.log('Carregou com sucesso!');
    var tarefas = [];
    var btnSalvarTarefas = $('#btnAdicionar');
    var btnSalvarServico = $('#btnSalvarServico');

    btnSalvarTarefas.click(function(evento) {

        var titulo = $("input[name = 'tarefa.titulo']");
        var descricao = $("textarea[name = 'tarefa.descricao']");
        var prazo = $("input[name = 'tarefa.prazo']");
        var tecnico = $("input[name = 'tarefa.tecnico']");
        //console.log($(titulo).val());

        var obj = {};
        obj.descricao = descricao.val();
        obj.prazo = prazo.val();


        tarefas.push(obj);
        console.log(tarefas);
        console.log(obj);

        var data = $.ConverterObjetoParaVraptor("tarefa", obj);

        console.log(data);
        var url = $("#urlSalvar").val();
        console.log("Url: ", url);
        titulo.empty();

    });

    btnSalvarServico.on('click',function(evento) {

        var titulo = $("input[name='servico.titulo']");
        var dataAbertura = $("input[name='servico.dataAbertura']");
        var dataFechamento = $("input[name='servico.dataFechamento']");
        var descricao = $("textarea[name='servico.descricao']");
        var statusServico = $("select[name='servico.statusServico']");

        // console.log(titulo.val() + dataAbertura.val() + dataFechamento.val() + descricao.val());


        var objeto = {};
        objeto.titulo = titulo.val();
        objeto.descricao = descricao.val();
        objeto.tarefas = tarefas;
        objeto.dataFechamento = dataFechamento.val();
        objeto.dataAbertura = dataAbertura.val();
        objeto.statusServico = statusServico.val();
        // console.log(objeto.statusServico)
        console.log(moment.parseZone(dataAbertura, "MM-DD-YYYY"));
        var dateteste =  moment.utc(dataAbertura.val());
        var servico = $.ConverterObjetoParaVraptor("servico", objeto);

        console.log("Teste form" + objeto);

        var url = $("#urlSalvar").val();

        data = servico;

        $.ajax({

            url: url,

            type: 'POST',

            data: data

        }).done(function(data) {
            /* executada em caso de sucesso*/
            window.location.href = "http://localhost:8080/servicos/lista"

        }).fail(function(jqXHR, textStatus, errorThrown) {

            /* executada em caso de erro*/              alert("O serviço não foi salvo!");

        });
    });

});