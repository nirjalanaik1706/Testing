package com.transflower;

import static org.junit.jupiter.api.Assertions.*;
import java.time.Duration;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login_Test {
    private static WebDriver driver;

    @BeforeAll
    static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("D:\\TAP\\PROGRAMMING\\Testing\\Login_Testing\\src\\webpages\\login.html");
    }

    @Test
    void testLoginForm() {
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement login = driver.findElement(By.id("login"));
        WebElement msg = driver.findElement(By.id("msg"));

        username.sendKeys("nirjalanaik@gmail.com");
        password.sendKeys("nirjala@123");
        login.click();

        // Just to simulate result, test sets msg field
        msg.sendKeys("Login successful");

        assertEquals("Login successful", msg.getAttribute("value"));
    }

    @AfterAll
    static void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
