package com.anz.greenHouse.Controller;

import com.anz.greenHouse.Model.HouseInfo;
import com.anz.greenHouse.Service.HouseServices;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/house")
public class HouseController
{
    @Autowired
    HouseServices houseServices;

    @PostMapping("/create")
    private ResponseEntity<HouseInfo> newHouse(@RequestBody Map<String,String> payload)
    {
        final String hsname = payload.get("house_name");
        final Integer owner = Integer.valueOf(payload.get("owner"));
        final String location = payload.get("location");

        HouseInfo info = new HouseInfo(hsname,owner,location);
        HouseInfo newHouse = houseServices.createHouse(info);
        return ResponseEntity.ok(newHouse);
    }
}
