package com.anz.greenHouse.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class UserInfo
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String userName;
    private String password;
    private Boolean active;
    private Date lastActive;

    public UserInfo(String userName, String password, boolean active)
    {
        this.userName = userName;
        this.password = password;
        this.active = active;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public boolean isActive()
    {
        return active;
    }

    public void setActive(boolean active)
    {
        this.active = active;
    }

    public Date getLastActive()
    {
        return lastActive;
    }

    public void setLastActive(Date lastActive)
    {
        this.lastActive = lastActive;
    }
}
