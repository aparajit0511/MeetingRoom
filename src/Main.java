import meetingroomreservation.MeetingRoom;
import meetingroomreservation.Reservation;
import meetingroomreservation.Room;
import meetingroomreservation.User;

import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        MeetingRoom meetingRoom = new MeetingRoom();

        Room room = new Room("Ganga",10);
        meetingRoom.addRoom(room);
        Room room1 = new Room("Newton",5);
        meetingRoom.addRoom(room1);

        Reservation reservation = new Reservation(room,null, LocalTime.of(9,0),LocalTime.of(18,30));
        Reservation reservation1 = new Reservation(room1,null, LocalTime.of(9,0),LocalTime.of(18,30));

        meetingRoom.addReservationList(reservation);
        meetingRoom.addReservationList(reservation1);

        User user = new User("Aparajit");

//        String reservationID = meetingRoom.searchAvailableRoom(LocalTime.of(10,0),LocalTime.of(10,30));
//        meetingRoom.bookReservation(reservationID,LocalTime.of(10,0),LocalTime.of(10,30),user);
//
//        meetingRoom.cancelReservation(reservationID);

        String availabilityID = meetingRoom.searchAvailableRoom(
                LocalTime.of(10, 0),
                LocalTime.of(10, 30));

        String bookingID = meetingRoom.bookReservation(
                availabilityID,
                LocalTime.of(10, 0),
                LocalTime.of(10, 30),
                user);

        meetingRoom.cancelReservation(bookingID);

    }
}