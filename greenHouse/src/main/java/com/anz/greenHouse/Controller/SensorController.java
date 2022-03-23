package com.anz.greenHouse.Controller;

import com.anz.greenHouse.Model.SensorData;
import com.anz.greenHouse.Service.ServiceImpl.SensorDataService;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/sensor")
public class SensorController
{
    @Autowired
    SensorDataService sns;

    JSONParser parser = new JSONParser();

    @PostMapping("/update")
    private ResponseEntity<JSONObject> sendToServer(@RequestBody Map<String,String> payload) throws ParseException
    {
        Date date = new Date();
        System.out.println(payload);

        //sns.updateData();
        SensorData newData = new SensorData(Integer.parseInt(payload.get("gid")),Float.parseFloat(payload.get("air_temp")),Float.parseFloat(payload.get("soil_moisture")),
                                            Float.parseFloat(payload.get("humidity")),Float.parseFloat(payload.get("soil_temp")),Float.parseFloat(payload.get("water_temp")),
                                            Float.parseFloat(payload.get("barometric_pressure")),Boolean.parseBoolean(payload.get("valve")),Integer.parseInt(payload.get("water_flow")),date,new Date(payload.get("device_time")));

        SensorData sts = sns.updateData(newData);
        if(sts != null)
        {
            JSONObject json = (JSONObject) parser.parse("{'status':'Updated at " + date.toLocaleString()+"'}");
            return ResponseEntity.ok(json);
        }
        else
        {
            JSONObject json = (JSONObject) parser.parse("{'status':'Error updating'}");
            return ResponseEntity.badRequest().body(json);
        }
    }
}
