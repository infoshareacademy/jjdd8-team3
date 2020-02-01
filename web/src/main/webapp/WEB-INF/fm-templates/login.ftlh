<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="google-signin-client_id"
          content="326852231702-jbh7kmdv8q7kd4dj8c3rancldhc1das1.apps.googleusercontent.com">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Vacation Mgnt. Login</title>

    <!-- Custom fonts for this template-->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.min.css" rel="stylesheet"
          type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
          rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="/css/sb-admin-2.css" rel="stylesheet">
    <script src="https://apis.google.com/js/platform.js" async defer></script>


</head>

<body class="bg-gradient-primary">

<div class="container">

    <!-- Outer Row -->
    <div class="row justify-content-around">

        <div class="col-xl-10 col-lg-12 col-md-9">

            <div class="card o-hidden border-0 shadow-lg my-5">
                <div class="card-body p-0">
                    <!-- Nested Row within Card Body -->
                    <div class="row">
                            <div class="card-body">
                                <div class="text-center">
                                    <img class="img-fluid px-3 px-sm-4 mt-3 mb-4" style="width: 25rem;"
                                         src="/img/undraw_personal_goals_edgd.svg" alt="women on vacation">
                                </div>
                            </div>
                        <div class="col-lg-6">
                            <div class="p-5">
                                <div class="text-center">
                                    <h1 class="h4 text-gray-900 mb-4">Welcome </h1>
                                    <h3>Vacation Manager by HighFive team</h3>
                                </div>
                                <form class="user">
                                    <div class="form-group">
                                        <div class="g-signin2" data-width="350" data-height="50" data-longtitle="true"
                                             data-onsuccess="onSignIn"></div>
                                    </div>
                                </form>
                                <hr>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>

    </div>

</div>

<script src="js/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>

<script src="js/jquery.easing.min.js"></script>


<!-- Custom scripts for all pages-->
<script src="js/sb-admin-2.min.js"></script>
<script>

    function onSignIn(googleUser) {
        var id_token = googleUser.getAuthResponse().id_token;

        var form = $('<form action="/login" method="post">' +
            '<input type="text" name="idToken" value="' +
            id_token + '" />' +
            '</form>');
        $('body').append(form);
        form.submit();
    }
</script>


</body>

</html>
