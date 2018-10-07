
document.getElementById("createUser").onclick = createUser;

function createUser() {

    var firstNameInput = document.getElementById("firstNameInput").value;
    var lastNameInput = document.getElementById("lastNameInput").value;
    var emailInput = document.getElementById("emailInput").value;
    
    console.log(firstNameInput)

    console.log("Creating user");

    var userInfo = {
        firstName: firstNameInput,
        lastName: lastNameInput,
        email: emailInput,
    };


    //Post javascript as json
    var settings = {
        body: JSON.stringify(userInfo), // must match 'Content-Type' header
        headers: {
            'Content-Type': 'application/json',
            'Accept': 'application/json'
        },
        method: 'POST', // *GET, PUT, DELETE, etc.
    };

    console.log(settings);

    fetch("http://localhost:8084/Uge40CourseAssignment2/api/data/createperson", settings)
            .then(res => res.json())
            .then(data =>                     document.getElementById("alertContainer").innerHTML =
                            '<div class="alert alert-success alert-dismissible fade show text-center">' +
                            '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                            '<span>User added</span>'+

                    '</div>'
            );
};