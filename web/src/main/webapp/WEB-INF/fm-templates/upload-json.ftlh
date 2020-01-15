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
                  <h1 class="h4 text-gray-900 mb-4">Upload holiday JSON file</h1>
                </div>
                <form name="upload-form" class="user" method="POST" enctype="multipart/form-data">
                  <div class="custom-file mb-3">
                    <input type="file" class="custom-file-input" id="file-name" name="file-name" accept=".json" required>
                    <label class="custom-file-label" for="customFile">Choose file</label>
                  </div>
                 <button type="submit" class="btn btn-primary"><span class="icon text-white-50">
                      <i class="fas fa-upload"></i>
                    </span>
                   <span class="text">Upload</span></button>
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