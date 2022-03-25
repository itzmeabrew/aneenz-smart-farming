package com.anz.greenHouse.Repository;

import com.anz.greenHouse.Model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserInfo,Integer>
{
    UserInfo getByUserNameAndPassword(String userName,String password);
    UserInfo getByUserName(String username);
}
