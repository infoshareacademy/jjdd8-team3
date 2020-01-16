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
                                <form class="user">
                                    <label for="exampleInputHolidayName">Please type holiday name here:</label>
                                    <div class="form-group">
                                        <input type="holiday_name" class="form-control form-control-user"
                                               id="exampleInputHolidayName" placeholder="Please enter a minimum of 3 letters...">
                                        <div class="text-center">
                                            <strong>${inputSearch}</strong>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <a href="holiday-search.html" class="btn btn-primary btn-user btn-block">
                                            Search
                                        </a>
                                    </div>
                                </form>

                            </div>
                        </div>
                        <div class="col-lg-3">
                            <div class="p-5">
                                <div class="text-center">
                                    <h1 class="h4 text-gray-900 mb-4">Search by Date</h1>
                                </div>
                                <form class="user">
                                    <label for="exampleInputHolidayDateFrom">from</label>
                                    <div class="form-group">
                                        <input type="date" name="date" class="form-control form-control-user"
                                               id="exampleInputHolidayDateFrom" min="2020-01-01" max="2050-12-31">
                                    </div>
                                    <label for="exampleInputHolidayDateTo">to</label>
                                    <div class="form-group">
                                        <input type="date" name="date" class="form-control form-control-user"
                                               id="exampleInputHolidayDateTo" min="2020-01-01" max="2050-12-31">
                                    </div>
                                    <div class="form-group">
                                        <a href="holiday-search.html" class="btn btn-primary btn-user btn-block">
                                            Search
                                        </a>
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