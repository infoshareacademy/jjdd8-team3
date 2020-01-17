<!-- Page level plugins -->
<script>

  $( function() {

        $( "#holiday-date" ).datepicker({
            numberOfMonths: 1,
            showButtonPanel: false,
            format: 'yyyy-mm-dd'
        });

   });

  function ConvertFormToJSON(form){
      var array = jQuery(form).serializeArray();
      var json = {};

      jQuery.each(array, function() {
          json[this.name] = this.value || '';
      });

      return json;
  }

    $('#add-holiday-form').submit(function (event) {

        event.preventDefault(); // Prevent the form from submitting via the browser

        $.ajax({
            type: "POST",
            url: $(this).attr('action'),
            //enctype: 'application/json',
            dataType: 'json',
            data: ConvertFormToJSON($(this)),
            contentType: 'application/json;charset=UTF-8',
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