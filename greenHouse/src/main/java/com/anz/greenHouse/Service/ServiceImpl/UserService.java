package com.anz.greenHouse.Service.ServiceImpl;

import com.anz.greenHouse.Model.UserInfo;
import com.anz.greenHouse.Repository.UserRepo;
import com.anz.greenHouse.Service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServices
{
    @Autowired
    UserRepo userRepo;

    @Override
    public UserInfo getUser(String userName, String password) throws UsernameNotFoundException
    {
        UserInfo user = userRepo.getByUserNameAndPassword(userName,password);
        return user;
    }
}
