<!-- Begin Page Content -->
<div class="container-fluid">

  <!-- Page Heading -->
  <!-- DataTales Example -->
  <div class="card shadow mb-4">
    <div class="card-header py-3">
      <h6 class="m-0 font-weight-bold text-primary">List of pending requests</h6>
    </div>
    <div class="card-body">
      <div class="table-responsive">
        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
          <thead>
          <tr>
            <th>First name</th>
            <th>Surname</th>
            <th>Position</th>
            <th>Start date</th>
            <th>End date</th>
            <th>Vacation type</th>
            <th>Approve</th>
            <th>Reject</th>
          </tr>
          </thead>
          <tfoot>
          <tr>
            <th>First name</th>
            <th>Surname</th>
            <th>Position</th>
            <th>Start date</th>
            <th>End date</th>
            <th>Vacation type</th>
            <th>Approve</th>
            <th>Reject</th>
          </tr>
          </tfoot>
          <tbody>
          <#list vacations as vacation>
            <tr>
              <td>${vacation.firstName!}</td>
              <td>${vacation.surname!}</td>
              <td>${vacation.position!}</td>
              <td>${vacation.vacationFrom!}</td>
              <td>${vacation.vacationTo!}</td>
              <td>${vacation.vacationType!}</td>
              <form class="user" action="approve-request" method="post">
                <button type="submit" class="btn btn-primary" name="vacation_id" value="${vacation.id}">Approve
                </button>
              </form>
              </td>
              <td>
                <form class="user" action="reject-request" method="post">
                  <button type="submit" class="btn btn-primary" name="vacation_id" value="${vacation.id}">Reject
                  </button>
                </form>
              </td>
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
