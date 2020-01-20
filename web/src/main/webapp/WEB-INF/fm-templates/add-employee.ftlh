<!-- Begin Page Content -->
<div class="container-fluid">
  <!-- Page Heading -->
  <div class="d-sm-flex align-items-center justify-content-between mb-4">
    <h1 class="h3 mb-0 text-gray-800"></h1>
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
                  <h1 class="h4 text-gray-900 mb-4">Add new employee</h1>
                </div>
                <form class="user" action="add-employee" method="post">
                  <div class="form-group">
                    <label for="first-name">first name</label>
                    <input type="text" class="form-control form-control-user"
                           id="first-name" name="first_name" placeholder="Employee's first name">
                  </div>
                  <div class="form-group">
                    <label for="surname">surname</label>
                    <input type="text" class="form-control form-control-user"
                           id="surname" name="surname" placeholder="Employee's surname">
                  </div>
                  <label for="email">e-mail</label>
                  <div class="form-group">
                    <input type="email" class="form-control form-control-user"
                           id="email" name="email" aria-describedby="emailHelp"
                           placeholder="Input e-mail address">
                  </div>
                  <div class="form-group">
                    <label for="position">position</label>
                    <input type="text" class="form-control form-control-user"
                           id="position" name="position" placeholder="Enter employee's position">
                  </div>

                  <div class="form-group">
                    <label for="select-team">Select team</label>
                    <select class="form-control" id="select-team" name="team_name">
                      <#list teams as team>
                          <option value="${team!}">${team.getTeamName()!}</option>
                      </#list>
                    </select>
                  </div>
                  <div class="form-group">
                    <label for="hire-date">hire date</label>
                    <input type="text" class="data-picker form-control form-control-user" id="hire-date"
                           data-provide="hire-date" name="hire_date" placeholder="2000-01-01">
                  </div>
                  <div class="form-group">
                    <label for="holiday_entitlement">holiday entitlement</label>
                    <input type="number" class="form-control form-control-user"
                           id="holiday_entitlement" name="holiday_entitlement" placeholder="Input employee's entitlement">
                  </div>
                  <div class="form-group">
                    <label for="additional_entitlement">parental care entitlement</label>
                    <input type="number" class="form-control form-control-user"
                           id="additional_entitlement" name="additional_entitlement" placeholder="Put number from 0 to 2 following employee's statement">
                  </div>
                  <div>
                    <button type="submit" class="btn btn-primary">Save</button>
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
