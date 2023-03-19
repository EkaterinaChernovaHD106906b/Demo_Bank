package ru.guru99.page;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class PaymentSuccessfullPage {
    private SelenideElement paymentSuccessfull= $x("//h2[text()='Payment successfull!']");

    public void checkPayment(){
        paymentSuccessfull.shouldBe(Condition.visible, Duration.ofSeconds(20));
    }
}
