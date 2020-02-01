<!-- Begin Page Content -->
<div class="container-fluid">

  <!-- Outer Row -->
  <div class="row justify-content-center">

    <div class="col-xl-10 col-lg-12 col-md-9">

      <div class="card o-hidden border-0 shadow-lg my-5">
        <div class="card-body p-0">
          <!-- Nested Row within Card Body -->
          <div class="row">
            <div class="col-lg-6 d-none d-lg-block">

              <div class="text-center">
                <img class="img-fluid px-3 px-sm-4 mt-3 mb-4" style="width: 25rem;"
                     src="/img/undraw_adventure_4hum.svg" alt="vacation">
              </div>
            </div>
            <div class="col-lg-6">
              <div class="p-5">
                <div class="text-center">
                  <h1 class="h4 text-gray-900 mb-4">Search vacation by date</h1>
                </div>
                <form class="user" action="/employee/vacation/search-by-date" method="post">
                  <label for="exampleInputVacationDateFrom">from</label>
                  <div class="form-group">
                    <input type="text" class="form-control form-control-user form-control-date"
                           title="please insert correct date format YYYY-MM-DD"
                           pattern="(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))"
                           name="date-from" id="date-from" placeholder="YYYY-MM-DD" required>
                  </div>
                  <label for="exampleInputHolidayDateTo">to</label>
                  <div class="form-group">
                    <input type="text" class="form-control form-control-user form-control-date"
                           title="please insert correct date format YYYY-MM-DD"
                           pattern="(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))"
                           name="date-to" id="date-to" placeholder="YYYY-MM-DD" required>
                  </div>
                  <div class="form-group">
                    <button type="submit" class="btn btn-primary">Search</button>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>

    </div>

  </div>

</div>
<!-- /.container-fluid -->
