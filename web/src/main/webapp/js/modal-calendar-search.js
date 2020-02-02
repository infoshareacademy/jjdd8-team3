$(function () {

    $('#modal-calendar-search-button').click(function(){
        $('#calendarModal-search').modal('show');
    });

    $('#calendar-modal-search').calendar({
        enableContextMenu: true,
        enableRangeSelection: false,
        weekStart: 1,
        mouseOnDay: function (e) {
            if (e.events.length > 0) {
                var content = '';

                for (var i in e.events) {
                    content += '<div class="event-tooltip-content">'
                        + '<div class="event-name" style="color:' + e.events[i].color + '">' + e.events[i].name + '</div>'
                        + '<div class="event-location">' + e.events[i].location + '</div>'
                        + '<div class="event-location">' + e.events[i].type + '</div>'
                        + '</div>';
                }

                $(e.element).popover({
                    trigger: 'manual',
                    container: 'body',
                    html: true,
                    content: content
                });

                $(e.element).popover('show');
            }
        },
        mouseOutDay: function (e) {
            if (e.events.length > 0) {
                $(e.element).popover('hide');
            }
        },
        dayContextMenu: function (e) {
            $(e.element).popover('hide');
        },
        dataSource: null
    });

    var dataS = [];
    $.ajax({
        type: "GET",
        url: "/api/holiday/list",
        enctype: 'application/json;charset=UTF-8',
        dataType: 'json',
        async:false,
        contentType: 'application/json;charset=UTF-8'
    })
        .done(
            function (data) {
                $.each(data, function (i, item) {
                    dataS.push({
                        id: item.id,
                        name: item.name,
                        location: item.description,
                        type: item.type,
                        typeStyle: 'box',
                        startDate: new Date(item.year, item.month - 1, item.day),
                        endDate: new Date(item.year, item.month - 1, item.day)
                    });
                });

            })
        .fail(
            function () {
                $('#modal-info-body').html("Ups... Operation failed!!!");
                $('#infoModal').modal('show');
            });

    var dataEmployee = [];
    $.ajax({
        type: "GET",
        url: "/api/vacation/admin/vacations/2020-01-01/2020-12-31",
        enctype: 'application/json;charset=UTF-8',
        dataType: 'json',
        async: false,
        contentType: 'application/json;charset=UTF-8'
    })
        .done(
            function (data) {
                $.each(data, function (i, item) {
                    dataEmployee.push({
                        id: item.id,
                        name: item.first_name + " " +item.surname,
                        location: item.vacation_status,
                        type: item.vacation_type,
                        typeStyle: null,
                        startDate: new Date(item.vacation_from.year, item.vacation_from.monthValue - 1, item.vacation_from.dayOfMonth),
                        endDate: new Date(item.vacation_to.year, item.vacation_to.monthValue - 1, item.vacation_to.dayOfMonth)
                    });
                });
            })
        .fail(
            function () {
                $('#modal-info-body').html("Ups... Operation failed!!!");
                $('#infoModal').modal('show');
            });
    dataCalendar = dataS.concat(dataEmployee);
    $('#calendar-modal-search').data('calendar').setDataSource(dataCalendar);

});