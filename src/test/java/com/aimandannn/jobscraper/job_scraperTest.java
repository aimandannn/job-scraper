package com.aimandannn.jobscraper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.aimandannn.jobscraper.JobInput;
import com.aimandannn.jobscraper.JobLogin;
import com.aimandannn.jobscraper.JobSearch;
import com.aimandannn.jobscraper.JobExtractor;
import com.aimandannn.jobscraper.JobFilter;

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

        // JobLogin jobLogin = new JobLogin();
        JobInput jobInput = new JobInput();
        JobSearch jobSearch = new JobSearch();
        JobExtractor jobExtractor = new JobExtractor(driver);

        // jobLogin.login_job(driver);

        String userInput = jobInput.input_job(driver);
        int totalJob = jobSearch.search_job(driver, userInput);

        System.out.println(totalJob + " available related to this position.");

        List<Map<String, String>> allJobsLinks = new ArrayList<>();
        List<Job> allJobs = new ArrayList<>();
        Map<String, Job> filteredJobsMap = new HashMap<>();
        JobFilter jobFilter = new JobFilter(driver);
        
        int jobPage = 1;

        // do
        // {
        //     wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-automation='job-list-view-job-link']")));
            
        //     List<WebElement> jobCards = driver.findElements(By.cssSelector("[data-automation='job-list-view-job-link']"));
        
        //     for (WebElement jobCard : jobCards) 
        //     {
        //         String link = jobCard.getAttribute("href");
        //         Map<String, String> jobDetailsMap = new HashMap<>();

        //         jobDetailsMap.put("jobLink", link);
        //         allJobsLinks.add(jobDetailsMap);
        //     }

        //     try
        //     {
        //         By nextButton = By.cssSelector("a[aria-label='Next']");
        //         WebElement nextBtn = wait.until(ExpectedConditions.elementToBeClickable(nextButton));

        //         nextBtn.click();
                
        //         jobPage++;
        //     }
        //     catch(Exception e)
        //     {
        //         System.out.println("Total Page Retrieved: " + jobPage + ".");
        //         break;
        //     }

        // }while(true);

        // for(int a=0; a<allJobsLinks.size(); a++)
        // {
        //     Map<String, String> currentJobLink = allJobsLinks.get(a);
        //     String jobLink = currentJobLink.get("jobLink");

        //     Job currentJob = jobExtractor.extractJobDetails(jobLink);
        //     allJobs.add(currentJob);
        // }

        //To debug if any job retrieval failed from specific link.

        Job currentJob = jobExtractor.extractJobDetails("https://my.jobstreet.com/job/86710396?type=standard&ref=search-standalone#sol=5b750115d4231830a25bb169091e9ef18fd66023");
        allJobs.add(currentJob);

        Job currentJob1 = jobExtractor.extractJobDetails("https://my.jobstreet.com/job/86414820?type=standard&ref=search-standalone#sol=16618f8ca01d8534e5e740d4e0ba60d29a5f5993");
        allJobs.add(currentJob1);

        Job secondJob = allJobs.get(0);
        System.out.println("Job Title: " + secondJob.getTitle());
        System.out.println("Job Company: " + secondJob.getCompanyName());
        System.out.println("Job Salary: " + secondJob.getSalary());
        System.out.println("Job Location: " + secondJob.getLocation());
        System.out.println("Job Description: " + secondJob.getDescription());
        System.out.println("Date Posted: " + secondJob.getDatePosted());
        System.out.println("Job Link: " + secondJob.getJobLink());
        System.out.println("Quick Apply: " + secondJob.getQuickApply());

        //Filter the jobs retrieved based on conditions configured.

        for (Job job : allJobs) 
        {
            Job filteredJob = jobFilter.filterJob(job);
            filteredJobsMap.put(filteredJob.getJobLink(), filteredJob);
        }

        Job checkJob = filteredJobsMap.get("https://my.jobstreet.com/job/86414820?type=standard&ref=search-standalone#sol=16618f8ca01d8534e5e740d4e0ba60d29a5f5993");
        System.out.println("Job Title 2 - " + checkJob.getTitle());




        
        
    }




}











