/**
 * Created by samue on 15/09/2017.
 */

$(document).ready(function () {
    var $tabela = $(this).find('table');
    var $span =  $(this).find('span');
    var obj = {
        concluido: "Concluído",
        andamento: ""
    };
    $span.each(function () {
        var descricao =  $(this).text();
        console.log(descricao);
        if(descricao == 'Concluído') {
            $(this).addClass('label-success');
            $(this).removeClass('label-info');
        } else if(descricao == 'Em execução'){
            $(this).addClass('label-info');
            $(this).removeClass('label-success');
        } else if(descricao == 'Cancelado'){
            $(this).addClass('label-danger');
        } else if(descricao == 'Aguardando execução'){
            $(this).addClass('label-warning');
        }
    });
});





