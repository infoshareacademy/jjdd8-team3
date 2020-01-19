<!-- Page level plugins -->
<script>
    // Add the following code if you want the name of the file appear on select
    $(".custom-file-input").on("change", function () {
        let fileName = $(this).val().split("\\").pop();
        $(this).siblings(".custom-file-label").addClass("selected").html(fileName);
    });


    $('#upload-form').submit(function (event) {

        event.preventDefault(); // Prevent the form from submitting via the browser

        $.ajax({
            type: "POST",
            //url: $(this).attr('action'),
            url: "/api/holiday/upload",
            enctype: 'multipart/form-data',
            data: new FormData(this),
            processData: false,
            contentType: false,
            beforeSend: function( ) {
                $('#infoModal').modal('show');
            }
        })
            .done(
                function (data) {
                $('#modal-info-body').html(data);
                $('#file-name').val(null);
                $('label[for="'+  $('#file-name').attr('id') +'"]').html('Choose file');
        })
            .fail(
                function (data) {
                $('#modal-info-body').html("Ups... Operation failed!!!");
                $('#file-name').val(null);
                $('label[for="'+  $('#file-name').attr('id') +'"]').html('Choose file');

        });
        $('#modal-info-body').html('<img src="/img/ajax-loader.gif" alt="loading spinner"/>');
    });

</script>