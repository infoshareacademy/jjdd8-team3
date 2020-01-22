<!-- Begin Page Content -->
<div class="container-fluid">

  <!-- Page Heading -->
  <a href="/admin/add-holiday" class="btn btn-success btn-icon-split">
                    <span class="icon text-white-50">
                      <i class="fas fa-check"></i>
                    </span>
    <span class="text">Add custom holiday</span>
  </a>
  <!-- DataTales Example -->
  <div class="card shadow mb-4">
    <div class="card-header py-3">
      <h6 class="m-0 font-weight-bold text-primary">All holidays list</h6>
    </div>
    <div class="card-body">
      <div class="table-responsive">
        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
          <thead>
          <tr>
            <th>Action</th>
            <th>Name</th>
            <th>Description</th>
            <th>Date</th>
            <th>Type</th>
          </tr>
          </thead>
          <tfoot>
          <tr>
            <th>Action</th>
            <th>Name</th>
            <th>Description</th>
            <th>Date</th>
            <th>Type</th>
          </tr>
          </tfoot>
          <tbody>
          <#list holidays as holiday>
            <tr>
              <td><a href="/admin/add-holiday?action=edit&get=${holiday.id!}" class="btn btn-info btn-circle btn-sm">
                  <i class="fas fa-info-circle"></i>
                </a>
                  <a href="#" class="btn btn-danger btn-circle btn-sm" onclick="deleteHoliday(${holiday.id!})">
                  <i class="fas fa-trash"></i></a>
              </td>
              <td>${holiday.name!}</td>
              <td>${holiday.description!}</td>
              <td>${holiday.date!}</td>
              <td>${holiday.holidayType.getType()!}</td>
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