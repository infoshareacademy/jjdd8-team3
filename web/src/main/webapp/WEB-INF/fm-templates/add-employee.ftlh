<!-- Begin Page Content -->
<div class="container-fluid">

  <!-- Page Heading -->
  <div class="d-sm-flex align-items-center justify-content-between mb-4">
    <h1 class="h3 mb-0 text-gray-800">Define new team</h1>
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
                  <h1 class="h4 text-gray-900 mb-4">Add new employee</h1>
                </div>
                <form class="user">
                  <div class="form-group">
                    <label for="first_name">first name</label>
                    <input type="text" class="form-control form-control-user"
                           id="first_name" placeholder="Employee's first name">
                  </div>
                  <div class="form-group">
                    <label for="surname">surname</label>
                    <input type="text" class="form-control form-control-user"
                           id="surname" placeholder="Employee's surname">
                  </div>
                  <label for="email">e-mail</label>
                  <div class="form-group">
                    <input type="email" class="form-control form-control-user"
                           id="email" aria-describedby="emailHelp"
                           placeholder="Input e-mail address">
                  </div>
                  <div class="form-group">
                    <label for="position">position</label>
                    <input type="text" class="form-control form-control-user"
                           id="position" placeholder="Enter employee's position">
                  </div>
                  <label for="team_id">team</label>
                  <div class="dropdown no-arrow mb-2 show" id="team_id">
                    <button class="btn btn-dark dropdown" type="button" id="teamsToChoose"
                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                      Select team
                    </button>
                    <div class="dropdown-menu show" aria-labelledby="teamsToChoose" x-placement="bottom-start"
                         style="position: absolute; will-change: transform; top: 0px; left: 0px; transform: translate3d(0px, 38px, 0px);">
                      <a class="dropdown-item" href="#">Action</a>
                      <a class="dropdown-item" href="#">Another action</a>
                      <a class="dropdown-item" href="#">Something else here</a>
                    </div>
                    <div class="form-group">
                      <label for="hire_date">hire date</label>
                      <input type="date" class="form-control form-control-user"
                             id="hire_date" placeholder="Choose hire date from calendar">
                    </div>
                    <div class="form-group">
                      <label for="holiday_entitlement">holiday entitlement</label>
                      <input type="number" class="form-control form-control-user"
                             id="holiday_entitlement" placeholder="Input employee's entitlement">
                    </div>
                    <div class="form-group">
                      <label for="additional_entitlement">parental care entitlement</label>
                      <input type="number" class="form-control form-control-user"
                             id="additional_entitlement"
                             placeholder="Put number from 0 to 2 following employee's statement">
                    </div>
                  </div>
                  <hr>
                  <a href="index.html" class="btn btn-primary btn-user btn-block">
                    Save
                  </a>
                </form>

              </div>
            </div>
            <!--                             TODO-->
            <!--                             Fit image size and content !!! -->
            <div class="col-lg-6 d-none d-lg-block bg-login-image"></div>
          </div>
        </div>
      </div>

    </div>

  </div>
</div>
<!-- /.container-fluid -->

</div>
<!-- End of Main Content -->
</div>
<!-- End of Content Wrapper -->

<!-- Bootstrap core JavaScript-->
<!--  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>-->
<script src="js/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<!--  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>-->
<script src="js/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="js/sb-admin-2.min.js"></script>
