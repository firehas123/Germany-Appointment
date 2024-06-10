package com.example.Whatsapp;

//import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import java.util.*;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.type.PhoneNumber;

@RestController
@RequestMapping("/api")
public class WhatsappWindow {

    @GetMapping("/hello")
    public void whatsappWindow() {
        System.out.println("Fiver");
            sendEmail(1);
        /*
        the following commented code opens whatsapp web in chrome browser and you need the driver for the browser that are in the previous directory respectively
         */
        //        try {
//            System.setProperty("webdriver.gecko.driver", "D:\\Intellij\\Whatsapp\\firefox\\geckodriver.exe");
//
//            //String profilePath = "C:\\Users\\mrhas\\AppData\\Local\\Mozilla\\Firefox\\Profiles\\thyll49e.default-release";
//            File profileDirectory = new File("C:\\Users\\mrhas\\AppData\\Local\\Mozilla\\Firefox\\Profiles\\thyll49e.default-release");
//            FirefoxProfile profile = new FirefoxProfile(profileDirectory);
//
//            // Create FirefoxOptions and set the profile
//            FirefoxOptions options = new FirefoxOptions();
//            options.setProfile(profile);
//
//            // Initialize the FirefoxDriver with the specified profile
//            WebDriver driver = new FirefoxDriver(options);
//
//            // Launch Website
//            driver.get("https://web.whatsapp.com");
//
//            // Optional: Add a delay to allow the page to load
//            Thread.sleep(10000);// 60 seconds (adjust as needed)
//
//            // Close the browser when done
//            driver.quit();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    @GetMapping("/helloG")
    public void whatsappWindowG() {
        System.out.println("Germany");
        sendEmail(2);
    }


    public void call() {
        String ACCOUNT_SID = "Your Account SID";
        String AUTH_TOKEN = "Your Auth Token";
        String FROM_PHONE_NUMBER = "+12692056841";
        String TO_PHONE_NUMBER = "+923334217028";
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        // Make a phone call
        Call call = Call.creator(
                new PhoneNumber(TO_PHONE_NUMBER),
                new PhoneNumber(FROM_PHONE_NUMBER),
                new com.twilio.type.Twiml("<Response><Say>Hello, this is a test call.</Say></Response>")
        ).create();

        System.out.println("Call SID: " + call.getSid());
    }
    private void sendEmail(int i) {
        call();
        String body = "";
        if(i==1){
            body = "FIVER ORDER";
        }else if(i==2){
            body = "GERMANY APPOINTMENT";
        }else{
            body = "NO OPTION";
        }
        String senderEmail = "amjadchfatima@gmail.com";


        // Recipient's email address
        String recipientEmail = "mr.hassanch@gmail.com";

        // SMTP server settings (for Gmail)
        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable", true);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.host", "smtp.gmail.com");

        String username = "amjadchfatima";
        String email_password = "ENTER YOUR PASSWORD";


        //session
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, email_password);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmail));
            message.setFrom(new InternetAddress(senderEmail));
            message.setSubject("IMPORTANT!!!");
            message.setText(body);
            System.out.println("Sending Mail");
            Transport.send(message);
            System.out.println("Mail sent");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
//            String userProfilePath = "C:\\Users\\mrhas\\AppData\\Local\\Microsoft\\Edge\\User Data"; //edge
//
//            // Specify the profile directory name within the user profile
//            //String profileDirectory = "Default";
//            String profileDirectory = "Profile 2";
//
//            EdgeOptions options = new EdgeOptions();
//            options.addArguments("--user-data-dir=" + userProfilePath);
//            options.addArguments("--profile-directory=" + profileDirectory);
// Set the desired port (e.g., 9515)
//int desiredPort = 9515;

// Use WebDriverManager to configure ChromeDriver
//WebDriverManager.chromedriver().setup();
// Set the ChromeDriver binary path (optional)
//System.setProperty("webdriver.edge.driver", "D:\\Intellij\\Whatsapp\\edge-driver\\msedgedriver.exe");
//System.setProperty("webdriver.chrome.logfile", "D:\\Intellij\\Whatsapp\\chromedriver-win64\\chromedriver-win64\\chromedriver.log");
//WebDriverManager.chromedriver().setup();

// Specify the path to the Chrome user profile directory
//String userProfilePath = "C:\\Users\\mrhas\\AppData\\Local\\Google\\Chrome\\User Data"; //chrome

//String profileDirectory = "Profile 1";
// Create ChromeOptions and set the user-data-dir and profile-directory
//ChromeOptions options = new ChromeOptions();
//options.addArguments("--start-maximized");
//            options.addArguments("start-maximized"); // open Browser in maximized mode
//            options.addArguments("disable-infobars"); // disabling infobars
//            options.addArguments("--disable-extensions"); // disabling extensions
//            options.addArguments("--disable-gpu"); // applicable to windows os only
//            options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
//            options.addArguments("--no-sandbox"); // Bypass OS security model