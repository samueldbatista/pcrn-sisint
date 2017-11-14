/**
 * Created by samuel on 15/09/2017.
 */
//Variável global salvar tarefas
var listaTarefas = [];
$(function () {
    var ctx = "";

    var idServico = $('#servico-id').val();
    var ctx = $('#ctx').val();
    var $form = $('#form-servico-tarefa');
    var $tarefasContainer = $('#tarefas-cadastradas');
    var tarefas = [];
    console.log("Id de serviço: " + idServico);
    var url = ctx + "/listaTarefas?id=" + idServico;

    $('#btnSalvarTarefa').click(function (e) {
        e.preventDefault();
        console.log("Vamos salvar um tarefa");
        var id = $("input[name='tarefa.id']");
        var titulo = $("input[name='tarefa.titulo']");
        var tecnico = $("select[name='tarefa.tecnico']");
        var descricao = $("textarea[name='tarefa.descricao']");
        var dataFechamento = $("input[name='tarefa.dataFechamento']");
        var status = $("select[name='tarefa.statusTarefa']");

        var prazo = moment(dataFechamento.val(), 'DD/MM/YYYY').format('YYYY-MM-DD');
        var dateteste =  moment.utc(prazo);
        var prazo = dateteste.toISOString();

        var tarefa = {
            id : id.val(),
            titulo : titulo.val(),
            tecnico : {
                id: tecnico.val()
            },
            descricao : descricao.val(),
            dataFechamento : prazo,
            statusTarefa : {
                valor:status.val()
            }
        };
        tarefas.push(tarefa);
    });


    $.ajax({
        dataType: 'json',
        type: 'GET',
        url: url
    }).done(function (data) {
        listaTarefas.concat(criarTarefasEInserirNaLista(data));
        console.log(listaTarefas);
        var cont = 0;
        listaTarefas.forEach(function (tarefa) {
            console.log(tarefa.descricao);
            criarInputsHidden($form, tarefa, cont);
            cont = cont + 1;
        });

        data.forEach(function (dado) {
            console.log(dado.descricao);
        });

    }).fail(function () {
        // setDescricao("Falha: serviço indisponível", true);
        // estado = null;
    }).always(function () {
        // tabela.spin(false);
    });

    function criarTarefasEInserirNaLista(data) {
        data.forEach(function (dado) {
            console.log(dado.id);
            var tarefa = {
                id: (dado.id),
                titulo: dado.titulo,
                statusTarefa:(dado.statusValor == null) ? null : {
                    valor: dado.statusValor
                },
                dataFechamento: dado.dataFechamento,
                descricao: dado.descricao,
                tecnico: {
                    id: dado.tecnicoId
                }
            };
            listaTarefas.push(tarefa)
        });
        return listaTarefas;
    };


    function criarInputsHidden($form, tarefa, i) {
        $form.prepend("<input " +
            "hidden id='tarefa-servico-"+ i +"' name='servico.tarefas[" + i + "].id' " +
            "value='" + tarefa.id + "'" +
            "/>");
        $form.prepend("<input " +
            "hidden name='servico.tarefas[" + i + "].titulo' " +
            "value='" + tarefa.titulo + "'" +
            "/>");
        $form.prepend("<input " +
            "hidden name='servico.tarefas[" + i + "].dataFechamento' " +
            "value='" + tarefa.dataFechamento + "'" +
            "/>");
        // $form.prepend("<input " +
        //     "hidden name='servico.tarefas[" + i + "].servico' " +
        //     "value='" + tarefa.servico.id + "'" +
        //     "/>");
        $form.prepend("<input " +
            "hidden name='servico.tarefas[" + i + "].statusTarefa' " +
            "value='" + tarefa.statusTarefa.valor + "'" +
            "/>");
        $form.prepend("<input " +
            "hidden name='servico.tarefas[" + i + "].descricao' " +
            "value='" + tarefa.descricao + "'" +
            "/>");
        $form.prepend("<input " +
            "hidden name='servico.tarefas[" + i + "].tecnico' " +
            "value='" + tarefa.tecnico.id + "'" +
            "/>");
        criarWellTarefa();
    }

    function criarWellTarefa() {
        $tarefasContainer.prepend(
            "<div" + " class='col-md-2'>" + "<div class='well' style='padding: 15px;'>" +
            "<a id='editar-tarefa' href='#'>" +
            "<i class='fa fa-pencil-square'></i>" +
            "</a>"+
            " Tarefa 1" +
            "</div>" +
            "</div>"
        );
    }

    $(".datePicker").datepicker({
        format: "dd/mm/yyyy"
    });
});