<!-- Begin Page Content -->
<div class="container-fluid">

  <!-- Page Heading -->
  <!-- DataTales Example -->
  <div class="card shadow mb-4">
    <div class="card-header py-3">
      <h6 class="m-0 font-weight-bold text-primary">All pending requests</h6>
    </div>
    <div class="card-body">
      <div class="table-responsive">
        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
          <thead>
          <tr>
            <th>Request ID</th>
            <th>First name</th>
            <th>Surname</th>
            <th>Position</th>
            <th>Start date</th>
            <th>End date</th>
            <th>Vacation type</th>
            <th>Approve request</th>
            <th>Reject request</th>
          </tr>
          </thead>
          <tfoot>
          <tr>
            <th>EmployeeID</th>
            <th>First name</th>
            <th>Surname</th>
            <th>Position</th>
            <th>Start date</th>
            <th>End date</th>
            <th>Vacation type</th>
            <th>Approve request</th>
            <th>Reject request</th>
          </tr>
          </tfoot>
          <tbody>
          <#list vacations as vacation>
            <tr>
              <td>${vacation.id!}</td>
              <td>${vacation.firstName!}</td>
              <td>${vacation.surname!}</td>
              <td>${vacation.position!}</td>
              <td>${vacation.vacationFrom!}</td>
              <td>${vacation.vacationTo!}</td>
              <td>${vacation.vacationType!}</td>
              <td>
                <form class="user" action="approve-request" method="post">
                <button type="submit" class="btn btn-primary" name="vacation_id" value="${vacation.id}">Approve request</button>
                </form>
              </td>
              <td>
                <form class="user" action="reject-request" method="post">
                  <button type="submit" class="btn btn-primary" name="vacation_id" value="${vacation.id}">Reject request</button>
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
