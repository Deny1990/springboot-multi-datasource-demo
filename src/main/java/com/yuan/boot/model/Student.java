package com.yuan.boot.model;

/**
 * Created by yuanxin on 17/5/2.
 */
public class Student
{

    private Long id;

    private String name;

    private String address;

    private int age;

    private String sumScore;

    private String avgScore;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String getSumScore()
    {
        return sumScore;
    }

    public void setSumScore(String sumScore)
    {
        this.sumScore = sumScore;
    }

    public String getAvgScore()
    {
        return avgScore;
    }

    public void setAvgScore(String avgScore)
    {
        this.avgScore = avgScore;
    }
}
