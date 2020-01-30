<!-- Page level plugins -->
<script>

    // Helper function to serialize all the form fields into a JSON string
    function formToJSON() {
        return JSON.stringify({
            "team_name": $('#team-name').val()
        });
    }

    $('#add-team-form').submit(function (event) {

        event.preventDefault(); // Prevent the form from submitting via the browser

        $.ajax({
            type: <#if action == "edit">"PUT"<#else>"POST"</#if>,
            url: <#if action == "edit">"/api/team/put/"+$('#team-id').val()<#else>"/api/team/add"</#if>,
            enctype: 'application/json;charset=UTF-8',
            dataType: 'json',
            data: formToJSON(),
            contentType: 'application/json;charset=UTF-8'
        })
            .done(
                function (data) {
                    $('#modal-button').attr('onClick', 'window.location.href="/manager/edit-team";');
                    $('#modal-info-body').html("New team: " + data.team_name + " defined");
                    $('#infoModal').modal('show');
                })
            .fail(
                function () {
                    $('#modal-info-body').html("Ups... Operation failed!!!");
                    $('#infoModal').modal('show');
                });
    });

</script>