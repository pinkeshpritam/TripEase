package com.example.tripease.Controller;

import com.example.tripease.Service.CabService;
import com.example.tripease.Service.DriverService;
import com.example.tripease.dto.Response.CabResponse;
import com.example.tripease.dto.request.CabRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cab")


public class CabController {
    @Autowired
    CabService cabService;
    @PostMapping("/register/driver/{driverid}")
    public CabResponse registerCab(@RequestBody CabRequest cabRequest,
    @PathVariable("driverid")  int driverId)
    {
      return   cabService.registerCab(cabRequest,driverId);

    }
}
