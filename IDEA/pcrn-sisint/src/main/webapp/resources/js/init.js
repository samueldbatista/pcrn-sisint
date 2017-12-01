/**
 * Created by samue on 15/09/2017.
 */

$(document).ready(function () {
    $(".datePicker").datepicker({
        format: "dd/mm/yyyy"
    });

    $(".date-column").each(function () {
        var data =  $(this).text();
        data = moment(data, 'YYYY-MM-DD').format('DD/MM/YYYY');
        $(this).text(data);
    });
});





