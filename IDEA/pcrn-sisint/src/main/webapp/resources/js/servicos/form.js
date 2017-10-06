/**
 * Created by samue on 15/09/2017.
 */

$(document).ready(function () {

    var navListItems = $('div.setup-panel div a'),
        allWells = $('.setup-content'),
        allNextBtn = $('.nextBtn'),
        allPreviousBtn = $('previousBtn');

    var btnProximo = $('#proximo');
    var btnAnterior = $('#anterior');
    var btnSalvar = $('#salvar');
    btnAnterior.hide();
    btnSalvar.hide();
    console.log(btnAnterior);
    var step1 = $('.panel-content').find('#step-1');
    var step2 = $('.panel-content').find('#step-2');

    var btnServico = $('#btnServico');
    var btnTarefa = $('#btnTarefa');

    allWells.hide();
    step1.show();

    navListItems.click(function (e) {
        e.preventDefault();
        var $target = $($(this).attr('href')),
            $item = $(this),
            $idTela = $($(this).attr('id'));

        if (!$item.hasClass('btn-primary')) {
            navListItems.removeClass('btn-primary').addClass('btn-default');
            $item.addClass('btn-primary');
            allWells.hide();
            $target.show();
            $target.find('input:eq(0)').focus();
        }
    });

    btnTarefa.click(function (e) {
        e.preventDefault();
        console.log("BTN ANTERIOR");
        btnAnterior.show();
        btnProximo.hide();
        btnSalvar.show();
    });

    btnServico.click(function (e) {
        e.preventDefault();
        console.log("BTN ANTERIOR");
        btnAnterior.hide();
        btnProximo.show();
        btnSalvar.hide();
    });

    btnProximo.click(function (e) {
        e.preventDefault();
        btnServico.toggleClass('btn-primary btn-default');
        btnTarefa.toggleClass('btn-primary btn-default');
        console.log("BTN ANTERIOR");
        step1.hide();
        step2.show();
        btnAnterior.show();
        btnProximo.hide();
        btnSalvar.show();
    });

    btnAnterior.click(function (e) {
        e.preventDefault();
        btnServico.toggleClass('btn-primary btn-default');
        btnTarefa.toggleClass('btn-primary btn-default');
        step1.show();
        step2.hide();
        btnAnterior.hide();
        btnProximo.show();
        btnSalvar.hide();
    });

    allNextBtn.click(function () {
        var curStep = $(this).closest(".setup-content"),
            curStepBtn = curStep.attr("id"),
            nextStepWizard = $('div.setup-panel div a[href="#' + curStepBtn + '"]').parent().next().children("a"),
            curInputs = curStep.find("input[type='text'],input[type='url']"),
            isValid = true;

        $(".form-group").removeClass("has-error");
        for (var i = 0; i < curInputs.length; i++) {
            if (!curInputs[i].validity.valid) {
                isValid = false;
                $(curInputs[i]).closest(".form-group").addClass("has-error");
            }
        }

        if (isValid)
            nextStepWizard.removeAttr('disabled').trigger('click');
    });

    $('div.setup-panel div a.btn-primary').trigger('click');

    $(".datePicker").datepicker({
        format: "yyyy/mm/dd"
    });

});





