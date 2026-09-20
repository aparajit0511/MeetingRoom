package meetingroomreservation;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.UUID;

public class Reservation {
    private String reservationId;
    public Room room;

    public User user;
    private LocalTime startTime;
    private LocalTime endTime;

    private ArrayList<Reservation> reservationList = new ArrayList<>();

    public Reservation(Room room, User user, LocalTime startTime, LocalTime endTime) {
        this.reservationId = UUID.randomUUID().toString();;
        this.room = room;
        this.user = user;
        this.startTime = startTime;
        this.endTime = endTime;

        reservationList.add(this);
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

    public ArrayList getReservationList(){
        return this.reservationList;
    }

}
