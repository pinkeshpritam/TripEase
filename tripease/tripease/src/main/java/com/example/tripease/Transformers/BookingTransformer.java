package com.example.tripease.Transformers;

import com.example.tripease.Enum.TripStatus;
import com.example.tripease.Model.Booking;
import com.example.tripease.Model.Cab;
import com.example.tripease.Model.Customer;
import com.example.tripease.Model.Driver;
import com.example.tripease.dto.Response.BookingResponse;
import com.example.tripease.dto.request.BookingRequest;
import org.jspecify.annotations.NonNull;

public class BookingTransformer {

    public static Booking BookingRequestToBooking(BookingRequest bookingRequest ,double perKmRate) {
      return Booking.builder()
              .pickup(bookingRequest.getPickup())
              .destination(bookingRequest.getDestination())
              .tripDistance(bookingRequest.getTripDistance())
              .tripStatus(TripStatus.ONGOING)
              .tripAmount(bookingRequest.getTripDistance()*perKmRate)
              .build();
    }
    public static BookingResponse bookingToBookingResponse( Booking booking, Customer customer, Cab cab, Driver driver) {
        return BookingResponse.builder()
                .pickup(booking.getPickup())
                .destination(booking.getDestination())
                .tripDistance(booking.getTripDistance())
                .tripStatus(booking.getTripStatus())
                .tripAmount(booking.getTripAmount())
                .bookedAt(booking.getBookedAt())
                .lastUpdateAt(booking.getLastUpdateAt())
                .customer(CustomerTransformer.customerToCustomerRespone(customer))
                .cab(CabTransformer.CabToCabResponse(cab,driver))
                .build();
    }
}
