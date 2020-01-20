<!-- Page level plugins -->
<script src="/vendor/datatables/jquery.dataTables.min.js"></script>
<script src="/vendor/datatables/dataTables.bootstrap4.min.js"></script>

<!-- Page level custom scripts -->
<script src="/js/demo/datatables-demo.js"></script>

<script src="/js/bootstrap-datepicker.min.js"></script>


<script>

    $('#holiday-date').datepicker({
        clearBtn: false,
        format: "yyyy-mm-dd"
    });
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
            url: <#if action == "edit">"/api/holiday/put/"+$('#holiday-id').val()<#else>\"/api/holiday/add"</#if>,
            enctype: 'application/json;charset=UTF-8',
            dataType: 'json',
            data: formToJSON(),
            contentType: 'application/json;charset=UTF-8'
        // contentType: 'application/json',
    })
    .done(
            function (data) {
                $('#modal-info-body').html(data.name + data.date);
                $('#infoModal').modal('show');
            })
            .fail(
                function () {
                    $('#modal-info-body').html("Ups... Operation failed!!!");
                    $('#infoModal').modal('show');
                });
    });

</script>