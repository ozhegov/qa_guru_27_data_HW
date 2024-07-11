package utils;

public enum ResultTableData {

    MODAL_HEADER("Thanks for submitting the form"),
    NAME("Student Name"),
    EMAIL("Student Email"),
    GENDER("Gender"),
    MOBILE("Mobile"),
    DATE_OF_BIRTH("Date of Birth"),
    SUBJECTS("Subjects"),
    HOBBIES("Hobbies"),
    PICTURE("Picture"),
    ADDRESS("Address"),
    STATE_AND_CITY("State and City");

    public final String description;

    ResultTableData(String description) {
        this.description = description;
    }
}
