package com.example.demo.Student;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SMETest {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opts = new ChromeOptions();
        driver = new ChromeDriver(opts);
        driver.manage().window().maximize();
    }

    @Test
    public void loginTest() {
        driver.get("http://127.0.0.1:5500/Home.html");

        WebElement login = driver.findElement(By.linkText("Login"));
        login.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("loginJWT.html"));
        Assert.assertTrue(driver.getCurrentUrl().contains("loginJWT.html"), "Login page not loaded");

        WebElement email = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.id("password"));

        email.sendKeys("nirjala.naik@example.com");
        password.sendKeys("12345");

        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();

        wait.until(ExpectedConditions.urlContains("/SME/sme.html"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/SME/sme.html"));

        WebElement createTest = driver.findElement(By.id("createTestLink"));
        createTest.click();

        wait.until(ExpectedConditions.urlContains("/SME/sme.html"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/SME/sme.html"));

        WebElement TestName = driver.findElement(By.id("testName"));
        TestName.sendKeys("ADVANCED JAVA");

        WebElement Duration = driver.findElement(By.id("duration"));
        Duration.sendKeys("00:40:00");

        try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }

        WebElement Subject = driver.findElement(By.id("subjectSelect"));
        Select subject = new Select(Subject);
        subject.selectByVisibleText("ADVJAVA");

        try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }

        WebElement SME = driver.findElement(By.id("smeSelect"));
        Select sme = new Select(SME);
        sme.selectByVisibleText("sahil kamble");

        try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }

        WebElement DateTime = driver.findElement(By.id("scheduledDate"));
        DateTime.sendKeys("2025-10-07T18:00");

        try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }

        WebElement passinglevel = driver.findElement(By.id("passingLevel"));
        passinglevel.sendKeys("2");

        try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }

        WebElement que1 = driver.findElement(By.cssSelector("input[value='6']"));
        que1.click();
        WebElement que2 = driver.findElement(By.cssSelector("input[value='7']"));
        que2.click();
        WebElement que3 = driver.findElement(By.cssSelector("input[value='8']"));
        que3.click();
        WebElement que4 = driver.findElement(By.cssSelector("input[value='9']"));
        que4.click();
        WebElement que5 = driver.findElement(By.cssSelector("input[value='10']"));
        que5.click();

        try { Thread.sleep(2000); 
        }
         catch (InterruptedException e) {
           e.printStackTrace(); }

        WebElement createtest = driver.findElement(By.id("submitBtn"));
        createtest.click();

   
        wait.until(ExpectedConditions.urlContains("/SME/reviewtest.html"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/SME/reviewtest.html"), "Review Test page not loaded");

        WebElement confirmandcreate = driver.findElement(By.id("confirmBtn"));
        confirmandcreate.click();

        // wait.until(ExpectedConditions.urlContains("/SME/sme.html"));
        // Assert.assertTrue(driver.getCurrentUrl().contains("/SME/sme.html"));

        // WebElement GetQuestionAndcriteria = driver.findElement(By.id("checkQuestionAsPerCriteria"));
        // GetQuestionAndcriteria.click();

        // wait.until(ExpectedConditions.urlContains("SME/sme.html?msg=Test%20Created%20Successfully"));
        // Assert.assertTrue(driver.getCurrentUrl().contains("SME/sme.html?msg=Test%20Created%20Successfully"));

        // WebElement selectSubject = driver.findElement(By.id("ddlSubjects"));
        // Select subject1 = new Select(selectSubject);
        // subject1.selectByVisibleText("COREJAVA");

        // WebElement selectEvaCriteria = driver.findElement(By.id("ddlCriteria"));
        // Select evacriteria = new Select(selectEvaCriteria);
        // evacriteria.selectByVisibleText("OOPS");
    }
}
