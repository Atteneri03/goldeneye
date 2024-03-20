<!DOCTYPE html>  
<html lang="en" xmlns:th="http://www.thymeleaf.org">
    <head>
        <meta charset="UTF-8">
        <title>Goldeneye</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body>
        <div class="container mt-5">
            <div class="row">
                <div class="col-md-6 offset-md-3 shadow p-4 text-center">
                    <div class="mb-3">
                        <h3>Here is your email</h3>
                        <h6>${email}</h6>
                    </div>

                    <div class="mb-3">
                           <a href="/" class="btn btn-primary btn-back">Regenerate</a>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
