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

    public Job(String title, String companyName, String location, String salary, String description, String datePosted, String jobLink)
    {
        this.title = title;
        this.companyName = companyName;
        this.location = location;
        this.salary = salary;
        this.description = description;
        this.datePosted = datePosted;
        this.jobLink = jobLink;
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
}
