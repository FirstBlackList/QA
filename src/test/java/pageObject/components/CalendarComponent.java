package pageObject.components;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CalendarComponent {

    public void setDate(String day, String month, String year) {

        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        //перед числами из одной цифры подставлять ноль (пример 01, 07 и.т.д)
        $x("//div[contains(@class, 'react-datepicker__day--0" + day + "')]" +
                "[not(contains(@class, 'react-datepicker__day--outside-month'))]").click();
    }

}
