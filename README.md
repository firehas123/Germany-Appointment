# Germany-Appointment

This is a Java Spring Boot application that has an endpoint exposed via ngrok, a script is running in the browser via tampermonkey.

## Technologies Used

- Java
- Spring Boot
- Maven
- Twilio API
- Jakarta Mail API
- JavaScript

## Features

- Send emails based on specific triggers.
- Make phone calls using Twilio API.
- Interact with Whatsapp Web using Selenium WebDriver (currently commented out, WIP).

## Setup

1. Clone the repository.
2. Open the project in IntelliJ IDEA 2024.1.2 or any other IDE that supports Java and Maven.
3. Update the `application.properties` file with your specific configurations.
4. Run `WhatsappApplication.java` to start the application.
5. Have the tampermonkey extension in your browser and paste the JS code. Their is also JS code for Fiver if you get a new order you'll receive a call.

## API Endpoints

- `GET /api/hello`: Triggers the method which sends an email and makes a phone call. `Fiver Order`
- `GET /api/helloG`: Triggers the method which sends a different email and makes a phone call. `Germany Appointment`

## Note

The Selenium WebDriver code for interacting with Whatsapp Web is currently commented out. You can uncomment it and update the paths to the WebDriver executables and browser profiles as per your system configuration, might need to make adjustments.

## Disclaimer

This project is for educational purposes only. Please use responsibly.

## Additional Information

The application can be exposed to the internet using ngrok, which creates a secure tunnel to your localhost. This is useful for testing the application with Tampermonkey scripts running in the browser, can be done without ngrok as well.

This project is for educational purposes only. Please use responsibly.
