package com.example.catalog.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProductUITest {
    WebDriver driver;
    
    @BeforeClass
    public void setup(){
        driver=new ChromeDriver();
    }

    @Test
    public void testproductcatelogpage(){
        driver.get("D:\\TAP\\GITHUB\\Testing\\APITesting\\src\\main\\resources\\static\\index.html");
        List<WebElement> products=driver.findElements(By.tagName("li"));
        Assert.assertTrue(products.size()>0,"Products should be listed");
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }
    
}
