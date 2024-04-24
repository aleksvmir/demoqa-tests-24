package tests;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000;
    }


    @Test
    void fillFormTest() {
        open("/text-box");
        $("#userName").setValue("Alekseev");
        $("#userEmail").setValue("alekseev@mail.com");
        $("#currentAddress").setValue("Some street 1");
        $("#permanentAddress").setValue("Another street 1");
        $("#submit").click();

        $("[#output #name").shouldHave(text("Alekseev"));
        $("[#output #email").shouldHave(text("alekseev@mail.com"));
        $("[#output #currentAddress").shouldHave(text("Some street 1"));
        $("[#output #permanentAddress").shouldHave(text("Another street 1"));
    }
}