import meetingroomreservation.MeetingRoom;
import meetingroomreservation.Reservation;
import meetingroomreservation.Room;
import meetingroomreservation.User;

import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");


        Room room = new Room("Ganga",10);
        Room room1 = new Room("Newton",5);

        System.out.println("Give me all rooms->" + room.getRoomList());

        User user = new User("Aparajit");

        Reservation reservation = new Reservation(room,user, LocalTime.of(10,0),LocalTime.of(10,30));
        Reservation reservation1 = new Reservation(room1,null, LocalTime.of(12,0),LocalTime.of(12,30));

        MeetingRoom meetingRoom = new MeetingRoom(reservation);

    }
}