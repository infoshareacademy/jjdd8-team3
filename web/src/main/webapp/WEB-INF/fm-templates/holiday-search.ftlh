<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Holiday search</h1>
        <!-- <a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i class="fas fa-download fa-sm text-white-50"></i> Generate Report</a> -->
    </div>

    <div class="row justify-content-center">

        <div class="col-xl-10 col-lg-12 col-md-9">

            <div class="card o-hidden border-0 shadow-lg my-5">
                <div class="card-body p-0">
                    <!-- Nested Row within Card Body -->
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="p-5">
                                <div class="text-center">
                                    <h1 class="h4 text-gray-900 mb-4">Search by Name</h1>
                                </div>
                                <form class="user" action="search-by-name" method="post">
                                    <label for="exampleInputHolidayName">Please type holiday name here:</label>
                                    <div class="form-group">
                                        <input type="text" title="Please insert min 3 char." name="search_by_name" class="form-control form-control-user" pattern=".{3,}"
                                               id="holiday-name" placeholder="Please enter a minimum of 3 letters..." autocomplete="off">
<#--                                        <div id="result-div" class="list-group" style="width:60%;position:absolute;margin-top:2px;margin-left:10%;height:300px;z-index: 99 !important;">-->
<#--                                        </div>-->
                                    </div>
                                    <div class="form-group">
                                     <!--    <a href="holiday-search.html" class="btn btn-primary btn-user btn-block">  -->
                                      <!--       Search  -->
                                      <!--   </a> -->
                                            <button type="submit" class="btn btn-primary">Search</button>
                                    </div>
                                </form>
                                <label for="exampleInputHolidayName">Quick live search:</label>
                                <div class="form-group">
                                    <input type="text" title="Please insert min 3 char." name="holiday-quick" class="form-control form-control-user" pattern=".{3,}"
                                           id="holiday-quick" placeholder="Please enter a minimum of 3 letters..." autocomplete="off">
                                    <div id="result-div" class="list-group" style="margin-top:2px;margin-left:0;z-index: 1000 !important;">
                                    </div>
                                </div>

                            </div>
                        </div>
                        <div class="col-lg-3">
                            <div class="p-5">
                                <div class="text-center">
                                    <h1 class="h4 text-gray-900 mb-4">Search by Date</h1>
                                </div>
                                <form class="user" action="search-by-date" method="post">
                                    <label for="exampleInputHolidayDateFrom">from</label>
                                    <div class="form-group">
                                        <input type="text" class="form-control form-control-user form-control-date" title ="please insert correct date format YYYY-MM-DD" pattern="(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))"
                                               name="date-from" id="date-from" placeholder="2020-01-01" required>
                                    </div>
                                    <label for="exampleInputHolidayDateTo">to</label>
                                    <div class="form-group">
                                        <input type="text" class="form-control form-control-user form-control-date" title = "please insert correct date format YYYY-MM-DD" pattern="(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))"
                                               name="date-to" id="date-to" placeholder="2020-01-01" required>
                                    </div>
                                    <div class="form-group">
                                    <!--     <a href="holiday-search.html" class="btn btn-primary btn-user btn-block"> -->
                                     <!--        Search -->
                                    <!--     </a> -->
                                        <button type="submit" class="btn btn-primary">Search</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <div class="col-lg-3 d-none d-lg-block">
                            <img class="img-fluid px-3 px-sm-4 mt-3 mb-4" style="width: 25rem;"
                                 src="/img/undraw_calendar_dutt.svg" alt="calendar">
                        </div>
                    </div>
                </div>
            </div>

        </div>

    </div>

</div>
<!-- /.container-fluid -->