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
                     src="/img/undraw_team_spirit_hrr4.svg" alt="women on vacation">
              </div>
            </div>
            <div class="col-lg-6">
              <div class="p-5">
                <div class="text-center">
                  <h1 class="h4 text-gray-900 mb-4"><#if action == "edit">Edit<#else>Add</#if> team!</h1>
                </div>
                <form id="add-team-form" name="add-team-form" class="user" method="POST">
                  <#if action == "edit"><input id="team-id" name="team-id" type="hidden" value="${team.id!}"></#if>
                  <div class="form-group">
                    <label for="team-name">Name od Team</label>
                    <input type="text" class="form-control form-control-user" name="team-name"
                           id="team-name" placeholder="name of team" value="<#if action == "edit">${team.teamName!}</#if>" required>
                  </div>
                  <button type="submit" class="btn btn-primary"><span class="icon text-white-50">
                      <i class="fas fa-calendar-plus"></i>
                    </span>
                    <span class="text"><#if action == "edit">Change<#else>Add</#if> team!</span></button>
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