<!-- Page level plugins -->
<script>
    // Add the following code if you want the name of the file appear on select
    $(".custom-file-input").on("change", function () {
        var fileName = $(this).val().split("\\").pop();
        $(this).siblings(".custom-file-label").addClass("selected").html(fileName);
    });


    $('#upload-form').submit(function (event) {

        event.preventDefault(); // Prevent the form from submitting via the browser

        $.ajax({
            type: "POST",
            url: $(this).attr('action'),
            enctype: 'multipart/form-data',
            data: new FormData(this),
            processData: false,
            contentType: false
        })
            .done(
                function (data) {
                $('#modal-info-body').html(data);
                $('#infoModal').modal('show');
                $('#file-name').val(null);
                $('label[for="'+  $('#file-name').attr('id') +'"]').html('Choose file');
        })
            .fail(
                function (data) {
                $('#modal-info-body').html("Ups... Operation failed!!!");
                $('#infoModal').modal('show');
                $('#file-name').val(null);
                $('label[for="'+  $('#file-name').attr('id') +'"]').html('Choose file');
        });
    });

</script>