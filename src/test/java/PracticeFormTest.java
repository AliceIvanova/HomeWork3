
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {
@BeforeAll
static void beforeAll() {
  Configuration.browserSize = "1920x1080";
  //Configuration.baseUrl = "https://demoqa.com";
  //Configuration.browser = "edge";
  Configuration.headless = false;
  Configuration.pageLoadStrategy = "eager";
  open();
}

  @Test
  void fillFormTest() {
   // open("/automation-practice-form");
    open("https://demoqa.com/automation-practice-form");
    //executeJavaScript("$('#fixedban').remove()");
   // executeJavaScript("$('footer').remove()");
    $("#firstName").setValue("Alice");
    $("#lastName").setValue("Ivanova");
    $("#userEmail").setValue("alice-lilo@mail.ru");
    $("#genterWrapper").$(byText("Female")).click();
    $("#userNumber").setValue("1234567891");
    $("#dateOfBirthInput").click();
    $(".react-datepicker__month-select").click();
    $(".react-datepicker__month-select").selectOption("April");
    $(".react-datepicker__year-select").selectOption("2005");
    $$(".react-datepicker__day:not(.react-datepicker__day--outside-month)").findBy(text("28")).click();
    //$(".subjects-auto-complete__control css-yk16xz-control").click();
    $("#subjectsInput").setValue("Maths").pressEnter();
   // $(".subjects-auto-complete__control css-yk16xz-control").setValue("Maths").pressEnter();
    //$("#hobbies-checkbox-1").click();
    $("#hobbiesWrapper").$(byText("Sports")).click();
    $("#hobbiesWrapper").$(byText("Reading")).click();
    $("#hobbiesWrapper").$(byText("Music")).click();
    $("#uploadPicture").uploadFromClasspath("mid_338152_968112.jpg");
    $("#currentAddress").setValue("1\n 2\n 3\n 4\n 5\n 6").scrollIntoView(false);
    $("#userForm #react-select-3-input").setValue("NCR").pressEnter().scrollIntoView(false);
    $("#userForm #react-select-4-input").setValue("Delhi").pressEnter().scrollIntoView(false);
    $(byText("Submit")).scrollTo();
    $("#userForm #submit").click();
    $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    $(".table").$(byText("Student Name")).sibling(0).shouldHave(text("Alice Ivanova"));
    $(".table").$(byText("Student Email")).sibling(0).shouldHave(text("alice-lilo@mail.ru"));
    $(".table").$(byText("Gender")).sibling(0).shouldHave(text("Female"));
    $(".table").$(byText("Mobile")).sibling(0).shouldHave(text("1234567891"));
    $(".table").$(byText("Date of Birth")).sibling(0).shouldHave(text("28 April,2005"));
    $(".table").$(byText("Subjects")).sibling(0).shouldHave(text("Maths"));
    $(".table").$(byText("Hobbies")).sibling(0).shouldHave(text("Sports, Reading, Music"));
    $(".table").$(byText("Picture")).sibling(0).shouldHave(text("mid_338152_968112.jpg"));
    $(".table").$(byText("Address")).sibling(0).shouldHave(text("1 2 3 4 5 6"));
    $(".table").$(byText("State and City")).sibling(0).shouldHave(text("NCR Delhi"));
  }
  @AfterAll
  public static void tearDown() {
    // Чистка куки и localStorage.
    Selenide.clearBrowserCookies();
    Selenide.clearBrowserLocalStorage();
    closeWebDriver();
  }

}