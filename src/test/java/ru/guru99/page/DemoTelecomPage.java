package ru.guru99.page;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;

import static com.codeborne.selenide.Selenide.$;

public class DemoTelecomPage {
    Faker faker = new Faker();
    private SelenideElement check = $("label[for='done']");
    private SelenideElement firstName = $("input[name='fname']");
    private SelenideElement lastName = $("input[name='lname']");
    private SelenideElement email = $("input[name='emailid']");
    private SelenideElement address = $("textarea[name='addr']");
    private SelenideElement phoneNumber = $("input[name='telephoneno']");
    private SelenideElement submitButton = $("input[name='submit']");

    public void addCustomer() {
        check.click();
        firstName.setValue(faker.name().firstName());
        lastName.setValue(faker.name().lastName());
        email.setValue(faker.internet().emailAddress());
        address.setValue(faker.address().fullAddress());
        phoneNumber.setValue(faker.phoneNumber().phoneNumber());
        submitButton.click();
        Selenide.switchTo().alert().accept();
    }


}
