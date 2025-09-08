package com.aimandannn.jobscraper;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class JobExtractor 
{
    private WebDriver driver;
    private WebDriverWait wait;

    public JobExtractor(WebDriver driver)
    {
        this.driver = driver;
    }

    public Job extractJobDetails(String jobLink)
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        
        try
        {

            driver.get(jobLink);

            String jobTitle;
            String jobCompany;
            String jobLocation;
            String jobSalary;
            String jobDescription;
            String jobDate;
            String quickApply = "No";

            //Retrieve Job Title from the Job page.
            try
            {
                By jobTitleSelector = By.cssSelector("h1[data-automation='job-detail-title']");
                WebElement jobTitleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(jobTitleSelector));
                jobTitle = jobTitleElement.getText();
            }
            catch(Exception e)
            {
                jobTitle = "";
            }

            //Retrieve Company Name from the Job page.
            try
            {
                By jobCompanySelector = By.cssSelector("span[data-automation='advertiser-name']");
                WebElement jobCompanyElement = wait.until(ExpectedConditions.visibilityOfElementLocated(jobCompanySelector));
                jobCompany = jobCompanyElement.getText();
            }
            catch(Exception e)
            {
                jobCompany = "";
            }

            //Retrieve Job Location from the Job page.
            try
            {
                By jobLocationSelector = By.cssSelector("span[data-automation='job-detail-location'] > a");
                WebElement jobLocationElement = wait.until(ExpectedConditions.visibilityOfElementLocated(jobLocationSelector));
                jobLocation = jobLocationElement.getText();
            }
            catch(Exception e)
            {
                jobLocation = "";
            }

            //Retrieve Job Salary from the Job page.
            try
            {
                By jobSalarySelector = By.cssSelector("span[data-automation='job-detail-salary']");
                WebElement jobSalaryElement = wait.until(ExpectedConditions.visibilityOfElementLocated(jobSalarySelector));
                jobSalary = jobSalaryElement.getText();
            }
            catch(Exception e)
            {
                jobSalary = "";
            }

            //Retrieve Job Description from the Job page.

            try
            {
                By jobDescriptionSelector = By.cssSelector("div.peseyf0._1de3e0s0");
                WebElement jobDescriptionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(jobDescriptionSelector));
                jobDescription = jobDescriptionElement.getText();
            }
            catch(Exception e)
            {
                jobDescription = "";
            }

            //Retrieve Date Posted of the Job from the Job page.
            try
            {
                By jobDateSelector = By.xpath("//span[contains(text(), 'Posted')]");
                WebElement jobDateElement = wait.until(ExpectedConditions.visibilityOfElementLocated(jobDateSelector));
                jobDate = jobDateElement.getText();
            }
            catch(Exception e)
            {
                jobDate = "";
            }

            try
            {
                By quickApplyBtnSelector = By.xpath("//span[text()='Quick apply']");
                List<WebElement> quickApplyBtnElement = driver.findElements(quickApplyBtnSelector);

                if(!quickApplyBtnElement.isEmpty())
                {
                    quickApply = "Yes";
                }
            }
            catch(Exception e)
            {
                
            }

            return new Job(jobTitle, jobCompany, jobLocation, jobSalary, jobDescription, jobDate, jobLink, quickApply); 
            
        }
        catch(Exception e)
        {
            System.out.println("Error in retrieving details for: " + jobLink);
            return new Job("", "", "", "", "", "", jobLink, "");
        }
    }
}
