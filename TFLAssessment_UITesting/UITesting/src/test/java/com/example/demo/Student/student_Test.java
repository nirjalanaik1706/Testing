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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class student_Test {
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

        WebElement login=driver.findElement(By.linkText("Login"));
        login.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("loginJWT.html"));
        Assert.assertTrue(driver.getCurrentUrl().contains("loginJWT.html"),"Login page not load");

        WebElement email = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.id("password"));

        email.sendKeys("sahil.kamble@example.com");
        password.sendKeys("12345");

    
        WebElement submit=driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();
        wait.until(ExpectedConditions.urlContains("/Student/student.html"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/Student/student.html"), "Student page not load after login");
  
        WebElement getAllTest=driver.findElement(By.id("TestList"));
        getAllTest.click();
        wait.until(ExpectedConditions.urlContains("Student/student.html#"));
        Assert.assertTrue(driver.getCurrentUrl().contains("Student/student.html#"),"did not get all tests");

        WebElement testDetails = driver.findElement(By.xpath("//button[text()='Details']"));
        testDetails.click();
        wait.until(ExpectedConditions.urlContains("Student/student.html#"));
        Assert.assertTrue(driver.getCurrentUrl().contains("Student/student.html#"),"no details load");

        WebElement startBtn = driver.findElement(By.xpath("//button[@class='startBtn' and @data-id='5']"));
        startBtn.click();
        // wait.until(ExpectedConditions.urlContains("Student/student.html#"));
        // Assert.assertTrue(driver.getCurrentUrl().contains("Student/student.html#"),"not working start button");



    }
}
