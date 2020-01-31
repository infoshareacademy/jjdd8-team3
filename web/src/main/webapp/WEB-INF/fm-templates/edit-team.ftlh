<!-- Begin Page Content -->
<div class="container-fluid">

  <!-- Page Heading -->
  <a href="/manager/add-team" class="btn btn-success btn-icon-split">
                    <span class="icon text-white-50">
                      <i class="fas fa-check"></i>
                    </span>
    <span class="text">Define new team</span>
  </a>
  <!-- DataTales Example -->
  <div class="card shadow mb-4">
    <div class="card-header py-3">
      <h6 class="m-0 font-weight-bold text-primary">All our teams</h6>
    </div>
    <div class="card-body">
      <div class="table-responsive">
        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
          <thead>
          <tr>
            <th>Action</th>
            <th>Name</th>
          </tr>
          </thead>
          <tfoot>
          <tr>
            <th>Action</th>
            <th>Name</th>
          </tr>
          </tfoot>
          <tbody>
          <#list teams as team>
            <tr>
              <td><a href="/manager/add-team?action=edit&get=${team.id!}" class="btn btn-info btn-circle btn-sm">
                  <i class="fas fa-info-circle"></i>
                </a>
                  <a href="#" class="btn btn-danger btn-circle btn-sm" onclick="deleteTeam(${team.id!})">
                  <i class="fas fa-trash"></i></a>
              </td>
              <td>${team.teamName!}</td>
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