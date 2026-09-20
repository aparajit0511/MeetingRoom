package meetingroomreservation;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;

public class MeetingRoom {
    public ArrayList<Reservation> reservationList = new ArrayList<>();
    private HashMap<String,Reservation> reservationHashMap = new HashMap<>();
    private Integer totalRooms;

    public Reservation reservation;

    public MeetingRoom(int totalRooms){
        this.totalRooms = totalRooms;
        for (int i =1;i<= totalRooms; i++){
            reservationList.add(reservation);
        }

//        reservationHashMap.put()
    }

    public String searchAvailableRoom(LocalTime startTime,LocalTime endTime){

//        for(int i=0;i<totalRooms;i++){
//            if (startTime >= reservationList.get(i).getStartTime() && )
//        }

        return null;
    }

    public void bookReservation(String reservationId,LocalTime startTime,LocalTime endTime){


    }

    public void cancelReservation(String reservationId){

    }

    public void viewReservation(String userId){

    }
}
