/**
 * Created by samuel on 15/09/2017.
 */
//Variável global salvar tarefas
var listaTarefas = [];
$(function () {
    $(".datePicker").datepicker({
        format: "dd/mm/yyyy"
    });
    
    $(".valor-date").each(function () {
        console.log($(this).val());
    })
    
});