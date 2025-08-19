package com.aimandannn.jobscraper;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JobLogin 
{
    public void login_job(WebDriver driver) throws InterruptedException
    {
        final WebDriverWait wait;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        
        WebElement userLogin = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[6]/div/div[2]/div[2]/section/div/div[2]/div[1]/a/span"));
        userLogin.click();

        //Enter your login details here.
        String emailAddress = "work.aimandanial@gmail.com";

        By inputEmail = By.id("emailAddress");
        WebElement inputUserEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(inputEmail));
        inputUserEmail.sendKeys(emailAddress);

        WebElement nextBtn = driver.findElement(By.xpath("//*[@id=\"signin_seekanz\"]/div/div[2]/button/span"));
        nextBtn.click();

        //Enter OTP Code received to your email here.

        String userInput = JOptionPane.showInputDialog(null, "Please Enter the OTP: ");

        //This is OTP fields.

        By otpCode = By.className("zvn9dn1");
        WebElement clickOTP = wait.until(ExpectedConditions.elementToBeClickable(otpCode));
        clickOTP.click();

        clickOTP.sendKeys(userInput);
        
        By clickHome = By.cssSelector("a[data-automation='company logo']");
        WebElement homepage = wait.until(ExpectedConditions.visibilityOfElementLocated(clickHome));
        homepage.click();
    }
}


