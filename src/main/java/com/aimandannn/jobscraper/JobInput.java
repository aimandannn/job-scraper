package com.aimandannn.jobscraper;


import javax.swing.JOptionPane;
import org.openqa.selenium.WebDriver;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JobInput 
{

    public String input_job(WebDriver driver) throws InterruptedException
    {
        
        Timer timer = new Timer(10000, new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                // This code runs when the 10-second timer expires.
                System.out.println("Time is up! Closing the window.");

                // Step 2: Close the pop-up window.
                JOptionPane.getRootFrame().dispose();
            }
        });

        timer.setRepeats(false);
        timer.start();

        // Show the JOptionPane pop-up.
        String userInput = JOptionPane.showInputDialog(null, "Please Enter the Job Title: ");
        
        // This line only runs after the window has closed.
        timer.stop(); // Stop the timer if the user entered a value early.

        if (userInput == null || userInput.trim().isEmpty()) 
        {
            // userInput = "Software QA Engineer";
            userInput = "bunga";
        } 

        return userInput;
    }
}
