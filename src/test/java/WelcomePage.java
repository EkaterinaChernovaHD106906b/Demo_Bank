import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class WelcomePage {
    private SelenideElement welcome = $x("//b[contains(text(),'Thank you for Loggin.')]");

    public void checkWelcomePage() {
        welcome.shouldBe(Condition.visible, Duration.ofSeconds(30));
    }


}
