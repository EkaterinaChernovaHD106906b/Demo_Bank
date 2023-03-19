package ru.guru99.page;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;


import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ManagerHomePage {


    Faker faker = new Faker();
    private SelenideElement gtplBank = $("div[style='text-align: center;']");
    private SelenideElement addCustomer = $("a[href='addcustomerpage.php']");
    private SelenideElement customerName = $("input[name='name']");
    private SelenideElement gender = $x("//td/input[2]");
    private SelenideElement address = $("textarea[name='addr']");
    private SelenideElement city = $("input[name='city']");
    private SelenideElement state = $("input[name='state']");
    private SelenideElement pin = $("input[name='pinno']");
    private SelenideElement telNumber = $("input[name='telephoneno']");
    private SelenideElement email = $("input[name='emailid']");
    private SelenideElement subButton = $("input[name='sub']");

    public void addNewCustomer() {
        gtplBank.shouldBe(Condition.visible, Duration.ofSeconds(30));
        addCustomer.click();
        customerName.click();
        customerName.setValue(faker.name().fullName());
        gender.click();
        address.setValue(faker.address().fullAddress());
        city.setValue(faker.address().city());
        state.setValue(faker.address().state());
        pin.setValue(faker.finance().creditCard().substring(5));
        telNumber.setValue(faker.phoneNumber().phoneNumber());
        email.setValue(faker.internet().emailAddress());
        subButton.click();
        Selenide.switchTo().alert().accept();

    }


}
