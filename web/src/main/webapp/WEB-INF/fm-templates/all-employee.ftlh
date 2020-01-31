<!-- Begin Page Content -->
<div class="container-fluid">

  <!-- Page Heading -->
  <!-- DataTales Example -->
  <div class="card shadow mb-4">
    <div class="card-header py-3">
      <h6 class="m-0 font-weight-bold text-primary">All employees list</h6>
    </div>
    <div class="card-body">
      <div class="table-responsive">
        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
          <thead>
          <tr>
            <th>Action</th>
            <th>Fist Name</th>
            <th>Surname</th>
            <th>Position</th>
            <th>Role</th>
            <th>Team</th>
          </tr>
          </thead>
          <tfoot>
          <tr>
            <th>Action</th>
            <th>Fist Name</th>
            <th>Surname</th>
            <th>Position</th>
            <th>Role</th>
            <th>Team</th>
          </tr>
          </tfoot>
          <tbody>
          <#list employees as employee>
            <tr>
              <td>${employee.first_name!}</td>
              <td>${employee.surname!}</td>
              <td>${employee.position!}</td>
              <td>${employee.role.getRole!}</td>
              <td>${employee.team.getTeamName()!}</td>
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