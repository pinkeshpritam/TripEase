package com.example.tripease.Service;

import com.example.tripease.Exception.BookingNotFoundException;
import com.example.tripease.Exception.CabUnavialableException;
import com.example.tripease.Model.Booking;
import com.example.tripease.Model.Cab;
import com.example.tripease.Model.Customer;
import com.example.tripease.Model.Driver;
import com.example.tripease.Repository.BookingRepository;
import com.example.tripease.Repository.CabRepository;
import com.example.tripease.Repository.CustomerRepository;
import com.example.tripease.Repository.DriverRepository;
import com.example.tripease.Transformers.BookingTransformer;
import com.example.tripease.dto.Response.BookingResponse;
import com.example.tripease.dto.request.BookingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service

public class BookingService {
    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    DriverRepository driverRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CabRepository cabRepository;
    @Autowired
    JavaMailSender javaMailSender;

    public BookingResponse bookCab(BookingRequest bookingRequest, int customerId) {
        Optional<Customer> customerOptional =customerRepository.findById(customerId);
        if(customerOptional.isEmpty()){
            throw  new BookingNotFoundException("Booking Not found");
        }
        Customer customer = customerOptional.get();
        Cab cabAvialable=cabRepository.getAvialableCabRandomly();
        if(cabAvialable==null){
            throw  new CabUnavialableException("Sorry cab is Not avialable");
        }
        Booking booking = BookingTransformer.BookingRequestToBooking(bookingRequest, cabAvialable.getPerKmRate());
        Booking savedBooking=bookingRepository.save(booking);

        cabAvialable.setAvialable(false);
        customer.getBookings().add(savedBooking);
        Driver driver=driverRepository.getDriverByCabId(cabAvialable.getCabId());
        driver.getBookings().add(savedBooking);

        Customer saveCustomer=customerRepository.save(customer);
        Driver saveDriver=driverRepository.save(driver);

        sendMail(saveCustomer);

        return BookingTransformer.bookingToBookingResponse(savedBooking,saveCustomer,cabAvialable,saveDriver);

    }
    private void sendMail(Customer customer) {
        String text="Congrats!! "+customer.getName()+" .Your booking has been saved!";
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(customer.getEmailId());
        mailMessage.setFrom("babatillu99059@gmail.com");
        mailMessage.setSubject("Your booking has been saved");
        mailMessage.setText(text);
        javaMailSender.send(mailMessage);
    }
}
