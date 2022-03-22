package com.anz.greenHouse.Repository;

import com.anz.greenHouse.Model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserInfo,Integer>
{
    UserInfo getByUserNameAndPassword(String userName,String password);
}
