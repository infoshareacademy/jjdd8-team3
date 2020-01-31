<!-- Page level plugins -->
<script src="/vendor/datatables/jquery.dataTables.min.js"></script>
<script src="/vendor/datatables/dataTables.bootstrap4.min.js"></script>

<!-- Page level custom scripts -->
<script src="/js/demo/datatables-demo.js"></script>

<script src="/js/bootstrap-datepicker.min.js"></script>


<script>

    $('#employee-hire-date').datepicker({
        clearBtn: false,
        format: "yyyy-mm-dd"
    });
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
            "team_id": $('#employee-team_id').val(),
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
                $('#modal-info-body').html("Operation complete on employee: " +date.first_name +" "+ data.surname);
                $('#infoModal').modal('show');
            })
            .fail(
                function () {
                    $('#modal-info-body').html("Ups... Operation failed!!!");
                    $('#infoModal').modal('show');
                });
    });

</script>