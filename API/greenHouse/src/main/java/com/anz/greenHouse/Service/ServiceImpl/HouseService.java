package com.anz.greenHouse.Service.ServiceImpl;

import com.anz.greenHouse.Model.HouseInfo;
import com.anz.greenHouse.Repository.HouseInfoRepo;
import com.anz.greenHouse.Service.HouseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HouseService implements HouseServices
{
    @Autowired
    HouseInfoRepo hsRepo;

    @Override
    public HouseInfo createHouse(HouseInfo newHouse)
    {
        HouseInfo newHs = hsRepo.save(newHouse);
        return newHs;
    }
}
