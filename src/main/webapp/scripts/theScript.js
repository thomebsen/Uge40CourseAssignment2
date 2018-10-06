/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


document.getElementById("getAllZip").onclick = getAllZipCodes;
document.getElementById("getAllZipAndCity").onclick = getAllZipAndCity;
document.getElementById("hideZipDiv").onclick = hideZipDiv;
document.getElementById("getUser").onclick = getUserByPhoneNumber;

function hideZipDiv() {
    document.getElementById("allZipCodeDiv").style.display = "none";
}
function getAllZipCodes() {
    document.getElementById("zipDataList").innerHTML = "";     //Remove all items from list by filling it with nothing
    var zipLabel = '<label style="margin-right: 8px;">' + "ZIP: " + '</label>';
    allZipCodeDiv.style.display = "block";
    $.getJSON('http://localhost:8084/Uge40CourseAssignment2/api/data/zipcodes', function (data) {
        var dataObject = data;
        var listItemString = $('#zipListItem').html();
        dataObject.forEach(buildNewList);
        function buildNewList(zips) {
            var listItem = $('<li class="list-group-item">' + listItemString + '</li>');
            var listItemTitle = $('.listZipCode', listItem); //The Zip Code
            listItemTitle.html(zipLabel + zips);
            $('#zipDataList').append(listItem);
        }
    });
}
;


function getAllZipAndCity() {
    document.getElementById("zipDataList").innerHTML = "";     //Remove all items from list by filling it with nothing

    var cityLabel = '<label style="margin-right: 8px;">' + "CITY: " + '</label>';
    var zipLabel = '<label style="margin-right: 8px;">' + "ZIP: " + '</label>';

    allZipCodeDiv.style.display = "block";
    $.getJSON('http://localhost:8084/Uge40CourseAssignment2/api/data/cityinfo', function (data) {
        var dataObject = data;
        var listItemString = $('#zipListItem').html();
        dataObject.forEach(buildNewList);
        function buildNewList(item) {
 
 
             var listItem = $('<li class="list-group-item">' + listItemString + '</li>');

            //The Zip Code
            var listItemTitle = $('.listZipCode', listItem);
            listItemTitle.html(zipLabel + item[1]);

            //The City
            var listItemTitle = $('.listZipCity', listItem);
            listItemTitle.html(cityLabel + item[0]);
            
            $('#zipDataList').append(listItem);
        }
    });
}
;

function getUserByPhoneNumber() {
    var id = document.getElementById("idInput").value;
    fetch("http://localhost:8084/Uge40CourseAssignment2/api/data/person/phone/" + id)
            .then(response => {
                if (!response.ok) {
                    throw response;
                }
                return response.json()
            })
            .then(json => {
                console.log(json)
                document.getElementById("userInfoOutput").innerHTML =
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
}
