package com.anz.greenHouse.Repository;

import com.anz.greenHouse.Model.HouseInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseInfoRepo extends JpaRepository<HouseInfo,Integer>
{
}
