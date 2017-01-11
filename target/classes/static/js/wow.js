$(document).ready(function () {
    $('select').material_select();
});

$(document).ready(function(){
    $('.parallax').parallax();
});

$('.carousel.carousel-slider').carousel({full_width: true});

// Toast
$(document).ready(function(){
    $('.tooltipped').tooltip({delay: 50});
});

// Datepicker
$('.datepicker').pickadate({
    selectMonths: true, // Creates a dropdown to control month
    selectYears: 100, // Creates a dropdown of 15 years to control year
    max: true,
    // Accessibility labels
    labelMonthNext: 'След. месяц',
    labelMonthPrev: 'Пред. месяц',
    labelMonthSelect: 'Выбирай месяц',
    labelYearSelect: 'Выбирай год',
    monthsFull: [ 'Январь', 'Февраль', 'Март', 'Апрель', 'Май', 'Июнь', 'Июль', 'Август', 'Сентябрь', 'Октябрь', 'Ноябрь', 'Декабрь' ],
    monthsShort: [ 'Янв', 'Фев', 'Март', 'Апр', 'Май', 'Июнь', 'Июль', 'Авг', 'Сент', 'Окт', 'Ноя', 'Дек' ],
    weekdaysFull: [ 'Воскресенье', 'Понедельник', 'Вторник', 'Среда', 'Четверг', 'Пятница', 'Суббота' ],
    weekdaysShort: [ 'Вск', 'Пон', 'Вт', 'Ср', 'Чт', 'Пт', 'Суб' ],
    weekdaysLetter: [ 'Вс', 'Пн', 'Вт', 'Ср', 'Чт', 'Пт', 'Сб' ],
    today: '',
    clear: 'Очистить',
    close: 'Сохранить',
    format: 'dd.mm.yyyy' // date format 11 января 2016
});

// Modal init
$(document).ready(function(){
    // the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
    $('.modal').modal();
});