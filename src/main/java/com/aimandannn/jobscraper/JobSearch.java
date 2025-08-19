package com.aimandannn.jobscraper;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class JobSearch 
{
    private WebDriverWait wait;

    public int search_job(WebDriver driver, String userInput) throws InterruptedException
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        
        WebElement job_keyword = driver.findElement(By.id("keywords-input"));
        job_keyword.sendKeys(userInput);

        WebElement job_search = driver.findElement(By.id("searchButton"));
        job_search.click();

        By resultCount = By.cssSelector("div[data-automation='totalJobsMessage'] span");
        WebElement totalResult = wait.until(ExpectedConditions.visibilityOfElementLocated(resultCount));
        String totalJob = totalResult.getText();
        
        totalJob = totalJob.replace(" jobs", "");
        int jobCount = Integer.parseInt(totalJob);

        return jobCount;
    }
}
