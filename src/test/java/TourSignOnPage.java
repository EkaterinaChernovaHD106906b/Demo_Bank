import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class TourSignOnPage {
    private SelenideElement userName = $("input[name='userName']");
    private SelenideElement password = $("input[name='password']");
    private SelenideElement submitButton = $("input[name='submit']");


    public void setUser(String user) {
        userName.setValue(user);

    }

    public void setPassword(String pass) {
        password.setValue(pass);
    }

    public WelcomePage clickSubmitButton() {
        submitButton.click();
        return new WelcomePage();
    }

    public void signOn(String user, String pass) {
        setUser(user);
        setPassword(pass);
        clickSubmitButton();
    }

}
