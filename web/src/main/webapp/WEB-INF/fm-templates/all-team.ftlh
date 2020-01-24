<!-- Begin Page Content -->
<div class="container-fluid">

  <!-- Page Heading -->
  <!-- DataTales Example -->
  <div class="card shadow mb-4">
    <div class="card-header py-3">
      <h6 class="m-0 font-weight-bold text-primary">All teams list</h6>
    </div>
    <div class="card-body">
      <div class="table-responsive">
        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
          <thead>
          <tr>
            <th>Team ID</th>
            <th>Name</th>
          </tr>
          </thead>
          <tfoot>
          <tr>
            <th>Team ID</th>
            <th>Name</th>
           /tr>
          </tfoot>
          <tbody>
          <#list teams as team>
            <tr>
              <td>${team.team-id!}</td>
              <td>${team.name!}</td>
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