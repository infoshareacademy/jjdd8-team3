<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="HIGH-FIVE">
    <#if title??>
        <title>${title!}</title>
    <#else>
        <title>Vacation Manager</title>
    </#if>

    <!-- Custom fonts for this template-->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.min.css" rel="stylesheet"
          type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
          rel="stylesheet">
    <!-- Custom styles for this template-->
    <link href="/css/sb-admin-2.css" rel="stylesheet" type="text/css">
    <link href="/css/bootstrap-datepicker.css" rel="stylesheet">
    <link href="/js/bootstrap-year-calendar_v2.css" rel="stylesheet">
    <#if pluginCssTemplate??>
        <#include "/${pluginCssTemplate}">
    </#if>
</head>

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">
    <!-- Sidebar -->
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

        <!-- Sidebar - Brand -->
        <a class="sidebar-brand d-flex align-items-center justify-content-center" href="/">
            <div class="sidebar-brand-icon rotate-n-15">
                <i class="fas fa-praying-hands"></i>
            </div>
            <div class="sidebar-brand-text mx-3">Vacation Manager</div>
        </a>

        <!-- Divider -->
        <hr class="sidebar-divider my-0">

        <!-- Nav Item - Dashboard -->
        <li class="nav-item active">
            <a class="nav-link" href="/">
                <i class="fas fa-home"></i>
                <span>Dashboard</span></a>
        </li>

        <!-- Divider -->
        <hr class="sidebar-divider">

        <!-- Heading -->
        <div class="sidebar-heading">
            Vacation
        </div>

        <!-- Nav Item - Pages Collapse Menu -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#reviewMenu" aria-expanded="true"
               aria-controls="reviewMenu">
                <i class="fas fa-calendar-alt"></i>
                <span>Review</span>
            </a>
            <div id="reviewMenu" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                <div class="bg-white py-2 collapse-inner rounded">
                    <a class="collapse-item" href="/list-holidays">Holiday - List</a>
                    <a class="collapse-item" href="/calendar">Calendar</a>
                    <a class="collapse-item" href="/holiday-search">Holiday search</a>
                    <a class="collapse-item" href="/blank">Employee vacation</a>
                    <a class="collapse-item" href="/blank">Team vacation</a>
                </div>
            </div>
        </li>

        <!-- Nav Item - Utilities Collapse Menu -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#requestMenu"
               aria-expanded="true" aria-controls="requestMenu">
                <i class="fas fa-file-alt"></i>
                <span>Requests</span>
            </a>
            <div id="requestMenu" class="collapse" aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
                <div class="bg-white py-2 collapse-inner rounded">
                    <a class="collapse-item" href="/employee/request-vacation">Request vacation</a>
                    <a class="collapse-item" href="/blank">Withdraw request</a>
                </div>
            </div>
        </li>

        <!-- Divider -->
        <hr class="sidebar-divider">

        <!-- Heading -->
        <div class="sidebar-heading">
            Manager
        </div>

        <!-- Approve requests -->
        <li class="nav-item">
            <a class="nav-link" href="/manager/pending-requests">
                <i class="fas fa-hourglass-start"></i>
                <span>Pending requests</span></a>
        </li>

        <!-- Nav Item - Employees -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseEmployees"
               aria-expanded="true" aria-controls="collapseEmployees">
                <i class="fas fa-user"></i>
                <span>Employees</span>
            </a>
            <div id="collapseEmployees" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
                <div class="bg-white py-2 collapse-inner rounded">
                    <a class="collapse-item" href="/blank">Add</a>
                    <a class="collapse-item" href="/blank">Edit</a>
                    <a class="collapse-item" href="/blank">Remove</a>
                </div>
            </div>
        </li>

        <!-- Nav Item - Teams -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTeams"
               aria-expanded="true" aria-controls="collapseTeams">
                <i class="fas fa-users"></i>
                <span>Teams</span>
            </a>
            <div id="collapseTeams" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
                <div class="bg-white py-2 collapse-inner rounded">
                    <a class="collapse-item" href="/blank">Add</a>
                    <a class="collapse-item" href="/blank">Edit</a>
                    <a class="collapse-item" href="/blank">Remove</a>
                </div>
            </div>
        </li>

        <!-- Divider -->
        <hr class="sidebar-divider d-none d-md-block">

        <!-- Heading -->
        <div class="sidebar-heading">
            Administration
        </div>

        <!-- Heading -->
        <li class="nav-item">
            <a class="nav-link" href="/admin/edit-holiday">
                <i class="fas fa-calendar-plus"></i>
                <span>Edit holidays</span></a>
        </li>
        <!-- Nav Item - Configuration -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseConfig"
               aria-expanded="true" aria-controls="collapseConfig">
                <i class="fas fa-cogs"></i>
                <span>Settings</span>
            </a>
            <div id="collapseConfig" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
                <div class="bg-white py-2 collapse-inner rounded">
                    <a class="collapse-item" href="/blank">Date format</a>
                    <a class="collapse-item" href="/blank">Sorting</a>
                    <a class="collapse-item" href="/blank">Holidays database</a>
                    <a class="collapse-item" href="/admin/upload-json">Upload Holiday JSON<br/> form file</a>
                </div>
            </div>
        </li>

        <!-- Divider -->
        <hr class="sidebar-divider d-none d-md-block">

        <!-- Sidebar Toggler (Sidebar) -->
        <div class="text-center d-none d-md-inline">
            <button class="rounded-circle border-0" id="sidebarToggle"></button>
        </div>

    </ul>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">
        <div id="new-request" class="alert alert-danger"
             style="top:50px;position: absolute;z-index: 9999;display: none;left:50%;transform: translate(-50%, 0);"
             role="alert">
            <strong>Hello! You should check in on some of pending request.</strong>
        </div>

        <!-- Main Content -->
        <div id="content">

            <!-- Topbar -->
            <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                <!-- Sidebar Toggle (Topbar) -->
                <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                    <i class="fa fa-bars"></i>
                </button>

                <!-- Topbar Search -->
                <form class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
                    <div class="input-group">
                        <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..."
                               aria-label="Search" aria-describedby="basic-addon2">
                        <div class="input-group-append">
                            <button class="btn btn-primary" type="button">
                                <i class="fas fa-search fa-sm"></i>
                            </button>
                        </div>
                    </div>
                </form>

                <!-- Topbar Navbar -->
                <ul class="navbar-nav ml-auto">

                    <!-- Nav Item - Search Dropdown (Visible Only XS) -->
                    <li class="nav-item dropdown no-arrow d-sm-none">
                        <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fas fa-search fa-fw"></i>
                        </a>
                        <!-- Dropdown - Messages -->
                        <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
                             aria-labelledby="searchDropdown">
                            <form class="form-inline mr-auto w-100 navbar-search">
                                <div class="input-group">
                                    <input type="text" class="form-control bg-light border-0 small"
                                           placeholder="Search for..." aria-label="Search"
                                           aria-describedby="basic-addon2">
                                    <div class="input-group-append">
                                        <button class="btn btn-primary" type="button">
                                            <i class="fas fa-search fa-sm"></i>
                                        </button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </li>

                    <!-- Nav Item - Alerts -->
                    <li class="nav-item dropdown no-arrow mx-1">
                        <a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fas fa-bell fa-fw"></i>
                            <!-- Counter - Alerts -->
                            <span class="badge badge-danger badge-counter"></span>
                        </a>
                        <!-- Dropdown - Alerts -->
                        <div id="alert-list"
                             class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
                             aria-labelledby="alertsDropdown">
                            <h6 class="dropdown-header">
                                Requests Center (recent 3 requests)
                            </h6>
                            <a class="dropdown-item text-center small text-black-500" href="/manager/pending-requests">Show
                                All Requests</a>
                        </div>
                    </li>

                    <div class="topbar-divider d-none d-sm-block"></div>

                    <!-- Nav Item - User Information -->
                    <li class="nav-item dropdown no-arrow">
                        <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <span class="mr-2 d-none d-lg-inline text-gray-600 small">Admin</span>
                            <!-- <img class="img-profile rounded-circle" src="https://source.unsplash.com/QAB-WJcbgJk/60x60"> -->
                            <i class="fas fa-user-tie"></i>
                        </a>
                        <!-- Dropdown - User Information -->
                        <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                             aria-labelledby="userDropdown">
                            <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                                <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i> Logout
                            </a>
                        </div>
                    </li>

                </ul>

            </nav>
            <!-- End of Topbar -->

            <#--            NASZ SORDEK-->


            <#--            KONIEC-->
            <!-- Template injection -->
            <#if contentTemplate??>
                <#include "/${contentTemplate}">
            </#if>

            <!-- Footer -->
            <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Copyright &copy; HIGH-FIVE 2020</span>
                    </div>
                </div>
            </footer>
            <!-- End of Footer -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
         aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="/login.html">Logout</a>
                </div>
            </div>
        </div>
    </div>

    <!-- Operation INFO Modal-->
    <div class="modal fade" id="infoModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
         aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="modalh1id">Operation Info!</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div id="modal-info-body" class="modal-body"><img src="/img/ajax-loader.gif" alt="loading spinner"/>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" id="modal-button" type="button" data-dismiss="modal">Ok</button>
                    <#--                    <a class="btn btn-primary" href="/login.html">Logout</a>-->
                </div>
            </div>
        </div>
    </div>

    <!-- Operation INFO Modal-->
    <div class="modal fade" id="calendarModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
         aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="modalh1id">Operation Info!</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div id="modal-info-body" class="modal-body">
                    <div id="calendar"></div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" id="modal-button" type="button" data-dismiss="modal">Ok</button>
                    <#--                    <a class="btn btn-primary" href="/login.html">Logout</a>-->
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="/vendor/jquery/jquery.min.js"></script>
    <script src="/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="/js/sb-admin-2.min.js"></script>

    <script src="/js/bootstrap-datepicker.min.js"></script>


    <script>
        $('.form-control-date').datepicker({
            clearBtn: false,
            format: "yyyy-mm-dd"
        });

        $("#alertsDropdown").click(function () {
            $('#alertsDropdown span').text('');
            sessionStorage.clicked = 1;
            //return false;
        });

        $('#alertsDropdown').on('hidden.bs.dropdown', function () {
            $('.pending-req').remove();
        });

        var source = new EventSource("/admin/notify");
        lastData = null;
        dataSize = 0;
        var dates = [];
        displayed = 0;
        source.addEventListener('message', function (e) {
            var data = JSON.parse(e.data);

            $.each(data, function (i, item) {

                dateTime = Date.parse(item.iso_date_of_request);
                if (sessionStorage.maxdateStored >= dateTime && sessionStorage.clicked == 1) {
                    sessionStorage.displayed = 0;
                    return;
                }
                sessionStorage.maxdateStored = dateTime;
                dates.push(dateTime);

                if (sessionStorage.displayed == 0) {
                    $("#new-request").delay(1000).slideDown("slow", function () {
                        sessionStorage.displayed = 1;
                    });
                    $("#new-request").delay(3000).slideUp("slow");
                }
                sessionStorage.clicked = 0;
                $('.pending-req').remove();
                $('#alert-list').append('<a class="dropdown-item d-flex align-items-center pending-req" href="/manager/pending-requests"><div class="mr-3">'
                    + '<div class="icon-circle bg-warning"><i class="fas fa-exclamation-triangle text-white"></i></div>'
                    + '</div><div><div class="small text-black-500">' + item.iso_date_of_request + '</div>'
                    + item.first_name + ' ' + item.surname + ' requested for vacation'
                    + '</div></a>');
                $('#alertsDropdown span').text(data.length);
            });

        }, false);

        if (typeof (Storage) !== "undefined") {
            if (!sessionStorage.maxdateStored) {
                sessionStorage.maxdateStored = null;
                sessionStorage.clicked = 0;
                sessionStorage.displayed = 0;
            }
        } else {
            $('#new-request').html("Sorry, your browser does not support web storage...");
        }

    </script>

    <script src="/js/bootstrap-year-calendar_v2.js"></script>
    <script>
        $(function () {

            $('#calendar').calendar({
                enableContextMenu: true,
                enableRangeSelection: false,
                weekStart: 1,
                mouseOnDay: function (e) {
                    if (e.events.length > 0) {
                        var content = '';

                        for (var i in e.events) {
                            content += '<div class="event-tooltip-content">'
                                + '<div class="event-name" style="color:' + e.events[i].color + '">' + e.events[i].name + '</div>'
                                + '<div class="event-location">' + e.events[i].location + '</div>'
                                + '<div class="event-location">' + e.events[i].type + '</div>'
                                + '</div>';
                        }

                        $(e.element).popover({
                            trigger: 'manual',
                            container: 'body',
                            html: true,
                            content: content
                        });

                        $(e.element).popover('show');
                    }
                },
                mouseOutDay: function (e) {
                    if (e.events.length > 0) {
                        $(e.element).popover('hide');
                    }
                },
                dayContextMenu: function (e) {
                    $(e.element).popover('hide');
                },
                dataSource: null
            });

            var dataS = [];
            $.ajax({
                type: "GET",
                url: "/api/holiday/list",
                enctype: 'application/json;charset=UTF-8',
                dataType: 'json',
                contentType: 'application/json;charset=UTF-8'
            })
                .done(
                    function (data) {
                        $.each(data, function (i, item) {
                            dataS.push({
                                id: item.id,
                                name: item.name,
                                location: item.description,
                                type: item.type,
                                typeStyle: 'box',
                                startDate: new Date(item.year, item.month - 1, item.day),
                                endDate: new Date(item.year, item.month - 1, item.day)
                            });
                            //$('#alert-list').show();
                        });
                        $('#calendar').data('calendar').setDataSource(dataS);
                        //  $('#calendarModal').modal('show');
                    })
                .fail(
                    function () {
                        $('#modal-info-body').html("Ups... Operation failed!!!");
                        $('#infoModal').modal('show');
                    });

        });
    </script>

    <!-- Page level plugins -->
    <#if pluginJsTemplate??>
        <#include "/${pluginJsTemplate}">
    </#if>
</body>

</html>
