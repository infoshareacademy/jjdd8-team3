<!-- Begin Page Content -->
<div class="container-fluid">
  <!-- Page Heading -->
  <div class="d-sm-flex align-items-center justify-content-between mb-4">
    <h1 class="h3 mb-0 text-gray-800">Define new team</h1>
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
                  <h1 class="h4 text-gray-900 mb-4">Request vacation</h1>
                </div>
                <form class="user" action="add-vacation" method="post">
                  <div class="form-group">
                    <label for="employee_id">Employee ID</label>
                    <input type="number" class="form-control form-control-user" id="employee_id"
                           placeholder="Employee ID" required="" name="employee_id">
                  </div>
                  <div class="form-group">
                    <label for="date_from">Date from</label>
                    <input type="date" class="form-control form-control-user" id="date_from"
                           name="date_from" required="" placeholder="">
                  </div>
                  <div class="form-group">
                    <label for="date_to">Date to</label>
                    <input type="date" class="form-control form-control-user"
                           name="date_to" required="" placeholder="">
                  </div>
              <div>
                  <label for="vacation_type">Vacation type</label>
                  <select class="form-control" id="vacation_type" name="vacation_type">
                    <option name="vacation" value="vacation">Vacation leave</option>
                    <option name="parental" value="parental">Parental leave</option>
                    <option name="on_demand" value="on_demand">On demand</option>
                  </select>
              </div>
              <hr>
              <div>
                <button type="submit" class="btn btn-primary">Submit request</button>
              </div>
              </form>
            </div>
          </div>
          <div class="col-lg-6 d-none d-lg-block">
            <div class="card-body">
              <div class="text-center">
                <img class="img-fluid px-3 px-sm-4 mt-3 mb-4" style="width: 25rem;"
                     src="/img/undraw_journey_lwlj.svg" alt="add-vacation">
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- /.container-fluid -->
</div>
<!-- End of Main Content -->
