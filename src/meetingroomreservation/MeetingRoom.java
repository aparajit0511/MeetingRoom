package meetingroomreservation;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MeetingRoom {

    private ArrayList<Room> roomList = new ArrayList<>();
    private HashMap<String,ArrayList<Reservation>> userReservation = new HashMap<>();
    private  HashMap<String,ArrayList<Reservation>> roomReservation = new HashMap<>();

    private ArrayList<Reservation> reservationArrayList = new ArrayList<>();



    public MeetingRoom(){
    }

    public String searchAvailableRoom(LocalTime startTime, LocalTime endTime) {

        for (Reservation availability : reservationArrayList) {

            // This represents the room's normal available window
            if (availability.getUser() == null) {

                // Requested time must fit inside the room's availability window
                if (startTime.isBefore(availability.getStartTime())
                        || endTime.isAfter(availability.getEndTime())) {
                    continue;
                }

                boolean roomOccupied = false;

                // Check whether this particular room has a conflicting booking
                for (Reservation booking : reservationArrayList) {

                    if (booking.getUser() != null
                            && booking.getRoom().getRoomId()
                            .equals(availability.getRoom().getRoomId())) {

                        if (startTime.isBefore(booking.getEndTime())
                                && endTime.isAfter(booking.getStartTime())) {

                            roomOccupied = true;
                            break;
                        }
                    }
                }

                // No conflicting booking → this room is available
                if (!roomOccupied) {
                    return availability.getReservationId();
                }
            }
        }

        return null;
    }

    public String bookReservation(String reservationId, LocalTime startTime, LocalTime endTime, User user) {

        Reservation newReservation = null;
        Room room = null;

        for (int i = 0; i < reservationArrayList.size(); i++) {

            if (Objects.equals(
                    reservationArrayList.get(i).getReservationId(),
                    reservationId)) {

                room = reservationArrayList.get(i).getRoom();

                newReservation =
                        new Reservation(room, user, startTime, endTime);

                break;
            }
        }

        if (room == null || newReservation == null) {
            return null;
        }

        reservationArrayList.add(newReservation);

        roomReservation
                .computeIfAbsent(
                        room.getRoomName(),
                        k -> new ArrayList<>())
                .add(newReservation);

        userReservation
                .computeIfAbsent(
                        user.getUserName(),
                        k -> new ArrayList<>())
                .add(newReservation);

        return newReservation.getReservationId();
    }

    public void cancelReservation(String reservationId){

        Reservation reservationToRemove = null;
        for (Reservation reservation: reservationArrayList){
            if(reservation.getReservationId().equals(reservationId)){
                reservationToRemove = reservation;
                break;
            }
        }

        if(reservationToRemove == null){
            return;
        }

        reservationArrayList.remove(reservationToRemove); // this takes O(n) time

        String roomName = reservationToRemove.getRoom().getRoomName();
        roomReservation.get(roomName).remove(reservationToRemove);

        String userName = reservationToRemove.getUser().getUserName();
        userReservation.get(userName).remove(reservationToRemove);
    }

    public void viewReservationByRoom(String roomName) {

        ArrayList<Reservation> reservations = roomReservation.get(roomName);

        if (reservations != null) {
            for (Reservation reservation : reservations) {
                System.out.println(reservation.getReservationId());
            }
        }
    }

    public void viewReservationByUser(String userName){
        ArrayList<Reservation> reservations = userReservation.get(userName);

        if (reservations != null) {
            for (Reservation reservation : reservations) {
                System.out.println(reservation.getReservationId());
            }
        }

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
