package meetingroomreservation;

import java.time.LocalTime;
import java.util.UUID;

public class Reservation {
    private String reservationId;
    public Room room;

    public User user;
    private LocalTime startTime = LocalTime.of(9, 0);
    private LocalTime endTime = LocalTime.of(9, 30);

    public Reservation(Room room, User user, LocalTime startTime, LocalTime endTime) {
        this.reservationId = UUID.randomUUID().toString();;
        this.room = room;
        this.user = user;
        this.startTime = LocalTime.of(9, 0);
        this.endTime = LocalTime.of(9, 30);
    }

    public String getReservationId() {
        return reservationId;
    }


    public LocalTime getStartTime() {
        return startTime;
    }


    public LocalTime getEndTime() {
        return endTime;
    }

}
