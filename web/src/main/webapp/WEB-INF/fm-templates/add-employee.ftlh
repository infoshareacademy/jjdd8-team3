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
                     src="/img/undraw_hire_te5y.svg" alt="women on vacation">
              </div>
            </div>
            <div class="col-lg-6">
              <div class="p-5">
                <div class="text-center">
                  <h1 class="h4 text-gray-900 mb-4"><#if action == "edit">Edit<#else>Add</#if> employee!</h1>
                </div>
                <form id="add-employee-form" name="add-employee-form" class="user" method="POST">
                  <#if action == "edit"><input id="employee-id" name="employee-id"
                                               type="hidden" value="${employee.id!}"></#if>
                  <div class="form-group">
                    <label for="first-name">first name</label>
                    <input type="text" class="form-control form-control-user" name="first-name"
                           id="first-name" placeholder="Employee's first name"
                           value="<#if action == "edit">${employee.firstName!}</#if>" required>
                  </div>

                  <div class="form-group">
                    <label for="surname">surname</label>
                    <input type="text" class="form-control form-control-user" name="surname"
                           id="surname" placeholder="Employee's surname"
                           value="<#if action == "edit">${employee.surname!}</#if>" required>
                  </div>

                  <div class="form-group">
                    <label for="email">e-mail</label>
                    <input type="email" class="form-control form-control-user" name="email"
                           id="email" aria-describedby="emailHelp" placeholder="Input e-mail address"
                           value="<#if action == "edit">${employee.email!}</#if>" required>
                  </div>

                  <div class="form-group">
                    <label for="position">position</label>
                    <input type="text" class="form-control form-control-user" name="position"
                           id="position" placeholder="Enter employee's position"
                           value="<#if action == "edit">${employee.position!}</#if>" required>
                  </div>

                  <div class="form-group">
                    <label for="team-name">team</label>
                    <select class="form-control" id="team-name" name="team">
                      <#if action=="edit"><option value="${employee.team.getTeamName()}"
                                                  selected>${employee.team.getTeamName()}</option></#if>
                      <#list teams as team>
                        <option value="${team.getId()!}">${team.getTeamName()!}</option>
                      </#list>
                    </select>
                  </div>

                  <div class="form-group">
                    <label for="hire-date">hire date</label>
                    <input type="text" class="form-control form-control-user form-control-date"
                           title = "please insert correct date format YYYY-MM-DD"
                           pattern="(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))"
                           name="hire-date" id="hire-date" placeholder="2020-01-01"
                           value="<#if action == "edit">${employee.hireDate!}</#if>" required>
                  </div>
                  <div class="form-group">
                    <label for="holiday-entitlement">holiday entitlement</label>
                    <input type="text" class="form-control form-control-user" name="holiday-entitlement"
                           id="holiday-entitlement" placeholder="Input employee's entitlement"
                           value="<#if action =="edit">${employee.holidayEntitlement!}</#if>" required>
                  </div>

                  <div class="form-group">
                    <label for="additional-entitlement">parental care entitlement</label>
                    <input type="text" class="form-control form-control-user" name="additional-entitlement"
                           id="additional-entitlement" placeholder="0, 1 or 2 days following employee's statement"
                           value="<#if action == "edit">${employee.additionalEntitlement!}</#if>">
                  </div>


<#--                  <#if action == "edit">-->
<#--                  <div class="form-group">-->
<#--                    <label for="role">role</label>-->
<#--                    <select class="form-control" id="role" name="role">-->
<#--                      <#list roles as role>-->
<#--                        <option value="${role.getRole()!}">${role.getRole()!}</option>-->
<#--                      </#list>-->
<#--                    </select>-->
<#--                  </div>-->
<#--                  </#if>-->


                  <button type="submit" class="btn btn-primary"><span class="icon text-white-50">
                    <i class="fas fa-calendar-plus"></i>
                  </span>
                    <span class="text"><#if action == "edit">Change<#else>Add</#if> employee!</span></button>
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