package qa.demo;

import org.junit.jupiter.api.Test;
import pages.FormPage;
import pages.components.ModalWindowPage;
import utils.TestData;

import static utils.ResultTableData.*;

public class DemoQaFormTestsWithPom extends TestBase {

    FormPage formPage = new FormPage();
    ModalWindowPage modalWindowPage = new ModalWindowPage();

    TestData testData = new TestData();

    @Test
    void checkPracticeFormTest(){

        formPage.openPage()
                .removeFooter()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.userEmail)
                .setGender(testData.userGender)
                .setUserNumber(testData.userMobileNumber)
                .setDayOfBirth(testData.day, testData.month, testData.year)
                .setSubject(testData.userSubject)
                .setHobby(testData.userHobby)
                .uploadPicture(testData.picture)
                .setUserAddress(testData.userStreetAddress)
                .setState(testData.userState)
                .setCity(testData.userCity)
                .submitForm();

        modalWindowPage.checkModalWindow()
                .checkModalWindowHeader(MODAL_HEADER.description)
                .checkModalWindowTable(NAME.description, testData.firstName + " " + testData.lastName)
                .checkModalWindowTable(EMAIL.description, testData.userEmail)
                .checkModalWindowTable(GENDER.description, testData.userGender)
                .checkModalWindowTable(MOBILE.description, testData.userMobileNumber)
                .checkModalWindowTable(DATE_OF_BIRTH.description, testData.day + " " + testData.month + "," + testData.year)
                .checkModalWindowTable(SUBJECTS.description, testData.userSubject)
                .checkModalWindowTable(HOBBIES.description, testData.userHobby)
                .checkModalWindowTable(PICTURE.description, testData.picture)
                .checkModalWindowTable(ADDRESS.description, testData.userStreetAddress)
                .checkModalWindowTable(STATE_AND_CITY.description, testData.userState + " " + testData.userCity);
    }

    @Test
    void checkMinData() {
        formPage.openPage()
                .removeFooter()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGender(testData.userGender)
                .setUserNumber(testData.userMobileNumber)
                .submitForm();

        modalWindowPage.checkModalWindow()
                .checkModalWindowHeader(MODAL_HEADER.description)
                .checkModalWindowTable(NAME.description, testData.firstName + " " + testData.lastName)
                .checkModalWindowTable(GENDER.description, testData.userGender)
                .checkModalWindowTable(MOBILE.description, testData.userMobileNumber);
    }

    @Test
    void checkEmptyForm() {
        formPage.openPage()
                .removeFooter()
                .submitForm();

        modalWindowPage.checkModalWindowNotVisible();
    }
}
