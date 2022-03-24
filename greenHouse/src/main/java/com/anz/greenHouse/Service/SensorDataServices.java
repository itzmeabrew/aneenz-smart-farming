package com.anz.greenHouse.Service;

import com.anz.greenHouse.Model.SensorData;

import java.util.List;

public interface SensorDataServices
{
    SensorData updateData(SensorData data);
    List<SensorData> getSensorData();
}
