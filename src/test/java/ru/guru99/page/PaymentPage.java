package ru.guru99.page;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class PaymentPage {
    Faker faker = new Faker();

    private SelenideElement countButton = $("option[value='2']");
    private SelenideElement buyButton = $("input[value='Buy Now']");
    private SelenideElement paymentProcess = $x("//h2[text()='Payment Process']");
    private SelenideElement cardNumber = $("input[id='card_nmuber']");
    private SelenideElement month = $("select[id='month'] option[value='6']");
    private SelenideElement year = $("select[id='year'] option[value='2025']");
    private SelenideElement cvv = $("#cvv_code");
    private SelenideElement payButton = $("ul.actions");
    private SelenideElement paymentSuccessfull = $x("//h2[text()='Payment successfull!']");

    public PaymentSuccessfullPage buyProduct(String card) {
        countButton.click();
        buyButton.click();
        paymentProcess.shouldBe(Condition.visible, Duration.ofSeconds(20));
        cardNumber.setValue(card);
        month.click();
        year.click();
        cvv.setValue(faker.finance().creditCard().substring(1, 4));
        payButton.click();
        return new PaymentSuccessfullPage();
    }

}
