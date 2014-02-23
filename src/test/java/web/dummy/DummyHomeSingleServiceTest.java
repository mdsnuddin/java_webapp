package web.dummy;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DummyHomeSingleServiceTest {

    public static WebDriver driver;

    @Test
    public void shouldSeeDummyPage() {
        driver = new FirefoxDriver();
        driver.get("https://www.google.com/");
    }
}