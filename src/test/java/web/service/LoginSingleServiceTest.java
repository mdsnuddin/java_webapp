package web.service;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import web.builder.UserBuilder;

public class LoginSingleServiceTest {

    public static WebDriver driver;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
    }

    @Test
    public void shouldLoginIntoApplication() {
        // Given
        driver.get("http://localhost:8080/index.jsp");

        // When
        driver.findElement(By.id("id_login")).click();
        UserBuilder user = new UserBuilder();
        user.name("TestName").password("TestPassword").build();
        driver.findElement(By.id("username")).sendKeys("TestName");
        driver.findElement(By.id("password")).sendKeys("TestPassword");
        driver.findElement(By.id("submit")).click();

        // Then
        // Assert here but skip for the moment as this project is only a prototype
    }
}
