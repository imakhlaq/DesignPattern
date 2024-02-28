import java.time.LocalDateTime;

public interface IBookingService {
    Long createBooking(Long userId, Long movie, LocalDateTime showTime, Integer noOfSeats);
}
