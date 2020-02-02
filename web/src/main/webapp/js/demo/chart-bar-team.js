// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = 'Nunito', '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#535562';

function number_format(number, decimals, dec_point, thousands_sep) {

    number = (number + '').replace(',', '').replace(' ', '');
    var n = !isFinite(+number) ? 0 : +number,
        prec = !isFinite(+decimals) ? 0 : Math.abs(decimals),
        sep = (typeof thousands_sep === 'undefined') ? ',' : thousands_sep,
        dec = (typeof dec_point === 'undefined') ? '.' : dec_point,
        s = '',
        toFixedFix = function(n, prec) {
            var k = Math.pow(10, prec);
            return '' + Math.round(n * k) / k;
        };
    // Fix for IE parseFloat(0.55).toFixed(0) = 0;
    s = (prec ? toFixedFix(n, prec) : '' + Math.round(n)).split('.');
    if (s[0].length > 3) {
        s[0] = s[0].replace(/\B(?=(?:\d{3})+(?!\d))/g, sep);
    }
    if ((s[1] || '').length < prec) {
        s[1] = s[1] || '';
        s[1] += new Array(prec - s[1].length + 1).join('0');
    }
    return s.join(dec);
}

countFromApi=[];
teamsFromApi=[];
$.ajax({
    type: "GET",
    url: "/api/vacation/admin/taken-by-team",
    enctype: 'application/json;charset=UTF-8',
    dataType: 'json',
    contentType: 'application/json;charset=UTF-8'
})
    .done(
        function (data) {
            $.each(data, function (i, item) {
                teamCount = item[0];
                teamName = item[1];
                countFromApi.push(
                    teamCount
                );
                teamsFromApi.push(
                    teamName
                );
                //$('#alert-list').show();
            });
            myBarTeam.config.data.datasets[0].data=countFromApi; // Would update the first dataset's value of 'March' to be 50
            myBarTeam.config.data.labels=teamsFromApi; // Would update the first dataset's value of 'March' to be 50
            myBarTeam.update();
        })
    .fail(
        function () {
            $('#modal-info-body').html("Ups... API request data Operation failed!!!");
            $('#infoModal').modal('show');
        });


// Bar Chart Example
var ctx = document.getElementById("myBarTeam");
var myBarTeam = new Chart(ctx, {
    type: 'bar',
    data: {
        labels: teamsFromApi,
        datasets: [{
            label: "Vacation taken",
            backgroundColor: "#d96e5f",
            hoverBackgroundColor: "#a62111",
            borderColor: "#4e73df",
            data: countFromApi,
        }],
    },
    options: {
        maintainAspectRatio: false,
        layout: {
            padding: {
                left: 10,
                right: 25,
                top: 25,
                bottom: 0
            }
        },
        scales: {
            xAxes: [{
                gridLines: {
                    display: false,
                    drawBorder: false
                },
                ticks: {
                    maxTicksLimit: 5
                },
                maxBarThickness: 40,
            }],
            yAxes: [{
                ticks: {
                    min: 0,
                    max: 30,
                    maxTicksLimit: 5,
                    padding: 10,
                    // Include a dollar sign in the ticks
                    callback: function(value, index, values) {
                        return number_format(value);
                    }
                },
                gridLines: {
                    color: "rgb(234, 236, 244)",
                    zeroLineColor: "rgb(234, 236, 244)",
                    drawBorder: false,
                    borderDash: [2],
                    zeroLineBorderDash: [2]
                }
            }],
        },
        legend: {
            display: false
        },
        tooltips: {
            titleMarginBottom: 10,
            titleFontColor: '#6e707e',
            titleFontSize: 14,
            backgroundColor: "rgb(255,255,255)",
            bodyFontColor: "#858796",
            borderColor: '#dddfeb',
            borderWidth: 1,
            xPadding: 15,
            yPadding: 15,
            displayColors: false,
            caretPadding: 10,
            callbacks: {
                label: function(tooltipItem, chart) {
                    var datasetLabel = chart.datasets[tooltipItem.datasetIndex].label || '';
                    return datasetLabel + ': Total days ' + number_format(tooltipItem.yLabel);
                }
            }
        },
    }
});