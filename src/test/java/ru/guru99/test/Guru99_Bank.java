package ru.guru99.test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.commands.UploadFile;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import ru.guru99.page.*;

import java.io.File;
import java.time.Duration;
import java.util.Locale;

import static com.codeborne.selenide.Selenide.*;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Guru99_Bank {
    Faker faker = new Faker();

    @BeforeEach
    void setUp() {
        Configuration.holdBrowserOpen = true;
    }

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @Test
    void gtplBankAddNewCustomer() {
        open("http://demo.guru99.com/V1/html/Managerhomepage.php");
        new ManagerHomePage()
                .addNewCustomer();

    }


    @Test
    void addCustomerTelecom() {
        open("https://demo.guru99.com/telecom/addcustomer.php");
        new DemoTelecomPage()
                .addCustomer();
    }

    @Test
    void toursSignOn() {
        open("https://demo.guru99.com/test/newtours/login.php");
        new TourSignOnPage()
                .signOn("user", "pass");
        new WelcomePage()
                .checkWelcomePage();


    }

    @Test
    void tourRegister() {
        open("https://demo.guru99.com/test/newtours/login.php");
        new RegisterPage()
                .registerNewUser();
        new WelcomeRegisterPage()
                .checkWelcomePage();


    }

    @Test
    void paymentGateway() {
        open("https://demo.guru99.com/payment-gateway/index.php");
        new PaymentPage()
                .buyProduct("7626378637826382");
        new PaymentSuccessfullPage()
                .checkPayment();
    }

    @Test
    void iFrame() {
        open("https://the-internet.herokuapp.com/iframe");
        $x("//*[@class='tox-edit-area']").click();
        switchTo().frame($x("//*[@id='mce_0_ifr']")).findElement(By.xpath("//*[@id='tinymce']")).clear();
        $("#tinymce").setValue("My text");


    }

    @Test
    void fileUploader() {
        open("https://the-internet.herokuapp.com/upload");
        $x("//*[@id='file-upload'] [@name='file']").uploadFile(new File("src/test/File.txt"));
        $("#file-submit").click();
        $x("//h3[text()='File Uploaded!']").shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

}