package com.anz.greenHouse.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
//@Table(name = "SensorData")
public class SensorData
{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer Id;

    private Integer greenHouseId;
    private Float airTemprature;
    private Float soilMoisture;
    private Float humidity;
    private Float soilTemprature;
    private Float waterTemprature;
    private Float barometricPressure;
    private Boolean valveStatus;
    private Integer waterFlow;
    private Date serverTime;
    private Date deviceTime;

    public SensorData(Integer greenHouseId, Float airTemprature, Float soilMoisture, Float humidity, Float soilTemprature, Float waterTemprature, Float barometricPressure, Boolean valveStatus, Integer waterFlow)
    {
        this.greenHouseId = greenHouseId;
        this.airTemprature = airTemprature;
        this.soilMoisture = soilMoisture;
        this.humidity = humidity;
        this.soilTemprature = soilTemprature;
        this.waterTemprature = waterTemprature;
        this.barometricPressure = barometricPressure;
        this.valveStatus = valveStatus;
        this.waterFlow = waterFlow;
    }

    public SensorData(Integer greenHouseId, Float airTemprature, Float soilMoisture, Float humidity, Float soilTemprature, Float waterTemprature, Float barometricPressure, Boolean valveStatus, Integer waterFlow, Date serverTime)
    {
        this.greenHouseId = greenHouseId;
        this.airTemprature = airTemprature;
        this.soilMoisture = soilMoisture;
        this.humidity = humidity;
        this.soilTemprature = soilTemprature;
        this.waterTemprature = waterTemprature;
        this.barometricPressure = barometricPressure;
        this.valveStatus = valveStatus;
        this.waterFlow = waterFlow;
        this.serverTime = serverTime;
    }

    public SensorData(Integer greenHouseId, Float airTemprature, Float soilMoisture, Float humidity, Float soilTemprature, Float waterTemprature, Float barometricPressure, Boolean valveStatus, Integer waterFlow, Date serverTime, Date deviceTime)
    {
        this.greenHouseId = greenHouseId;
        this.airTemprature = airTemprature;
        this.soilMoisture = soilMoisture;
        this.humidity = humidity;
        this.soilTemprature = soilTemprature;
        this.waterTemprature = waterTemprature;
        this.barometricPressure = barometricPressure;
        this.valveStatus = valveStatus;
        this.waterFlow = waterFlow;
        this.serverTime = serverTime;
        this.deviceTime = deviceTime;
    }

    public Integer getId()
    {
        return Id;
    }

    public void setId(Integer id)
    {
        Id = id;
    }

    public Integer getGreenHouseId()
    {
        return greenHouseId;
    }

    public void setGreenHouseId(Integer greenHouseId)
    {
        this.greenHouseId = greenHouseId;
    }

    public Float getAirTemprature()
    {
        return airTemprature;
    }

    public void setAirTemprature(Float airTemprature)
    {
        this.airTemprature = airTemprature;
    }

    public Float getSoilMoisture()
    {
        return soilMoisture;
    }

    public void setSoilMoisture(Float soilMoisture)
    {
        this.soilMoisture = soilMoisture;
    }

    public Float getHumidity()
    {
        return humidity;
    }

    public void setHumidity(Float humidity)
    {
        this.humidity = humidity;
    }

    public Float getSoilTemprature()
    {
        return soilTemprature;
    }

    public void setSoilTemprature(Float soilTemprature)
    {
        this.soilTemprature = soilTemprature;
    }

    public Float getWaterTemprature()
    {
        return waterTemprature;
    }

    public void setWaterTemprature(Float waterTemprature)
    {
        this.waterTemprature = waterTemprature;
    }

    public Float getBarometricPressure()
    {
        return barometricPressure;
    }

    public void setBarometricPressure(Float barometricPressure)
    {
        this.barometricPressure = barometricPressure;
    }

    public Boolean getValveStatus()
    {
        return valveStatus;
    }

    public void setValveStatus(Boolean valveStatus)
    {
        this.valveStatus = valveStatus;
    }

    public Integer getWaterFlow()
    {
        return waterFlow;
    }

    public void setWaterFlow(Integer waterFlow)
    {
        this.waterFlow = waterFlow;
    }

    public Date getServerTime()
    {
        return serverTime;
    }

    public void setServerTime(Date serverTime)
    {
        this.serverTime = serverTime;
    }

    public Date getDeviceTime()
    {
        return deviceTime;
    }

    public void setDeviceTime(Date deviceTime)
    {
        this.deviceTime = deviceTime;
    }
}
