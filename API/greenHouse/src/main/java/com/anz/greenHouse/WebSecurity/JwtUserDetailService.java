package com.anz.greenHouse.WebSecurity;

import com.anz.greenHouse.Model.UserInfo;
import com.anz.greenHouse.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class JwtUserDetailService implements UserDetailsService
{
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder bcryptEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        UserInfo auth = userRepo.getByUserName(username);
        if (auth == null)
        {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        else
        {
            //auth.setLastActive(new Date());
            userRepo.setLoggedIn(auth.getId(),new Date());
            return new User(auth.getUserName(), auth.getPassword(), new ArrayList<>());
        }
    }

    public UserInfo saveUser(String username,String password)
    {
        //System.out.println(user.isActive());
        UserInfo user = new UserInfo();
        user.setUserName(username);
        user.setPassword(bcryptEncoder.encode(password));
        user.setActive(true);
        user.setLastActive(new Date());

        UserInfo newUser= userRepo.save(user);
        return  newUser;
    }

    public void disableUser(Boolean status,int id)
    {
        userRepo.setActive(status,id);
    }
}
