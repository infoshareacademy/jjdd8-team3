$("#alertsDropdown").click(function () {
    $('#alertsDropdown span').text('');
    sessionStorage.clicked = 1;
    //return false;
});

$('#alertsDropdown').on('hidden.bs.dropdown', function () {
    $('.pending-req').remove();
});

var source = new EventSource("/admin/notify");
lastData = null;
dataSize = 0;
var dates = [];
displayed = 0;
source.addEventListener('message', function (e) {
    var data = JSON.parse(e.data);

    $.each(data, function (i, item) {

        dateTime = Date.parse(item.iso_date_of_request);
        if (sessionStorage.maxdateStored >= dateTime && sessionStorage.clicked == 1) {
            sessionStorage.displayed = 0;
            return;
        }
        sessionStorage.maxdateStored = dateTime;
        dates.push(dateTime);

        if (sessionStorage.displayed == 0) {
            $("#new-request").delay(1000).slideDown("slow", function () {
                sessionStorage.displayed = 1;
            });
            $("#new-request").delay(3000).slideUp("slow");
        }
        sessionStorage.clicked = 0;
        $('.pending-req').remove();
        $('#alert-list').append('<a class="dropdown-item d-flex align-items-center pending-req" href="/manager/pending-requests"><div class="mr-3">'
            + '<div class="icon-circle bg-warning"><i class="fas fa-exclamation-triangle text-white"></i></div>'
            + '</div><div><div class="small text-black-500">' + new Date(dateTime).toLocaleString("pl-PL") + '</div>'
            + item.first_name + ' ' + item.surname + ' requested for vacation'
            + '</div></a>');
        $('#alertsDropdown span').text(data.length);
    });

}, false);

if (typeof (Storage) !== "undefined") {
    if (!sessionStorage.maxdateStored) {
        sessionStorage.maxdateStored = null;
        sessionStorage.clicked = 0;
        sessionStorage.displayed = 0;
    }
} else {
    $('#new-request').html("Sorry, your browser does not support web storage...");
}