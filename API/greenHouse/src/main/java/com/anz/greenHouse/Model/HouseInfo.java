package com.anz.greenHouse.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HouseInfo
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String houseName;
    private Integer owner;
    private String location;

    public HouseInfo() { }

    public HouseInfo(String houseName, Integer owner, String location)
    {
        this.houseName = houseName;
        this.owner = owner;
        this.location = location;
    }

    public String getHouseName()
    {
        return houseName;
    }

    public void setHouseName(String houseName)
    {
        this.houseName = houseName;
    }

    public Integer getOwner()
    {
        return owner;
    }

    public void setOwner(Integer owner)
    {
        this.owner = owner;
    }

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }
}
