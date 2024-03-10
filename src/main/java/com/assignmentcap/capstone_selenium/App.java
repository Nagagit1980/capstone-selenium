package com.assignmentcap.capstone_selenium;
import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
        System.out.println( "Hello World!" );
        //Web driver
        //System.setProperty("webdriver.chrome.driver", "c:\\Users\\naga\\chromedriver-win64\\chromedriver.exe");
        
        //Web driver from pom file
        
        WebDriverManager.chromedriver().setup();
        
        ChromeOptions chromeoptions = new ChromeOptions();
        //chromeoptions.addArguments("--headless");
        WebDriver driver = new ChromeDriver(chromeoptions);
        
        System.out.println("Executing script");
        //1. Open Browser
        driver.get("http://3.17.164.222:8081/contact.html");
        
        //enable wait for 3 seconds
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        
        //Give user name
        driver.findElement(By.id("inputName")).sendKeys("naga");
        Thread.sleep(1000);
        driver.findElement(By.id("inputNumber")).sendKeys("99999999");
        Thread.sleep(1000);
        driver.findElement(By.id("inputMail")).sendKeys("naga@outlook.com");
        Thread.sleep(1000);
        driver.findElement(By.id("inputMessage")).sendKeys("HelloInsureMe");
        Thread.sleep(1000);
        driver.findElement(By.id("my-button")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("response")).getText();
        System.out.println(driver.findElement(By.id("response")).getText());
        String responsetext=driver.findElement(By.id("response")).getText();
        assertEquals("Message Sent", responsetext);
        driver.quit();
        System.out.println("Insure Me Script execution complete");       
    }
}
