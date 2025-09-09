package com.aimandannn.jobscraper;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class JobFilter 
{
    private WebDriver driver;
    private WebDriverWait wait;

    public JobFilter(WebDriver driver)
    {
        this.driver = driver;
    }

    public Job filterJob(Job job)
    {
        String jobTitle = job.getTitle();
        String companyName = job.getCompanyName();
        String jobLocation = job.getLocation();
        String jobSalary = job.getSalary();
        String jobDescription = job.getDescription();
        String jobLink = job.getJobLink();
        String quickApply = job.getQuickApply();

        //Filter Job with Quick Apply enabled.

        if (quickApply == "Yes") 
        {
            //Optional Filtering 1: Configure Minimum Salary.

            if (!jobSalary.isEmpty()) 
            {
                //Extracting the salary from string.

                String cleanedSalaryString = jobSalary.toLowerCase().replace("rm", "")
                                            .replace(",", "").trim();

                String[] salaryList = cleanedSalaryString.split("-");

                
            }
            else
            {
                //Return empty field for those with empty salary in the Job Advertisement.
                return new Job("", "", "", "", "", "", "", "");
            }
        }
        else
        {
            return new Job("", "", "", "", "", "", "", "");
        }



        return job;
    }
}
