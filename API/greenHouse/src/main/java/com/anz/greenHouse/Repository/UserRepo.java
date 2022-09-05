package com.anz.greenHouse.Repository;

import com.anz.greenHouse.Model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Repository
public interface UserRepo extends JpaRepository<UserInfo,Integer>
{
    UserInfo getByUserNameAndPassword(String userName,String password);
    UserInfo getByUserName(String username);

    @Modifying
    @Transactional
    @Query(value = "UPDATE user_info SET  active = ?1 WHERE  user_info.id = ?2", nativeQuery = true)
    void setActive(Boolean status,int id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE user_info SET  last_active = ?2 WHERE  user_info.id = ?1", nativeQuery = true)
    void setLoggedIn(int id, Date date);
    //void findU
}
