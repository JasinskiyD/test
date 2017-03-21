import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.junit.TextReport;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.Rule;
import org.junit.Test;
import java.util.Random;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.*;

public class Testing {
    @Rule
    public TextReport textReport = new TextReport();

    @Test
    public void test () {

        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://contenttravelnetwork.com";
        Configuration.holdBrowserOpen = true;
        ChromeDriverManager.getInstance().setup();
        Selenide.open("");

// Авторизация
        $(by("href*","login")).click();
        $("[name='user[email]']").sendKeys("prod.sabre@gmail.com");
        $("[name='user[pass]']").sendKeys("q1w2e3r4t5y6");
        $("[value='Вход на сайт']").click();

// Рандомный выбор данных
        int min = 0;
        int max = 3;
        Random rnd = new Random(System.currentTimeMillis());
        int randomIndex = min + rnd.nextInt(max - min + 1);

// Массивы данных
        String[] startPoint = {"LWO", "DNK", "ODS", "LWO"};
        String[] endPoint = {"LHR", "BUD", "TXL", "GDN"};
        String[] lastName = {"Jasinskiy", "Teplov", "Antipov", "Kovalskij"};
        String[] firstName = {"Vlad", "Igor", "Pavel", "Andrij"};
        String[] documentNumber = {"ws156546", "ad586884", "kl654168", "po851697"};
        String[] day = {"06", "05", "01", "09"};
        String[] month = {"09", "08", "11", "12"};
        String[] year = {"1980", "1985", "1990", "1987"};
        String[] expireYear = {"2019", "2025", "2028", "2020"};

// Применить поиск
        $("[data-uil='oneway']").click();
        $("[data-uil='start_point']").click();
        $("[data-uil='start_point']").sendKeys(startPoint[randomIndex]);
        $("[data-uil='end_point']").click();
        $("[data-uil='end_point']").sendKeys(endPoint[randomIndex]);
        $("[data-uil='end_point']").shouldBe(Condition.visible);
        $("[data-uil='point_list']").shouldBe(Condition.hidden);
        $("[data-handler='next']").click();
        $("[data-handler='next']").click();
        $("[data-handler='next']").click();
        $$("[data-handler='selectDay']").get(50).click();
        $("[data-uil='submit_search']").click();
        $(".preloader_banner").waitUntil(Condition.hidden, 50000);

// Выбрать результат поиска
        $("[data-auto-controller='AviaResultController']").waitUntil(Condition.visible, 50000);
        $("[data-uil='choose_result']").click();

// Данные о пассажирах
        $("[data-auto-controller='AviaPreBookingController']").waitUntil(Condition.visible, 50000);
        $("[for='passengers_gender_0-M']").click();
        $("[data-uil='lastname']").sendKeys(lastName[randomIndex]);
        $("[data-uil='first_name']").sendKeys(firstName[randomIndex]);
        $("[name='passengers[0][birthday_day]']").sendKeys(day[randomIndex]);
        $("[name='passengers[0][birthday_month]']").sendKeys(month[randomIndex]);
        $("[name='passengers[0][birthday_year]']").sendKeys(year[randomIndex]);
        $("[data-uil='doc_num']").sendKeys(documentNumber[randomIndex]);
        $("[name='passengers[0][doc_expire_date_day]']").shouldBe(Condition.enabled).sendKeys(day[randomIndex]);
        $("[name='passengers[0][doc_expire_date_month]']").shouldBe(Condition.enabled).sendKeys(month[randomIndex]);
        $("[name='passengers[0][doc_expire_date_year]']").shouldBe(Condition.enabled).sendKeys(expireYear[randomIndex]);
        $("[data-uil='to_pay']").click();

// Бронирование
        $("[data-uil='i_accept']").click();
        $("[data-uil='submit_payment']").click();
        $("[class='countdown_desc']").waitUntil(Condition.visible, 50000);
        $(by("href*","http://contenttravelnetwork.com")).click();
        $("[class='btn cancel cancel_booking js-cancel-booking']").waitUntil(Condition.visible, 50000).click();



    }

    @Test
    public void test2(){

        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://contenttravelnetwork.ee";
        Configuration.holdBrowserOpen = true;
        ChromeDriverManager.getInstance().setup();
        Selenide.open("");

// Авторизация
        $(by("href*","login")).click();
        $("[name='user[email]']").sendKeys("prod.ctn.ee@gmail.com");
        $("[name='user[pass]']").sendKeys("spqr_5891");
        $("[value='Вход на сайт']").click();

// Рандомный выбор данных
        int min = 0;
        int max = 3;
        Random rnd = new Random(System.currentTimeMillis());
        int randomIndex = min + rnd.nextInt(max - min + 1);

// Массивы данных
        String[] startPoint = {"LWO", "DNK", "ODS", "LWO"};
        String[] endPoint = {"LHR", "BUD", "TXL", "GDN"};
        String[] lastName = {"Jasinskiy", "Teplov", "Antipov", "Kovalskij"};
        String[] firstName = {"Vlad", "Igor", "Pavel", "Andrij"};
        String[] documentNumber = {"ws156546", "ad586884", "kl654168", "po851697"};
        String[] day = {"06", "05", "01", "09"};
        String[] month = {"09", "08", "11", "12"};
        String[] year = {"1980", "1985", "1990", "1987"};
        String[] expireYear = {"2019", "2025", "2028", "2020"};

// Применить поиск
        $("[data-uil='oneway']").click();
        $("[data-uil='start_point']").click();
        $("[data-uil='start_point']").sendKeys(startPoint[randomIndex]);
        $("[data-uil='end_point']").click();
        $("[data-uil='end_point']").sendKeys(endPoint[randomIndex]);
        $("[data-uil='end_point']").shouldBe(Condition.visible);
        $("[data-uil='point_list']").shouldBe(Condition.hidden);
        $("[data-handler='next']").click();
        $("[data-handler='next']").click();
        $("[data-handler='next']").click();
        $$("[data-handler='selectDay']").get(50).click();
        $("[data-uil='submit_search']").click();
        $(".preloader_banner").waitUntil(Condition.hidden, 50000);

// Выбрать результат поиска
        $("[data-auto-controller='AviaResultController']").waitUntil(Condition.visible, 50000);
        $("[data-uil='choose_result']").click();

// Данные о пассажирах
        $("[data-auto-controller='AviaPreBookingController']").waitUntil(Condition.visible, 50000);
        $("[for='passengers_gender_0-M']").click();
        $("[data-uil='lastname']").sendKeys(lastName[randomIndex]);
        $("[data-uil='first_name']").sendKeys(firstName[randomIndex]);
        $("[name='passengers[0][birthday_day]']").sendKeys(day[randomIndex]);
        $("[name='passengers[0][birthday_month]']").sendKeys(month[randomIndex]);
        $("[name='passengers[0][birthday_year]']").sendKeys(year[randomIndex]);
        $("[data-uil='doc_num']").sendKeys(documentNumber[randomIndex]);
        $("[name='passengers[0][doc_expire_date_day]']").shouldBe(Condition.enabled).sendKeys(day[randomIndex]);
        $("[name='passengers[0][doc_expire_date_month]']").shouldBe(Condition.enabled).sendKeys(month[randomIndex]);
        $("[name='passengers[0][doc_expire_date_year]']").shouldBe(Condition.enabled).sendKeys(expireYear[randomIndex]);
        $("[data-uil='to_pay']").click();

// Бронирование
        $("[data-uil='i_accept']").click();
        $("[data-uil='submit_payment']").click();
        $("[class='countdown_desc']").waitUntil(Condition.visible, 50000);
        $(by("href*","http://contenttravelnetwork.ee")).click();
        $("[class='btn cancel cancel_booking js-cancel-booking']").waitUntil(Condition.visible, 50000).click();
    }

    @Test
    public void test3(){

        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://ctn.tickets.ua";
        Configuration.holdBrowserOpen = true;
        ChromeDriverManager.getInstance().setup();
        Selenide.open("");

// Авторизация
        $(by("href*","login")).click();
        $("[name='user[email]']").sendKeys("prod.agent.ua@gmail.com");
        $("[name='user[pass]']").sendKeys("spqr_5891");
        $("[value='Вход на сайт']").click();

// Рандомный выбор данных
        int min = 0;
        int max = 3;
        Random rnd = new Random(System.currentTimeMillis());
        int randomIndex = min + rnd.nextInt(max - min + 1);

// Массивы данных
        String[] startPoint = {"LWO", "DNK", "ODS", "LWO"};
        String[] endPoint = {"LHR", "BUD", "TXL", "GDN"};
        String[] lastName = {"Jasinskiy", "Teplov", "Antipov", "Kovalskij"};
        String[] firstName = {"Vlad", "Igor", "Pavel", "Andrij"};
        String[] documentNumber = {"ws156546", "ad586884", "kl654168", "po851697"};
        String[] day = {"06", "05", "01", "09"};
        String[] month = {"09", "08", "11", "12"};
        String[] year = {"1980", "1985", "1990", "1987"};
        String[] expireYear = {"2019", "2025", "2028", "2020"};

// Применить поиск
        $("[data-uil='oneway']").click();
        $("[data-uil='start_point']").click();
        $("[data-uil='start_point']").sendKeys(startPoint[randomIndex]);
        $("[data-uil='end_point']").click();
        $("[data-uil='end_point']").sendKeys(endPoint[randomIndex]);
        $("[data-uil='end_point']").shouldBe(Condition.visible);
        $("[data-uil='point_list']").shouldBe(Condition.hidden);
        $("[data-handler='next']").click();
        $("[data-handler='next']").click();
        $("[data-handler='next']").click();
        $$("[data-handler='selectDay']").get(50).click();
        $("[data-uil='submit_search']").click();
        $(".preloader_banner").waitUntil(Condition.hidden, 50000);

// Выбрать результат поиска
        $("[data-auto-controller='AviaResultController']").waitUntil(Condition.visible, 50000);
        $("[data-uil='choose_result']").click();

// Данные о пассажирах
        $("[data-auto-controller='AviaPreBookingController']").waitUntil(Condition.visible, 50000);
        $("[for='passengers_gender_0-M']").click();
        $("[data-uil='lastname']").sendKeys(lastName[randomIndex]);
        $("[data-uil='first_name']").sendKeys(firstName[randomIndex]);
        $("[name='passengers[0][birthday_day]']").sendKeys(day[randomIndex]);
        $("[name='passengers[0][birthday_month]']").sendKeys(month[randomIndex]);
        $("[name='passengers[0][birthday_year]']").sendKeys(year[randomIndex]);
        $("[data-uil='doc_num']").sendKeys(documentNumber[randomIndex]);
        $("[name='passengers[0][doc_expire_date_day]']").shouldBe(Condition.enabled).sendKeys(day[randomIndex]);
        $("[name='passengers[0][doc_expire_date_month]']").shouldBe(Condition.enabled).sendKeys(month[randomIndex]);
        $("[name='passengers[0][doc_expire_date_year]']").shouldBe(Condition.enabled).sendKeys(expireYear[randomIndex]);
        $("[data-uil='to_pay']").click();

// Бронирование
        $("[data-uil='i_accept']").click();
        $("[data-uil='submit_payment']").click();
        $("[class='countdown_desc']").waitUntil(Condition.visible, 50000);
        $(by("href*","http://ctn.tickets.ua")).click();
        $("[class='btn cancel cancel_booking js-cancel-booking']").waitUntil(Condition.visible, 50000).click();

    }

}