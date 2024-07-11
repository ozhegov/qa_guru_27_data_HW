package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    private SelenideElement monthPicker = $(".react-datepicker__month-select"),
                            yearPicker = $(".react-datepicker__year-select"),
                            dayPicker = $(".react-datepicker__month");


    public void setDay (String day, String month, String year) {
        monthPicker.selectOption(month);
        yearPicker.selectOption(year);
        dayPicker.$(byText(day)).click();
    }

}
