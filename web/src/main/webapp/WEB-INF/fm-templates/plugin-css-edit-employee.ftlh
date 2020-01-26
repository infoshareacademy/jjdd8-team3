<link href="/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
<link href="/css/bootstrap-datepicker.css" rel="stylesheet">
<script>
    function deleteEmployee(id) {

        // event.preventDefault(); // Prevent the form from submitting via the browser

        $.ajax({
            type: "DELETE",
            url: "/api/employee/delete/"+id,
            data: id,
        })
            .done(
                function (data) {
                    $('#modal-button').attr('onClick', 'window.location.href="/manager/edit-employee";');
                    $('#modal-info-body').html("Employee: "+ data.first_name +" "+ data.surname +" removed!");
                    $('#infoModal').modal('show');

                })
            .fail(
                function () {
                    $('#modal-info-body').html("Ups... Operation failed!!!");
                    $('#infoModal').modal('show');
                });
    };
</script>