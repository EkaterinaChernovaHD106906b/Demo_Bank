import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;

import static com.codeborne.selenide.Selenide.$;

public class RegisterPage {
    Faker faker = new Faker();

    private SelenideElement registerButton = $("a[href='register.php']");
    private SelenideElement firstName = $("input[name='firstName']");
    private SelenideElement lastName = $("input[name='lastName']");
    private SelenideElement phone = $("input[name='phone']");
    private SelenideElement userName = $("input[name='userName']");
    private SelenideElement address = $("input[name='address1']");
    private SelenideElement city = $("input[name='city']");
    private SelenideElement state = $("input[name='state']");
    private SelenideElement postalCode = $("input[name='postalCode']");
    private SelenideElement country = $("select[name='country']");
    private SelenideElement option = $("option[value=ARGENTINA]");
    private SelenideElement email = $("#email");
    private SelenideElement password = $("input[name='password']");
    private SelenideElement confirm = $("input[name='confirmPassword']");
    private SelenideElement submit = $("input[name='submit']");

    public void setPassword(String pass) {
        password.setValue("pass");
    }

    public void setConfirm(String confirmpass) {
        confirm.setValue(confirmpass);
    }

    public void registerNewUser() {
        registerButton.click();
        firstName.setValue(faker.name().firstName());
        lastName.setValue(faker.name().lastName());
        phone.setValue(faker.phoneNumber().phoneNumber());
        userName.setValue(faker.internet().emailAddress());
        address.setValue(faker.address().fullAddress());
        city.setValue(faker.address().city());
        state.setValue(faker.address().state());
        postalCode.setValue(faker.address().countryCode());
        country.click();
        option.click();
        email.setValue(faker.name().username());
        setPassword("pass");
        setConfirm("pass");
        clickSubmit();

    }
    public WelcomeRegisterPage clickSubmit(){
        submit.click();
        return new WelcomeRegisterPage();

    }
}
