package com.anz.greenHouse.Service;

import com.anz.greenHouse.Model.UserInfo;

public interface UserServices
{
    UserInfo getUser(String userName,String password);
}
