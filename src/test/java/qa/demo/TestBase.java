package qa.demo;

import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Configuration.*;

public class TestBase {

    @BeforeAll
    static void configuration(){
        baseUrl = "https://demoqa.com";
        browserSize = "1920 x 1080";
        pageLoadStrategy = "eager";
    }

}
