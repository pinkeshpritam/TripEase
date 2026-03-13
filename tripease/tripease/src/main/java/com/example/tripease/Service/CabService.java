package com.example.tripease.Service;

import com.example.tripease.Exception.DriverNotFoundException;
import com.example.tripease.Model.Cab;
import com.example.tripease.Model.Driver;
import com.example.tripease.Repository.CabRepository;
import com.example.tripease.Repository.DriverRepository;
import com.example.tripease.Transformers.CabTransformer;
import com.example.tripease.dto.Response.CabResponse;
import com.example.tripease.dto.request.CabRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class CabService {
    @Autowired
   DriverRepository driverRepository;

    public CabResponse registerCab(CabRequest cabRequest, int driverId) {
        Optional<Driver> optionalDriver =driverRepository.findById(driverId);
        if(optionalDriver.isEmpty()){
            throw new DriverNotFoundException("Driver not found");
        }
        Driver driver = optionalDriver.get();
        Cab cab = CabTransformer.CabRequestToCab(cabRequest);

        driver.setCab(cab);//v.v imoptent
        //save both driver and cab
        Driver driverSaved = driverRepository.save(driver);
        return CabTransformer.CabToCabResponse(driverSaved.getCab(),driverSaved);
    }
}
