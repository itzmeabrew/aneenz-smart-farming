package com.anz.greenHouse.Service.ServiceImpl;

import com.anz.greenHouse.Repository.SensorDataRepo;
import com.anz.greenHouse.Service.SensorDataServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SensorDataService implements SensorDataServices
{
    @Autowired
    SensorDataRepo sensorRepo;
}
