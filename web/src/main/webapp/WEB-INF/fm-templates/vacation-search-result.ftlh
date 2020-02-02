<!-- Begin Page Content -->
<div class="container-fluid">

  <!-- Page Heading -->
  <!-- DataTales Example -->
  <div class="card shadow mb-4">
    <div class="card-header py-3">
      <h6 class="m-0 font-weight-bold text-primary">Result of search vacation ${searchType!}</h6>
      <a href="#" id="modal-calendar-search-button" class="btn btn-success btn-icon-split">
                    <span class="icon text-white-50">
                       <i class="fas fa-calendar fa-fw"></i>
                    </span>
        <span class="text">Show results on calendar</span>
      </a>
    </div>
    <div class="card-body">
      <#if validInputs>
      <div class="table-responsive">
        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
          <thead>
          <tr>
            <th>Employee</th>
            <th>Date from</th>
            <th>Date to</th>
          </tr>
          </thead>
          <tfoot>
          <tr>
            <th>Employee</th>
            <th>Date from</th>
            <th>Date to</th>
          </tr>
          </tfoot>
          <tbody>
          <#list vacations as vacation>
            <tr>
              <td>${vacation.firstName} ${vacation.surname}</td>
              <td>${vacation.vacationFrom}</td>
              <td>${vacation.vacationTo}</td>
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
<!-- Operation INFO Modal-->
<div class="modal fade" id="calendarModal-search" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="modalh1id">Operation Info!</h5>
        <button class="close" type="button" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">×</span>
        </button>
      </div>
      <div id="modal-info-body" class="modal-body">
        <div id="calendar-modal-search"></div>
      </div>
      <div class="modal-footer">
        <button class="btn btn-secondary" id="modal-button" type="button" data-dismiss="modal">Ok</button>
      </div>
    </div>
  </div>
</div>
<!-- End of Main Content -->
