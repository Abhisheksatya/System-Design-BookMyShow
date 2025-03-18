package in.scaler.bookmyshow.controllers;

import in.scaler.bookmyshow.dtos.BookingRequestDTO;
import in.scaler.bookmyshow.dtos.BookingResponseDTO;
import in.scaler.bookmyshow.dtos.ResponseStatus;
import in.scaler.bookmyshow.services.BookingService;
import in.scaler.bookmyshow.models.Booking;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/booking")
public class BookingController {
    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public BookingResponseDTO createBooking(BookingRequestDTO requestDto) {
        BookingResponseDTO responseDto = new BookingResponseDTO();

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
