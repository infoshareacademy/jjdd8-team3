<!-- Begin Page Content -->
<div class="container-fluid">

  <!-- Outer Row -->
  <div class="row justify-content-center">

    <div class="col-xl-10 col-lg-12 col-md-9">

      <div class="card o-hidden border-0 shadow-lg my-5">
        <div class="card-body p-0">
          <!-- Nested Row within Card Body -->
          <div class="row">
            <div class="col-lg-6 d-none d-lg-block">

            <div class="text-center">
              <img class="img-fluid px-3 px-sm-4 mt-3 mb-4" style="width: 25rem;"
                   src="/img/undraw_uploading_go67.svg" alt="women on vacation">
            </div>
            </div>
            <div class="col-lg-6">
              <div class="p-5">
                <div class="text-center">
                  <h1 class="h4 text-gray-900 mb-4"><#if action == "edit">Edit<#else>Add</#if> holiday!</h1>
                </div>
                <form id="add-holiday-form" name="add-holiday-form" class="user" method="POST">
                  <div class="form-group">
                    <input type="text" class="form-control form-control-user" name="holiday-name"
                           id="holiday-name" placeholder="name of holiday" value="<#if action == "edit">${holiday.name!}</#if>" required>
                  </div>
                  <div class="form-group">
                    <textarea class="form-control" name="holiday-description"
                              id="holiday-description" rows="3"><#if action=="edit">${holiday.description!}</#if></textarea>
                  </div>
                  <div class="form-group">
                    <label for="exampleFormControlSelect2">Example multiple select</label>
                    <select class="form-control" id="holiday-type" name="holiday-type">
                      <#list holidayTypes as holidayType>
                      <option value="${holidayType.getType()!}">${holidayType.getType()!}</option>
                      </#list>
                    </select>
                  </div>
                  <div class="form-group">
                    <input type="text" class="data-picker form-control form-control-user" id="holiday-date"
                           data-provide="holiday-date" name="holiday-date" placeholder="2000-01-01" value="<#if action=="edit">${holiday.date!}</#if>" required>
                  </div>
<#--                  <div class="input-group date" data-provide="datepicker">-->
<#--                    <input type="text" class="form-control">-->
<#--                    <div class="input-group-addon">-->
<#--                      <span class="glyphicon glyphicon-th"></span>-->
<#--                    </div>-->
<#--                  </div>-->
                 <button type="submit" class="btn btn-primary"><span class="icon text-white-50">
                      <i class="fas fa-calendar-plus"></i>
                    </span>
                   <span class="text">Add</span></button>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>

    </div>

  </div>

</div>
<!-- /.container-fluid -->

</div>
<!-- End of Main Content -->