package meetingroomreservation;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;

public class MeetingRoom {
//    public ArrayList<Reservation> reservationList = new ArrayList<>();
    public HashMap<String,ArrayList<Reservation>> userReservation = new HashMap<>();
    public HashMap<String,ArrayList<Reservation>> roomReservation = new HashMap<>();
//    private HashMap<String,Reservation> reservationHashMap = new HashMap<>();


    public MeetingRoom(Reservation reservation){
        roomReservation.put(reservation.room.getRoomId(),new ArrayList<>());
        roomReservation.get(reservation.room.getRoomId()).add(reservation);


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
