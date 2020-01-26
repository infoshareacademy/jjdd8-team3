<!-- Page level plugins -->
<script>

    // Helper function to serialize all the form fields into a JSON string
    function formToJSON() {
        return JSON.stringify({
            "first_name": $('#employee-first-name').val(),
            "surname": $('#employee-surname').val(),
            "hire_date": $('#employee-hire-date'),
            "holiday_entitlement": $('#employee-holiday-entitlement'),
            "additional_entitlement": $('#employee-additional-entitlement'),
            "login": $('#employee-login'),
            "email": $('#employee-email').val(),
            "position": $('#employee-position').val(),
            "team_id": $('#employee-team-id').val(),
            "role": $('#employee-role').val()
        });
    }

    $('#add-employee-form').submit(function (event) {

        event.preventDefault(); // Prevent the form from submitting via the browser

        $.ajax({
            type: <#if action == "edit">"PUT"<#else>"POST"</#if>,
            url: <#if action == "edit">"/api/employee/put/"+$('#employee-id').val()<#else>"/api/employee/add"</#if>,
            enctype: 'application/json;charset=UTF-8',
            dataType: 'json',
            data: formToJSON(),
            contentType: 'application/json;charset=UTF-8'
        })
            .done(
                function (data) {
                    $('#modal-button').attr('onClick', 'window.location.href="/manager/edit-employee";');
                    $('#modal-info-body').html("New employee: " + data.first_name + " " + data.surname + " registered");
                    $('#infoModal').modal('show');
                })
            .fail(
                function () {
                    $('#modal-info-body').html("Ups... Operation failed!!!");
                    $('#infoModal').modal('show');
                });
    });

</script>