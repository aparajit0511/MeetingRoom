import meetingroomreservation.Reservation;
import meetingroomreservation.Room;
import meetingroomreservation.User;

import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");


        Room room = new Room("Ganga",10);

        User user = new User("Aparajit");

        Reservation reservation = new Reservation(room,user, LocalTime.of(10,0),LocalTime.of(10,30));


    }
}