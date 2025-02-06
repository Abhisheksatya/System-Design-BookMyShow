package in.scaler.bookmyshow.controllers;

import in.scaler.bookmyshow.dtos.CreateBookingRequestDTO;
import in.scaler.bookmyshow.dtos.CreateBookingResponseDTO;
import in.scaler.bookmyshow.dtos.ResponseStatus;
import in.scaler.bookmyshow.services.BookingService;
import in.scaler.bookmyshow.models.Booking;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {
    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public CreateBookingResponseDTO createBooking(CreateBookingRequestDTO requestDto) {
        CreateBookingResponseDTO responseDto = new CreateBookingResponseDTO();

        try {
            Booking booking = bookingService.createBooking(requestDto.getUserId(),
                    requestDto.getShowSeatIds(),
                    requestDto.getShowId());

            responseDto.setBookingId(booking.getId());
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception e) {
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }

        return responseDto;
    }
}
