package in.scaler.bookmyshow.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookingRequestDTO {
    private Long userId;
    private Long showId;
    private List<Long> showSeatIds;

}
