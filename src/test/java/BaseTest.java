import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

abstract public class BaseTest {
  @BeforeAll
  @DisplayName("Настройка теста.")
  static void beforeAll() {
    Configuration.browserSize = "1920x1080";
    Configuration.baseUrl = "https://demoqa.com";
    Configuration.browser = "edge";
    open();
  }

  @AfterAll
  @DisplayName("Завершение работы.")
  public static void tearDown() {
    // Чистка куки и localStorage.
    Selenide.clearBrowserCookies();
    Selenide.clearBrowserLocalStorage();
    closeWebDriver();
  }

}
