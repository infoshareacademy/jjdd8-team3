// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = 'Nunito', '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#535562';

ratioFromApi=[];
$.ajax({
  type: "GET",
  url: "/api/vacation/admin/approved-denied-ratio",
  enctype: 'text/html; charset=UTF-8',
  dataType: 'json',
  contentType: 'text/html; charset=UTF-8'
})
    .done(
        function (data) {
            ratio = data;
            calcRatio = 100 - ratio;
            ratioFromApi.push(
                parseFloat(ratio).toFixed(2)
            );
            ratioFromApi.push(
                parseFloat(calcRatio).toFixed(2)
            );
          myPieRatio.config.data.datasets[0].data=ratioFromApi; // Would update the first dataset's value of 'March' to be 50
          myPieRatio.update();
        })
    .fail(
        function () {
          $('#modal-info-body').html("Ups... API request data Operation failed!!!");
          $('#infoModal').modal('show');
        });

// Pie Chart Example
var ctx = document.getElementById("myPieRatio");
var myPieRatio = new Chart(ctx, {
  type: 'doughnut',
  data: {
    labels: ["Approved", "Denied"],
    datasets: [{
      data: ratioFromApi,
      backgroundColor: ['#1cc88a','#4e73df'],
      hoverBackgroundColor: ['#17a673','#2e59d9'],
      hoverBorderColor: "rgba(234, 236, 244, 1)",
    }],
  },
  options: {
    maintainAspectRatio: false,
    tooltips: {
      backgroundColor: "rgb(255,255,255)",
      bodyFontColor: "#858796",
      borderColor: '#dddfeb',
      borderWidth: 1,
      xPadding: 15,
      yPadding: 15,
      displayColors: false,
      caretPadding: 10,
    },
    legend: {
      display: true
    },
    cutoutPercentage: 60,
  },
});
