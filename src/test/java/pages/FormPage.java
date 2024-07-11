package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class FormPage {

    private SelenideElement firstNameInput = $("#firstName"),
                            lastNameInput = $("#lastName"),
                            emailInput = $("#userEmail"),
                            genderWrapper = $("#genterWrapper"),
                            userNumberInput = $("#userNumber"),
                            calendarInput = $("#dateOfBirthInput"),
                            hobbiesWrapper =  $("#hobbiesWrapper"),
                            userAddressInput = $("#currentAddress"),
                            subjectWrapper = $("#subjectsWrapper"),
                            subjectInput = $("#subjectsInput"),
                            fileUpload =  $("#uploadPicture"),
                            stateSelector = $("#state"),
                            stateCityWrapper = $("#stateCity-wrapper"),
                            citySelector = $("#city"),
                            submitButton = $("#submit");

    CalendarComponent calendarComponent = new CalendarComponent();

    public FormPage openPage() {
        open("/automation-practice-form");

        return this;
    }

    public FormPage removeFooter() {
        executeJavaScript("$('footer').remove();");
        executeJavaScript("$('#fixedban').remove();");

        return this;
    }

    public FormPage setFirstName (String firstName) {
        firstNameInput.setValue(firstName);

        return this;
    }

    public FormPage setLastName (String lastName) {
        lastNameInput.setValue(lastName);

        return this;
    }

    public FormPage setEmail (String email) {
        emailInput.setValue(email);

        return this;
    }

    public FormPage setGender (String gender) {
        genderWrapper.$(byText(gender)).click();

        return this;
    }

    public FormPage setUserNumber (String userNumber) {
        userNumberInput.setValue(userNumber);

        return this;
    }

    public FormPage setDayOfBirth (String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDay(day, month, year);

        return this;
    }

    public FormPage setSubject (String subject) {
        subjectWrapper.click();
        subjectInput.setValue(subject).pressEnter();

        return this;
    }

    public FormPage setHobby (String hobby) {
        hobbiesWrapper.$(byText(hobby)).click();

        return this;
    }

    public FormPage uploadPicture (String fileName) {
        fileUpload.uploadFromClasspath(fileName);

        return this;
    }

    public FormPage setUserAddress (String userAddress) {
        userAddressInput.setValue(userAddress);

        return this;
    }

    public FormPage setState (String state) {
        stateSelector.click();
        stateCityWrapper.$(byText(state)).click();

        return this;
    }

    public FormPage setCity (String city) {
        citySelector.click();
        stateCityWrapper.$(byText(city)).click();

        return this;
    }

    public void submitForm () {
        submitButton.click();
    }

}
