import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class WelcomeRegisterPage {
    private SelenideElement welcome = $x("//font[contains(text(),'Thank you for registering.')]");

    public void checkWelcomePage() {
        welcome.shouldBe(Condition.visible, Duration.ofSeconds(30));
    }
}
