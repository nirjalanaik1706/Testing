package com.example.demo.Admin;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class adminTest {
    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions opts=new ChromeOptions();
        driver=new ChromeDriver(opts);
        driver.manage().window().maximize();
    }

    @Test
    public void loginadmin(){
        driver.get("http://127.0.0.1:5500/Home.html");

        WebElement login=driver.findElement(By.linkText("Login"));
        login.click();

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
         wait.until(ExpectedConditions.urlContains("loginJWT.html"));
        Assert.assertTrue(driver.getCurrentUrl().contains("loginJWT.html"), "Login page not loaded");

        WebElement email = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.id("password"));

        email.sendKeys("ravi.tambade@example.com");
        password.sendKeys("12345");

        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();
        wait.until(ExpectedConditions.urlContains("/Admin/admin.html"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/Admin/admin.html"));
        
        WebElement AssignTest=driver.findElement(By.id("showTestBtw"));
        AssignTest.click();
        wait.until(ExpectedConditions.urlContains("/Admin/admin.html"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/Admin/admin.html"));

        WebElement fromdate=driver.findElement(By.id("fromDate"));
        WebElement todate=driver.findElement(By.id("toDate"));

        fromdate.sendKeys("06102025");
        todate.sendKeys("08102025");

        WebElement gettest=driver.findElement(By.xpath("//button[contains(text(),'Get Tests')]"));
        gettest.click();
        wait.until(ExpectedConditions.urlContains("/Admin/admin.html"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/Admin/admin.html"));
         try { 
            Thread.sleep(2000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement updatestatus = driver.findElement(By.xpath("//button[@onclick=\"updateTest(18)\"]"));
        updatestatus.click();

        wait.until(ExpectedConditions.urlContains("/Admin/updatetest.html?id=18"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/Admin/updatetest.html?id=18"));

        WebElement selectstatus=driver.findElement(By.id("statusDropdown"));
        Select status = new Select(selectstatus);
        status.selectByVisibleText("Scheduled");
        try { 
            Thread.sleep(2000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement changestatus=driver.findElement(By.id("changeStatus"));
        changestatus.click();
        try { 
            Thread.sleep(2000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Alert alert = driver.switchTo().alert();
        alert.accept();
         try { 
            Thread.sleep(2000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement getstudents=driver.findElement(By.id("getStudents"));
        getstudents.click();
        try { 
            Thread.sleep(2000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement sahilstudent=driver.findElement(By.cssSelector("input[value='4']"));
        sahilstudent.click();
        try { 
            Thread.sleep(2000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement startDate = driver.findElement(By.id("scheduledStart"));
        WebElement endDate = driver.findElement(By.id("scheduledEnd"));
        startDate.sendKeys("2025-10-09T10:00");
        endDate.sendKeys("2025-10-09T12:00");
       
         try { 
            Thread.sleep(2000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement remark = driver.findElement(By.id("remarks"));
        remark.sendKeys("please attend");
         try { 
            Thread.sleep(2000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement addstudent=driver.findElement(By.id("addStudent"));
        addstudent.click();
         try { 
            Thread.sleep(2000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Alert alert1 = driver.switchTo().alert();
        alert1.accept();
         try { 
            Thread.sleep(2000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        
    }
    
    
}
