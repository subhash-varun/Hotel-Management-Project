package com.varun.AmayHotels.service.interfac;

import com.varun.AmayHotels.dto.Response;
import com.varun.AmayHotels.entity.Booking;

public interface IBookingService {

    Response saveBooking(Long roomId, Long userId, Booking bookingRequest);

    Response findBookingByConfirmationCode(String confirmationCode);

    Response getAllBookings();

    Response cancelBooking(Long bookingId);

}
