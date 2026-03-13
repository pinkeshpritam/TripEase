package com.example.tripease.Service;

import com.example.tripease.Model.Driver;
import com.example.tripease.Repository.DriverRepository;
import com.example.tripease.Transformers.DriverTransformer;
import com.example.tripease.dto.Response.DriverResponse;
import com.example.tripease.dto.request.DriverRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service


public class DriverService {
    @Autowired
    DriverRepository driverRepository;
    public DriverResponse addDriver(DriverRequest driverRequest) {
        //dto to entity
        Driver driver= DriverTransformer.DriverRequestToDriver(driverRequest);
        //save Driver
        Driver saveDiver= driverRepository.save(driver);
        //entity to dto

        return DriverTransformer.DriverToDriverResponse(saveDiver);

    }
}
