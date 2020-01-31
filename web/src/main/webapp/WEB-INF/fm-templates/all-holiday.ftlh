<!-- Begin Page Content -->
<div class="container-fluid">

  <!-- Page Heading -->
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
            <th>No</th>
            <th>Name</th>
            <th>Description</th>
            <th>Date</th>
            <th>Type</th>
          </tr>
          </thead>
          <tfoot>
          <tr>
            <th>No</th>
            <th>Name</th>
            <th>Description</th>
            <th>Date</th>
            <th>Type</th>
          </tr>
          </tfoot>
          <tbody>
          <#list holidays as holiday>
            <tr>
              <td>${holiday.id!}</td>
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