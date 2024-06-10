// Germany Appointment 


// ==UserScript==
// @name         GERMANY APPOINTMENT
// @namespace    http://tampermonkey.net/
// @version      0.1
// @description  try to take over the world!
// @author       You
// @match        https://service2.diplo.de/rktermin/extern/appointment_showForm.do?locationCode=isla&realmId=108&categoryId=1600
// @icon         https://www.google.com/s2/favicons?sz=64&domain=diplo.de
// @grant        none
// ==/UserScript==

(function() {
    'use strict';

    // Function to check for new orders and display an alert.
    function checkForKeyword() {
        // Get the root element.
        // Get the select element by its ID
    const selectElement = document.getElementById('appointment_newAppointmentForm_fields_3__content');

    if (selectElement) {
        // Initialize an empty array to store the values
        const selectValues = [];

        // Loop through the options and push their values into the array
        for (let i = 0; i < selectElement.options.length; i++) {
            const option = selectElement.options[i];
                const optionValue = option.value.toLowerCase(); // Convert to lowercase for case-insensitive comparison

                if (optionValue.includes("2024") || optionValue.includes("summer")) {
                     var xhr = new XMLHttpRequest();
                    xhr.open("GET", "http://localhost:8080/api/helloG", true);
                    xhr.send();
                }
        }

        console.log(selectValues);
     }
    }

    // Function to refresh the page every 10 minutes.
    function refreshPage() {
        setTimeout(() => {
            location.reload();
        }, (1 * 60 * 1000)/12); // Refresh every 1 minutes (10 * 60 * 1000 milliseconds).
    }
    // Call the refreshPage function to refresh the page periodically.
    refreshPage();
    // Wait for 10 seconds before checking for new orders.
    setTimeout(() => {
        checkForNewOrders();
    }, 10000); // 10 seconds delay
    // Call the checkForNewOrders function to check for new orders.
    checkForKeyword();

})();