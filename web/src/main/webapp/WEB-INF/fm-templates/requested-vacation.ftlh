<!-- Begin Page Content -->
<div class="container-fluid">

  <!-- Page Heading -->
  <!-- DataTales Example -->
  <div class="card shadow mb-4">
    <div class="card-header py-3">
      <h6 class="m-0 font-weight-bold text-primary">List of your vacation</h6>
    </div>
    <div class="card-body">
      <div class="table-responsive">
        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
          <thead>
          <tr>
            <th>Start date</th>
            <th>End date</th>
            <th>Vacation type</th>
            <th>Withdraw</th>
          </tr>
          </thead>
          <tfoot>
          <tr>
            <th>Start date</th>
            <th>End date</th>
            <th>Vacation type</th>
            <th>Withdraw</th>
          </tr>
          </tfoot>
          <tbody>
          <#list vacations as vacation>
            <tr>
              <td>${vacation.vacationFrom!}</td>
              <td>${vacation.vacationTo!}</td>
              <td>${vacation.vacationType!}</td>
              <td>
                <form class="user" action="withdraw-vacation" method="post">
                  <button type="submit" class="btn btn-primary" name="vacation_id" value="${vacation.id}">Withdraw
                  </button>
                </form>
            </tr>
          </#list>
          </tbody>
        </table>
      </div>
    </div>
  </div>

</div>
<!-- /.container-fluid -->

</div>
<!-- End of Main Content -->
