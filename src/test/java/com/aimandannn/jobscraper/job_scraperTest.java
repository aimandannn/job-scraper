package com.aimandannn.jobscraper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class job_scraperTest 
{
    private WebDriver driver;
    private WebDriverWait wait;
    

    @BeforeEach
    void setupChromeDriver() 
    {
        // Setup Chrome Web Driver.
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Navigate to Google.com to confirm browser launch
        driver.get("https://www.google.com");
    }

    @Test
    void job_scraper_main () throws InterruptedException
    {
        driver.get("https://my.jobstreet.com/");

        JobLogin jobLogin = new JobLogin();
        // JobInput jobInput = new JobInput();
        // JobSearch jobSearch = new JobSearch();

        jobLogin.login_job(driver);

        // String userInput = jobInput.input_job(driver);
        // int totalJob = jobSearch.search_job(driver, userInput);

        // System.out.println(totalJob);
        


        
    }



}











