<link href="/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
<link href="/css/bootstrap-datepicker.css" rel="stylesheet">
<script>
    function deleteTeam(id) {

        // event.preventDefault(); // Prevent the form from submitting via the browser

        $.ajax({
            type: "DELETE",
            url: "/api/team/delete/"+id,
            data: id,
        })
            .done(
                function (data) {
                    $('#modal-button').attr('onClick', 'window.location.href="/manager/edit-team";');
                    $('#modal-info-body').html("Team: "+ data.teamName +" removed!");
                    $('#infoModal').modal('show');

                })
            .fail(
                function () {
                    $('#modal-info-body').html("Ups... Operation failed!!!");
                    $('#infoModal').modal('show');
                });
    };
</script>