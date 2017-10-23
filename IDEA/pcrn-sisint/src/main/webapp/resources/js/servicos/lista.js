/**
 * Created by samue on 15/09/2017.
 */

$(document).ready(function () {
    var $tabela = $(this).find('table');
    var $span =  $(this).find('span');
    var status = {
        concluido: "Concluído",
        emExecucao: "Em execução",
        cancelado: "Em execução",
        aguardando: "Aguardando execução",
    };
    var prioridade = {
        alta: "Alta",
        media: "Média",
        baixa: "Baixa",
    };
    $span.each(function () {
        var descricao =  $(this).text();
        console.log(descricao);
        if(descricao == status.concluido) {
            $(this).addClass('label-success');
            $(this).removeClass('label-info');
        } else if(descricao == status.emExecucao || descricao == prioridade.baixa){
            $(this).addClass('label-info');
            $(this).removeClass('label-success');
        } else if(descricao == status.cancelado || descricao == prioridade.alta){
            $(this).addClass('label-danger');
        } else if(descricao == status.aguardando || descricao == prioridade.media){
            $(this).addClass('label-warning');
        }
    });
    var table= $('#tabela-servico').DataTable( {
        pageLength:25,
        "language":
            {
                "sEmptyTable": "Nenhum registro encontrado",
                "sInfo": "Mostrando de _START_ até _END_ de _TOTAL_ registros",
                "sInfoEmpty": "Mostrando 0 até 0 de 0 registros",
                "sInfoFiltered": "(Filtrados de _MAX_ registros)",
                "sInfoPostFix": "",
                "sInfoThousands": ".",
                "sLengthMenu": "_MENU_ resultados por página",
                "sLoadingRecords": "Carregando...",
                "sProcessing": "Processando...",
                "sZeroRecords": "Nenhum registro encontrado",
                "sSearch": "Pesquisar",
                "oPaginate": {
                    "sNext": "Próximo",
                    "sPrevious": "Anterior",
                    "sFirst": "Primeiro",
                    "sLast": "Último"
                },
                "oAria": {
                    "sSortAscending": ": Ordenar colunas de forma ascendente",
                    "sSortDescending": ": Ordenar colunas de forma descendente"
                }
            }
    } );

    new $.fn.dataTable.Buttons( table, {

    } );
    table.buttons().container()
        .appendTo( $('.col-sm-6:eq(0)', table.table().container() ) );

});





