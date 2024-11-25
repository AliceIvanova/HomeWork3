
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {
  @BeforeAll
  static void beforeAll() {
    Configuration.browserSize = "1920x1080";
    Configuration.baseUrl = "https://demoqa.com";
    Configuration.browser = "edge";
  }

  @Test
  void fillFormTest() {
    open();
//        open("/automation-practice-form");
    open("https://demoqa.com/automation-practice-form");
    executeJavaScript("$('#fixedban').remove()");
    executeJavaScript("$('footer').remove()");
    $("#firstName").setValue("Alice");
    $("#lastName").setValue("Ivanova");
    $("#userEmail").setValue("alice-lilo@mail.ru");
    $(By.name("Gender")).selectRadio("Female");
    $("#userNumber").setValue("1234567891");
    $("#dateOfBirthInput").click();
    $(".react-datepicker__month-select").click();
    $(".react-datepicker__month-select").selectOption("April");
    $(".react-datepicker__year-select").selectOption(2005);
    $(".react-datepicker__day react-datepicker__day--028 react-datepicker__day--selected").click();
    $(".subjects-auto-complete__control css-yk16xz-control").click();
    $(".subjects-auto-complete__control css-yk16xz-control").setValue("Maths").pressEnter();
    $("#hobbies-checkbox-1").click();
    $("#hobbies-checkbox-2").click();
    $("#hobbies-checkbox-3").click();
    $("#uploadPicture").uploadFromClasspath("mid_338152_968112.jpg");
    $("#currentAddress").setValue("1\n 2\n 3\n 4\n 5\n 6");
    $(".css-tlfecz-indicatorContainer").setValue("NCR").pressEnter();
    $(".css-tlfecz-indicatorContainer").setValue("Delhi").pressEnter();
    $("#submit").click();
//        $(".react-datepicker__input-container").  // SelectOptionByTextOrIndex
//        .scrollIntoView(false)
    $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    $(".table").$(byText("Student Name")).sibling(0).shouldHave(text("Alice Ivanova"));
    $(".table").$(byText("Student Email")).sibling(0).shouldHave(text("alice-lilo@mail.ru"));
    $(".table").$(byText("Gender")).sibling(0).shouldHave(text("Female"));
    $(".table").$(byText("Mobile")).sibling(0).shouldHave(text("1234567891"));
    $(".table").$(byText("Date of Birth")).sibling(0).shouldHave(text("28 April,2005"));
    $(".table").$(byText("Subjects")).sibling(0).shouldHave(text("Maths"));
    $(".table").$(byText("Hobbies")).sibling(0).shouldHave(text("Reading, Music, Sports"));
    $(".table").$(byText("Picture")).sibling(0).shouldHave(text("mid_338152_968112.jpg"));
    $(".table").$(byText("Address")).sibling(0).shouldHave(text("1 2 3 4 5 6"));
    $(".table").$(byText("State and City")).sibling(0).shouldHave(text("NCR Delhi"));
  }

}