package com.aimandannn.jobscraper;

public class Job 
{
    private String title;
    private String companyName;
    private String location;
    private String salary;
    private String description;
    private String datePosted;
    private String jobLink;
    private String quickApply;

    public Job(String title, String companyName, String location, String salary, String description, String datePosted, String jobLink, String quickApply)
    {
        this.title = title;
        this.companyName = companyName;
        this.location = location;
        this.salary = salary;
        this.description = description;
        this.datePosted = datePosted;
        this.jobLink = jobLink;
        this.quickApply = quickApply;
    }

    public String getTitle()
    {
        return title;
    }

    public String getCompanyName()
    {
        return companyName;
    }

    public String getLocation()
    {
        return location;
    }

    public String getSalary()
    {
        return salary;
    }

    public String getDescription()
    {
        return description;
    }

    public String getDatePosted()
    {
        return datePosted;
    }

    public String getJobLink()
    {
        return jobLink;
    }

    public String getQuickApply()
    {
        return quickApply;
    }
}
