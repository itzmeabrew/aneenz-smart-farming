package com.anz.greenHouse.Controller;

import com.anz.greenHouse.Model.SensorData;
import com.anz.greenHouse.Service.ServiceImpl.SensorDataService;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/sensor")
public class SensorController
{
    @Autowired
    SensorDataService sns;

    JSONParser parser = new JSONParser();

    @GetMapping()
    private ResponseEntity<List<SensorData>> retriveData()
    {
        List<SensorData> retrivedData = sns.getSensorData();
        return ResponseEntity.ok(retrivedData);
    }

    @PostMapping("/update")
    private ResponseEntity<JSONObject> updateData(@RequestBody Map<String,String> payload) throws ParseException, java.text.ParseException
    {
        System.out.println(payload);

        Date date = new Date();
        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        Date deviceDate = formatter.parse(payload.get("device_time"));

        //sns.updateData();
        SensorData newData = new SensorData(Integer.parseInt(payload.get("gid")),Float.parseFloat(payload.get("air_temp")),Float.parseFloat(payload.get("soil_moisture")),
                                            Float.parseFloat(payload.get("humidity")),Float.parseFloat(payload.get("soil_temp")),Float.parseFloat(payload.get("water_temp")),
                                            Float.parseFloat(payload.get("barometric_pressure")),Boolean.parseBoolean(payload.get("valve")),Integer.parseInt(payload.get("water_flow")),date,deviceDate);

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
