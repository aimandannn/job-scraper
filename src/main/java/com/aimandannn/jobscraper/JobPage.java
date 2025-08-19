package com.aimandannn.jobscraper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JobPage 
{
    public JobPage (WebDriver driver)
    {
        String originalPageURL = driver.getCurrentUrl();
        By noResult = By.cssSelector("data-automation='search-zero-results'");
        int pageNumber = 1;
        String currentURL = originalPageURL;

        do
        {
            System.out.println(currentURL);
            if (currentURL!=originalPageURL) 
            {
                driver.get(currentURL);
            }
            
            pageNumber++;
            currentURL = currentURL+"page="+pageNumber;

        }while(driver.findElements(noResult).isEmpty());

        System.out.println("You have reached all page.");
    }
}
