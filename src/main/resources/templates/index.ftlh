<!DOCTYPE html>  
<html lang="en">  
    <head>
        <meta charset="UTF-8">
        <title>Goldeneye</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body>
        <div class="container mt-5">
            <h1>Goldeneye</h1>
        </div>
        <div class="container mt-5">
            <div class="row">
                <div class="col-md-6 offset-md-3">
                    <div class="mb-3">
                        <h3>Generate Email</h3>
                    </div>
                    <form action="/email" method="post" class="shadow p-4">                  
                        <div class="mb-3">
                            <label for="firstName">First name</label>
                            <input name="firstName" id="firstName" title="Enter only letters (no numbers, accents or special characters)" type="text" pattern="^[A-Za-z\s]+$" class="form-control" placeholder="First Name" required></input>
                        </div>

                        <div class="mb-3">
                                    <label for="surname">Surname</label>
                                    <input name="surname" id="surname" title="Enter only letters (no numbers, accents or special characters)" type="text" pattern="^[A-Za-z\s]+$" class="form-control" placeholder="Surname" required></input>
                        </div>

                        <div class="mb-3">
                            <label for="office">Office:</label>

                            <select name="office" id="office" onchange="updateDepartment()" class="form-control" required>
                                <option value="" selected disabled>Select an office</option>
                                <option value="milan">Milan</option>
                                <option value="spain">Spain</option>
                                <option value="newYork">New York</option>
                            </select>
                        </div>

                        <div class="mb-3" id="divDepartment" hidden required>
                            <label for="department">Department:</label>
                                <select name="department" id="department" class="form-control">
                                </select>
                
                        </div>

                        <div class="mb-3">
                            <button type="submit" class="btn btn-primary">Send</button>
                        </div>
                        
                    </form>
                </div>
            </div>
        </div>
        
        <script>
            const departments = {milan: ["Design","Business","Advertising"],
                                spain: ["Research&development","Business"],
                                newYork: ["Business","Advertising"]};

            const divDepartment = document.getElementById("divDepartment");
            const department = document.getElementById("department");
            const office = document.getElementById("office");

        function updateDepartment(){
                
                divDepartment.removeAttribute("hidden");

                department.innerHTML = "";
                departments[office.value].forEach(function (dept) {
                    const option = document.createElement('option');
                    option.text = dept;
                    department.add(option);
                });
        }

    </script>
    </body>
</html>
