package com.example.tripease.Transformers;

import com.example.tripease.Model.Driver;
import com.example.tripease.dto.Response.DriverResponse;
import com.example.tripease.dto.request.DriverRequest;

public class DriverTransformer {
    public static Driver DriverRequestToDriver(DriverRequest driverRequest){
        Driver driver = Driver.builder()
                .name(driverRequest.getName())
                .age(driverRequest.getAge())
                .emailId(driverRequest.getEmailId())
                .build();

           return driver;
    }
   public  static DriverResponse DriverToDriverResponse(Driver driver){
        return DriverResponse.builder()
                .driverId(driver.getDriverId())
               .name(driver.getName())
               .age(driver.getAge())
               .emailId(driver.getEmailId())
               .build();

   }
}
