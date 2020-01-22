<!-- Page level plugins -->
<script>

    // Helper function to serialize all the form fields into a JSON string
    function formToJSON() {
        return JSON.stringify({
            "name": $('#holiday-name').val(),
            "description": $('#holiday-description').val(),
            "type": $('#holiday-type').val(),
            "date": $('#holiday-date').val()
        });
    }

    $('#add-holiday-form').submit(function (event) {

        event.preventDefault(); // Prevent the form from submitting via the browser

        $.ajax({
            type: <#if action == "edit">"PUT"<#else>"POST"</#if>,
            url: <#if action == "edit">"/api/holiday/put/"+$('#holiday-id').val()<#else>"/api/holiday/add"</#if>,
            enctype: 'application/json;charset=UTF-8',
            dataType: 'json',
            data: formToJSON(),
            contentType: 'application/json;charset=UTF-8'
        })
            .done(
                function (data) {
                    $('#modal-button').attr('onClick', 'window.location.href="/admin/edit-holiday";');
                    $('#modal-info-body').html("Holiday: " + data.name + " added for date: " + data.date);
                    $('#infoModal').modal('show');
                })
            .fail(
                function () {
                    $('#modal-info-body').html("Ups... Operation failed!!!");
                    $('#infoModal').modal('show');
                });
    });

</script>