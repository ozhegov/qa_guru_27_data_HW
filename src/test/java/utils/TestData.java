package utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {

    private static final Faker faker = new Faker(new Locale("en"));

    public String firstName = getRandomFirstName(),
            lastName = getRandomLastName(),
            userEmail = getRandomEmail(),
            userGender = getRandomGender(),
            userMobileNumber = getRandomMobilePhone(),
            day = getRandomDay(),
            month = getRandomMonth(),
            year = getRandomYear(),
            userSubject = getRandomSubject(),
            userHobby = getRandomHobby(),
            picture = getRandomPicture(),
            userStreetAddress = getUserStreetAddress(),
            userState = getRandomState(),
            userCity = getRandomCity(userState);


    public static String getRandomFirstName(){
        return faker.name().firstName();
    }

    public static String getRandomLastName(){
        return faker.name().lastName();
    }

    public static String getRandomEmail(){
        return faker.internet().emailAddress();
    }

    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};

        return faker.options().option(genders);
    }

    public static String getRandomMobilePhone() {
        return faker.number().digits(10);
    }

    public static String getRandomDay(){
        return String.valueOf(faker.number().numberBetween(1,28));
    }

    public static String getRandomMonth(){
        String[] month = {"December", "January", "February", "March",
                "April", "May", "June", "July",
                "August", "September", "October", "November"};

        return faker.options().option(month);
    }

    public static String getRandomYear(){
        return String.valueOf(faker.number().numberBetween(1900,2006));
    }

    public static String getRandomSubject() {
        String[] subjects = {"Accounting", "Arts", "Maths", "Social Studies", "Biology", "Hindi", "Commerce", "Computer Science"};

        return faker.options().option(subjects);
    }

    public static String getRandomHobby() {
        String[] hobbies = {"Sports", "Reading", "Music"};

        return faker.options().option(hobbies);
    }

    public static String getRandomPicture() {
        String[] pictures = {"ava.jpg", "ava-2.jpg"};

        return faker.options().option(pictures);
    }

    public static String getUserStreetAddress() {
        return faker.address().streetAddress();
    }

    public static String getRandomState() {
        String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};

        return faker.options().option(states);
    }

    public static String getRandomCity(String state) {

        String city = "";
        
        String[] citiesNCR = {"Delhi", "Gurgaon", "Noida"};
        String[] citiesUttarPradesh = {"Agra", "Lucknow", "Merrut"};
        String[] citiesHaryana = {"Karnal", "Panipat"};
        String[] citiesRajasthan = {"Jaipur", "Jaiselmer"};

        if (state.equals("NCR")) city = faker.options().option(citiesNCR);
        else if (state.equals("Uttar Pradesh")) city = faker.options().option(citiesUttarPradesh);
        else if (state.equals("Haryana")) city = faker.options().option(citiesHaryana);
        else if (state.equals("Rajasthan")) city = faker.options().option(citiesRajasthan);
        
        return city;
    }

}
