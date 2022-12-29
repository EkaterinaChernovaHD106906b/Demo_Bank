import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        $("div[style='text-align: center;']").shouldBe(Condition.visible, Duration.ofSeconds(30));
        $("a[href='addcustomerpage.php']").click();
        $("input[name='name']").click();
        $("input[name='name']").setValue(faker.name().fullName());
        $x("//td/input[2]").click();
        $("textarea[name='addr']").setValue(faker.address().fullAddress());
        $("input[name='city']").setValue(faker.address().city());
        $("input[name='state']").setValue(faker.address().state());
        $("input[name='pinno']").setValue(faker.finance().creditCard().substring(5));
        $("input[name='telephoneno']").setValue(faker.phoneNumber().phoneNumber());
        $("input[name='emailid']").setValue(faker.internet().emailAddress());
        $("input[name='sub']").click();

    }

    @Test
    void gtplBankLogOut() {
        open("http://demo.guru99.com/V1/html/Managerhomepage.php");
        $("a[href='Logout.php']").click();
        $("form[name='frmLogin']").shouldBe(Condition.visible, Duration.ofSeconds(30));

    }

    @Test
    void addCustomerTelecom() {
        open("https://demo.guru99.com/telecom/addcustomer.php");
        $("label[for='done']").click();
        $("input[name='fname']").setValue(faker.name().firstName());
        $("input[name='lname']").setValue(faker.name().lastName());
        $("input[name='emailid']").setValue(faker.internet().emailAddress());
        $("textarea[name='addr']").setValue(faker.address().fullAddress());
        $("input[name='telephoneno']").setValue(faker.phoneNumber().phoneNumber());
        $("input[name='submit']").click();
    }

    @Test
    void toursSignOn() {
        open("https://demo.guru99.com/test/newtours/login.php");
        $("input[name='userName']").setValue(faker.name().username());
        $("input[name='password']").setValue(faker.internet().password());
        $("input[name='submit']").click();
        $x("//b[contains(text(),'Thank you for Loggin')]").shouldBe(Condition.visible, Duration.ofSeconds(30));

    }

    @Test
    void tourRegister() {
        open("https://demo.guru99.com/test/newtours/login.php");
        $("a[href='register.php']").click();
        $("input[name='firstName']").setValue(faker.name().firstName());
        $("input[name='lastName']").setValue(faker.name().lastName());
        $("input[name='phone']").setValue(faker.phoneNumber().phoneNumber());
        $("input[name='userName']").setValue(faker.internet().emailAddress());
        $("input[name='address1']").setValue(faker.address().fullAddress());
        $("input[name='city']").setValue(faker.address().city());
        $("input[name='state']").setValue(faker.address().state());
        $("input[name='postalCode']").setValue(faker.address().countryCode());
        $("select[name='country']").click();
        $("option[value=ARGENTINA]").click();
        $("#email").setValue(faker.name().username());
        $("input[name='password']").setValue("pass");
        $("input[name='confirmPassword']").setValue("pass");
        $("input[name='submit']").click();
        $x("//font[contains(text(),'Thank you for registering')]").shouldBe(Condition.visible, Duration.ofSeconds(30));


    }
}