package com.example.tripease.Transformers;

import com.example.tripease.Model.Cab;
import com.example.tripease.Model.Driver;
import com.example.tripease.dto.Response.CabResponse;
import com.example.tripease.dto.request.CabRequest;

public class CabTransformer {
    public  static Cab CabRequestToCab(CabRequest cabRequest){
        return Cab.builder()
                .cabNumber(cabRequest.getCabNumber())
                .cabModel(cabRequest.getCabModel())
                .perKmRate(cabRequest.getPerKmRate())
                .avialable(true)
                .build();
    }
    public static CabResponse CabToCabResponse(Cab cab, Driver driver){
        return CabResponse.builder()
                .cabNumber(cab.getCabNumber())
                .cabModel(cab.getCabModel())
                .perKmRate(cab.getPerKmRate())
                .avialable(cab.isAvialable())
                .driver(DriverTransformer.DriverToDriverResponse(driver))
                .build();

    }
}
