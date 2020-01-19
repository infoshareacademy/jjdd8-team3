<!-- Page level plugins -->
<script>

  $( function() {

        $( "#holiday-date" ).datepicker({
            numberOfMonths: 1,
            showButtonPanel: false,
            format: 'yyyy-mm-dd'
        });

   });

  // Helper function to serialize all the form fields into a JSON string
  function formToJSON() {
      return JSON.stringify({
          "name": $('#holiday-name').val(),
          "description": $('#holiday-description').val(),
          "holiday_type": $('#holiday-type').val(),
          "holiday_date": $('#holiday-date').val()
      });
  }

    $('#add-holiday-form').submit(function (event) {

        event.preventDefault(); // Prevent the form from submitting via the browser

        $.ajax({
            type: "POST",
            url: "/api/holiday/add",
            enctype: 'application/json;charset=UTF-8',
            dataType: 'json',
            data: formToJSON(),
            contentType: 'application/json;charset=UTF-8'
            // contentType: 'application/json',
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