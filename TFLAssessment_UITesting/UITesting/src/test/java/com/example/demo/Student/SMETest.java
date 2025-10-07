package com.example.demo.Student;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SMETest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opts = new ChromeOptions();
        driver = new ChromeDriver(opts);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void loginTest() {
        driver.get("http://127.0.0.1:5500/Home.html");

        WebElement login = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Login")));
        login.click();
        wait.until(ExpectedConditions.urlContains("loginJWT.html"));
        Assert.assertTrue(driver.getCurrentUrl().contains("loginJWT.html"), "Login page not loaded");

        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        email.sendKeys("nirjala.naik@example.com");
        password.sendKeys("12345");

        WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
        submit.click();
        wait.until(ExpectedConditions.urlContains("/SME/sme.html"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/SME/sme.html"), "SME page not loaded");

        WebElement createTest = wait.until(ExpectedConditions.elementToBeClickable(By.id("createTestLink")));
        createTest.click();
        wait.until(ExpectedConditions.urlContains("/SME/sme.html"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/SME/sme.html"), "Create Test click did not work");
    
      
      
      
      }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
