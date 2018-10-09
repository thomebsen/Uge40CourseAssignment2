/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    
//add onClick functions to buttons.
document.getElementById("getAllZip").onclick = getAllZipCodes;
document.getElementById("getAllZipAndCity").onclick = getAllZipAndCity;
document.getElementById("hideZipDiv").onclick = hideZipDiv;
document.getElementById("getUserByNumber").onclick = getUserByPhoneNumber;
document.getElementById("getUserByHobby").onclick = getUserWithHobby;
document.getElementById("getUserById").onclick = getUserById;





function hideZipDiv() {
    document.getElementById("allZipCodeDiv").style.display = "none"; //This function hides the zipcode div.
};

function getAllZipCodes() {
    document.getElementById("zipDataList").innerHTML = "";     //Remove all items from list by filling it with nothing
    
    var zipLabel = '<label style="margin-right: 8px;">' + "ZIP: " + '</label>';
    allZipCodeDiv.style.display = "block"; //The zipCodeDiv's display s set to display:block to unhide it.
    
    $.getJSON("api/data/zipcodes", function (data) { //fetch data
        var dataObject = data;
        var listItemString = $('#zipListItem').html(); //get the div "zipListitem
        
        dataObject.forEach(buildNewList); //For each dataObject we have, run the buildNewList() function.        
        
        function buildNewList(zips) {
            var listItem = $('<li class="list-group-item">' + listItemString + '</li>');
            var listItemTitle = $('.listZipCode', listItem); //The Zip Code
            listItemTitle.html(zipLabel + zips);
            
            $('#zipDataList').append(listItem); //add the data into zipDataList div
        }
    });
}
;

//This function is the same as the zip function but this also gives cityInfo.
function getAllZipAndCity() {
    document.getElementById("zipDataList").innerHTML = "";     //Remove all items from list by filling it with nothing
    var cityLabel = '<label style="margin-right: 8px;">' + "CITY: " + '</label>';
    var zipLabel = '<label style="margin-right: 8px;">' + "ZIP: " + '</label>';
    allZipCodeDiv.style.display = "block";
    $.getJSON("api/data/cityinfo", function (data) {
        var dataObject = data;
        var listItemString = $('#zipListItem').html();
        dataObject.forEach(buildNewList); //For each dataObject we have, run the buildNewList() function.
        function buildNewList(item) {
             var listItem = $('<li class="list-group-item">' + listItemString + '</li>');
            //The Zip Code
            var listItemTitle = $('.listZipCode', listItem);
            listItemTitle.html(zipLabel + item[1]); //item[1] is the zip

            //The City
            var listItemTitle = $('.listZipCity', listItem);
            listItemTitle.html(cityLabel + item[0]); //item[0] is the city
            
            $('#zipDataList').append(listItem); //add the data into zipDataList div
        }
    });
}
;

function getUserByPhoneNumber() {
    var phoneNum = document.getElementById("phoneNumInput").value; //get the value of the input field.
    fetch("api/data/person/phone/" + phoneNum) //the fecth
            .then(response => {
                if (!response.ok) {
                    throw response;
                }
                return response.json()
            })
            .then(json => {
                
                //Insert a list of all the users data info the userNumberOutput div.
                document.getElementById("userNumberOutput").innerHTML =
                        '<ul class="list-group" style="margin-bottom: 0px;">'
                        + '<li class="list-group-item">' + "<strong>Firstname: </strong>" + json.firstName + '</li>'
                        + '<li class="list-group-item">' + "<strong>Lastname: </strong>" + json.lastName + '</li>'
                        + '<li class="list-group-item">' + "<strong>Email: </strong>" + json.email + '</li>'
                        + '<li class="list-group-item">' + "<strong>Street: </strong>" + json.street + '</li>'
                        + '<li class="list-group-item">' + "<strong>City: </strong>" + json.city + '</li>'
                        + '<li class="list-group-item">' + "<strong>Zip: </strong>" + json.zipCode + '</li>'
                        + '<ul>'
            })
            .catch(err => { //if we catch an error
                err.text().then(errorMessage => {
                    //var recievedError = JSON.parse(errorMessage);
                    
                    //Insert a bootstrap alertbot into the "alertContainer" div.
                    document.getElementById("alertContainer").innerHTML =
                            '<div class="alert alert-danger alert-dismissible fade show text-center">' +
                            '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                            //recievedError.code + " " + recievedError.message + "<br>" + recievedError.description;
                    '</div>';
                });
            });
};


//This function works the same as the getUserByPhoneNumber function.
function getUserById() {
    var id = document.getElementById("idInput").value;
    fetch("api/data/person/id/" + id)
            .then(response => {
                if (!response.ok) {
                    throw response;
                }
                return response.json()
            })
            .then(json => {
                console.log(json)
                document.getElementById("userIdOutput").innerHTML =
                        '<ul class="list-group" style="margin-bottom: 0px;">'
                        + '<li class="list-group-item">' + "<strong>Firstname: </strong>" + json.firstName + '</li>'
                        + '<li class="list-group-item">' + "<strong>Lastname: </strong>" + json.lastName + '</li>'
                        + '<li class="list-group-item">' + "<strong>Email: </strong>" + json.email + '</li>'
                        + '<li class="list-group-item">' + "<strong>Street: </strong>" + json.street + '</li>'
                        + '<li class="list-group-item">' + "<strong>City: </strong>" + json.city + '</li>'
                        + '<li class="list-group-item">' + "<strong>Zip: </strong>" + json.zipCode + '</li>'
                        + '<ul>'
            })
            .catch(err => {
                err.text().then(errorMessage => {
                    var recievedError = JSON.parse(errorMessage);
                    document.getElementById("alertContainer").innerHTML =
                            '<div class="alert alert-danger alert-dismissible fade show text-center">' +
                            '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                            recievedError.code + " " + recievedError.message + "<br>" + recievedError.description;
                    '</div>';
                });
            });
};


//This function works the same as the getUserByPhoneNumber function.
function getUserWithHobby() {
    var hobby = document.getElementById("hobbyInput").value;
    fetch("api/data/person/hobby/" + hobby)
            .then(response => {
                if (!response.ok) {
                    throw response;
                }
                return response.json()
            })
            .then(json => {
                console.log(json);
                //The data receieved is in an array.
                document.getElementById("userHobbyOutput").innerHTML =
                        '<ul class="list-group" style="margin-bottom: 0px;">'
                        + '<li class="list-group-item">' + "<strong>Firstname: </strong>" + json[0].firstName + '</li>'
                        + '<li class="list-group-item">' + "<strong>Lastname: </strong>" + json[0].lastName + '</li>'
                        + '<li class="list-group-item">' + "<strong>Email: </strong>" + json[0].email + '</li>'
                        + '<li class="list-group-item">' + "<strong>Street: </strong>" + json[0].street + '</li>'
                        + '<li class="list-group-item">' + "<strong>City: </strong>" + json[0].city + '</li>'
                        + '<li class="list-group-item">' + "<strong>Zip: </strong>" + json[0].zipCode + '</li>'
                        + '<ul>'
            })
            .catch(err => {
                err.text().then(errorMessage => {
                    document.getElementById("alertContainer").innerHTML =
                            '<div class="alert alert-danger alert-dismissible fade show text-center">' +
                            '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                            recievedError.code + " " + recievedError.message + "<br>" + recievedError.description;
                    '</div>';
                });
            });
};
