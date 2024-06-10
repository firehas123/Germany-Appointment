// ==UserScript==
// @name         Fiverr Inbox New Order Alert
// @namespace    http://your-namespace.com
// @version      1.0
// @description  Get an alert when a new order arrives in Fiverr's inbox and refresh the page every 10 minutes.
// @match        https://www.fiverr.com/inbox*
// @grant        none
// ==/UserScript==

(function() {
    'use strict';

    // Function to check for new orders and display an alert.
    function checkForNewOrders() {
        // Get the root element.
        const rootElement = document.querySelector('#main-wrapper');

        if (rootElement) {
            // Traverse the DOM tree to find the contact list.
            const contactsList = rootElement.querySelector('.contacts-list');

            if (contactsList) {
                // Get the current item count.
                const currentItemCount = contactsList.querySelectorAll('div[data-testid="contact"]').length;
                // Store the previous item count in localStorage.
                const previousItemCount = localStorage.getItem('previousItemCount');

                // Check if the item count has increased.
                if (currentItemCount > parseInt(previousItemCount)) {
                    // Update the previous item count.
                    localStorage.setItem('previousItemCount', currentItemCount);

                    //API Call
                    var xhr = new XMLHttpRequest();
                    xhr.open("GET", "http://localhost:8080/api/hello", true);
                    xhr.send();

                } else {
                    // If there's no previous count, set it for future comparisons.
                    localStorage.setItem('previousItemCount', currentItemCount);
                    //var xhr = new XMLHttpRequest();
                    //xhr.open("GET", "http://localhost:8080/api/hello", true);
                    //xhr.send();
                }
            }
        }
    }

    // Function to refresh the page every 10 minutes.
    function refreshPage() {
        setTimeout(() => {
            location.reload();
        }, 1 * 60 * 1000); // Refresh every 1 minutes (10 * 60 * 1000 milliseconds).
    }
    // Call the refreshPage function to refresh the page periodically.
    refreshPage();
    // Wait for 10 seconds before checking for new orders.
    setTimeout(() => {
        checkForNewOrders();
    }, 10000); // 10 seconds delay
    // Call the checkForNewOrders function to check for new orders.
    checkForNewOrders();
    
})();
