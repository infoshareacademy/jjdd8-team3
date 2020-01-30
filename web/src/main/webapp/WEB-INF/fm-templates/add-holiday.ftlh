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
                   src="/img/undraw_fill_forms_yltj.svg" alt="women on vacation">
            </div>
            </div>
            <div class="col-lg-6">
              <div class="p-5">
                <div class="text-center">
                  <h1 class="h4 text-gray-900 mb-4"><#if action == "edit">Edit<#else>Add</#if> holiday!</h1>
                </div>
                <form id="add-holiday-form" name="add-holiday-form" class="user" method="POST">
                  <#if action == "edit"><input id="holiday-id" name="holiday-id" type="hidden" value="${holiday.id!}"></#if>
                  <div class="form-group">
                    <label for="holiday-name">Name od Holiday</label>
                    <input type="text" class="form-control form-control-user" name="holiday-name"
                           id="holiday-name" placeholder="name of holiday" value="<#if action == "edit">${holiday.name!}</#if>" required>
                  </div>
                  <div class="form-group">
                    <label for="holiday-description">Description</label>
                    <textarea class="form-control" name="holiday-description"
                              id="holiday-description" rows="3"><#if action=="edit">${holiday.description!}</#if></textarea>
                  </div>
<#--                  <div class="form-group">-->
<#--                    <label for="holiday-type">Holiday type</label>-->
<#--                    <select class="form-control" id="holiday-type" name="holiday-type">-->
<#--                      <#list holidayTypes as holidayType>-->
<#--                      <option value="${holidayType.getType()!}">${holidayType.getType()!}</option>-->
<#--                      </#list>-->
<#--                    </select>-->
<#--                  </div>-->

                  <div class="form-group">
                    <label for="holiday-type">Holiday type</label>
                    <select class="form-control" id="holiday-type" name="holiday-type">
                      <#if action=="edit"><option value="${holiday.holidayType.getType()}"
                                                  selected>${holiday.holidayType.getType()}</option></#if>
                      <#list holidayTypes as holidayType>
                        <option value="${holidayType.getType()!}">${holidayType.getType()!}</option>
                      </#list>
                    </select>
                  </div>

                  <div class="form-group">
                    <label for="holiday-date">Holiday date</label>
                    <input type="text" class="form-control form-control-user form-control-date" title = "please insert correct date format YYYY-MM-DD" pattern="(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))"
                           name="holiday-date" id="holiday-date" placeholder="2020-01-01" value="<#if action == "edit">${holiday.date!}</#if>" required>
                  </div>
                 <button type="submit" class="btn btn-primary"><span class="icon text-white-50">
                      <i class="fas fa-calendar-plus"></i>
                    </span>
                   <span class="text"><#if action == "edit">Change<#else>Add</#if> holiday!</span></button>
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