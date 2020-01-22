<link href="/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
<link href="/css/bootstrap-datepicker.css" rel="stylesheet">
<script>
    function deleteHoliday(id) {

        // event.preventDefault(); // Prevent the form from submitting via the browser

        $.ajax({
            type: "DELETE",
            url: "/api/holiday/delete/"+id,
            data: id,
        })
            .done(
                function (data) {
                    $('#modal-button').attr('onClick', 'window.location.href="/admin/edit-holiday";');
                    $('#modal-info-body').html("Holiday: "+ data.name +" " + data.date+ " removed!");
                    $('#infoModal').modal('show');

                })
            .fail(
                function () {
                    $('#modal-info-body').html("Ups... Operation failed!!!");
                    $('#infoModal').modal('show');
                });
    };
</script>