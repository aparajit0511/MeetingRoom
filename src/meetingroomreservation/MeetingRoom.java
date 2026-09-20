package meetingroomreservation;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class MeetingRoom {

    private ArrayList<Room> roomList = new ArrayList<>();
    private HashMap<String,ArrayList<Reservation>> userReservation = new HashMap<>();
    private  HashMap<String,ArrayList<Reservation>> roomReservation = new HashMap<>();

    private ArrayList<Reservation> reservationArrayList = new ArrayList<>();



    public MeetingRoom(){
//        roomReservation.put(reservation.room.getRoomId(),new ArrayList<>());
//        roomReservation.get(reservation.room.getRoomId()).add(reservation);


//        reservationHashMap.put()
    }

    public String searchAvailableRoom(LocalTime startTime,LocalTime endTime){

        for (int i =0 ;i< reservationArrayList.size();i++){
            if(reservationArrayList.get(i).user == null) // no user name , room is availbale all day
            {
             return reservationArrayList.get(i).getReservationId();
            }else if (reservationArrayList.get(i).user != null && startTime.isAfter(reservationArrayList.get(i).getStartTime()) && endTime.isBefore(reservationArrayList.get(i).getEndTime())){
                return reservationArrayList.get(i).getReservationId();
            }
        }

        return null;
    }

    public void bookReservation(String reservationId,LocalTime startTime,LocalTime endTime,User user){
        Reservation newReservation = null;
        Room room = null;
        String roomId= "";
        String userId = user.getUserId();
        for (int i =0 ;i< reservationArrayList.size();i++){
            if(Objects.equals(reservationArrayList.get(i).getReservationId(), reservationId)){
                 room = reservationArrayList.get(i).room;
                 roomId = reservationArrayList.get(i).room.getRoomId();
                newReservation = new Reservation(room, user, startTime,endTime);
            }
        }
        reservationArrayList.add(newReservation);
        roomReservation.put(roomId,new ArrayList<>());
        roomReservation.get(roomId).add(newReservation);

        userReservation.put(userId,new ArrayList<>());
        userReservation.get(userId).add(newReservation);

    }

    public void cancelReservation(String reservationId){
        for (int i =0 ;i< reservationArrayList.size();i++){
            if(Objects.equals(reservationArrayList.get(i).getReservationId(), reservationId)){
//                room = reservationArrayList.get(i).room;
//                roomId = reservationArrayList.get(i).room.getRoomId();
//                newReservation = new Reservation(room, user, startTime,endTime);

            }
        }

    }

    public void viewReservationByRoom(String roomName){


    }

    public void viewReservationByUser(String userName){

    }

    public ArrayList getRoomList(){
        return roomList;
    }

    public void addRoom(Room room){
        roomList.add(room);
    }

    public void addReservationList(Reservation reservation){
        reservationArrayList.add(reservation);
    }
}
