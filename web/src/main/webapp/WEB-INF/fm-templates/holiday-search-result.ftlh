<!-- Begin Page Content -->
<div class="container-fluid">

  <!-- Page Heading -->
  <!-- DataTales Example -->
  <div class="card shadow mb-4">
    <div class="card-header py-3">
      <h6 class="m-0 font-weight-bold text-primary">Result of search holiday ${searchType!}</h6>
    </div>
    <div class="card-body">
      <#if validInputs>
      <div class="table-responsive">
        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
          <thead>
          <tr>
            <th>Name</th>
            <th>Date</th>
          </tr>
          </thead>
          <tfoot>
          <tr>
            <th>Name</th>
            <th>Date</th>
          </tr>
          </tfoot>
          <tbody>
          <#list holidays as holiday>
            <tr>
              <td>${holiday.name!}</td>
              <td>${holiday.date!}</td>
            </tr>
          </#list>
          </tbody>
        </table>
      </div>
    </div>
    <#else>
      <#if searchType == "by date">
      <p><strong>Wrong dates format from input!</strong></p>
        <#else>
          <p><strong>Please min type 3 characters!</strong></p>
        </#if>
    </#if>
  </div>

</div>
<!-- /.container-fluid -->

</div>
<!-- End of Main Content -->
