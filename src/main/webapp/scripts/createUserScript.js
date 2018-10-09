
document.getElementById("createUser").onclick = createUser;
document.getElementById("addPhone").onclick = addPhone;

function addPhone() {
    var emailInput2 = document.getElementById("emailInput2").value;
    var phoneInput = document.getElementById("phoneInput").value;
    
    var myJsonObj = {
        email: emailInput2,
        number: phoneInput
    }
    
    //Post javascript as json
    var settings2 = {
        body: JSON.stringify(myJsonObj), // must match 'Content-Type' header
        headers: {
            'Content-Type': 'application/json',
            'Accept': 'application/json'
        },
        method: 'PUT', // *GET, POST, DELETE, etc.
    }

    console.log(settings2);

    fetch("api/data/addnumber", settings2)
            .then(res => res.json())
            .then(data => document.getElementById("alertContainer").innerHTML =
                        '<div class="alert alert-success alert-dismissible fade show text-center">' +
                        '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                        '<span>User added</span>' +
                        '</div>'
            );
}

function createUser() {

    var firstNameInput = document.getElementById("firstNameInput").value;
    var lastNameInput = document.getElementById("lastNameInput").value;
    var emailInput = document.getElementById("emailInput").value;
    var streetInput = document.getElementById("streetInput").value;
    var cityInput = document.getElementById("cityInput").value;
    var zipcodeInput = document.getElementById("zipcodeInput").value;

    console.log(firstNameInput)

    console.log("Creating user");

    var userInfo = {
        firstName: firstNameInput,
        lastName: lastNameInput,
        email: emailInput,
        street: streetInput,
        city: cityInput,
        zipCode: zipcodeInput
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

    fetch("api/data/createperson", settings)
            .then(res => res.json())
            .then(data => document.getElementById("alertContainer").innerHTML =
                        '<div class="alert alert-success alert-dismissible fade show text-center">' +
                        '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                        '<span>User added</span>' +
                        '</div>'
            );
}
;