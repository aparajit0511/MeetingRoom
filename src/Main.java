/*
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

 */

import meetingroomreservation.MeetingRoom;
import meetingroomreservation.Reservation;
import meetingroomreservation.Room;
import meetingroomreservation.User;

import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {

        testBasicBooking();
        testCancellation();
        testSameUserMultipleRooms();
        testTwoUsersSameRoomDifferentTimes();
        testOverlappingBooking();
        testBackToBackBooking();
        testInvalidCancellation();

    }

    private static MeetingRoom createSystem() {

        MeetingRoom meetingRoom = new MeetingRoom();

        Room room1 = new Room("Ganga", 10);
        Room room2 = new Room("Newton", 5);

        meetingRoom.addRoom(room1);
        meetingRoom.addRoom(room2);

        // Normal working-hour availability
        Reservation availability1 =
                new Reservation(
                        room1,
                        null,
                        LocalTime.of(9, 0),
                        LocalTime.of(18, 30)
                );

        Reservation availability2 =
                new Reservation(
                        room2,
                        null,
                        LocalTime.of(9, 0),
                        LocalTime.of(18, 30)
                );

        meetingRoom.addReservationList(availability1);
        meetingRoom.addReservationList(availability2);

        return meetingRoom;
    }

    // TEST 1
    private static void testBasicBooking() {

        MeetingRoom meetingRoom = createSystem();

        User user = new User("Aparajit");

        String availabilityId =
                meetingRoom.searchAvailableRoom(
                        LocalTime.of(10, 0),
                        LocalTime.of(10, 30)
                );

        String bookingId =
                meetingRoom.bookReservation(
                        availabilityId,
                        LocalTime.of(10, 0),
                        LocalTime.of(10, 30),
                        user
                );

        if (availabilityId != null && bookingId != null) {
            System.out.println("TEST 1 - Basic Booking: PASS");
        } else {
            System.out.println("TEST 1 - Basic Booking: FAIL");
        }
    }

    // TEST 2
    private static void testCancellation() {

        MeetingRoom meetingRoom = createSystem();

        User user = new User("Aparajit");

        String availabilityId =
                meetingRoom.searchAvailableRoom(
                        LocalTime.of(10, 0),
                        LocalTime.of(10, 30)
                );

        String bookingId =
                meetingRoom.bookReservation(
                        availabilityId,
                        LocalTime.of(10, 0),
                        LocalTime.of(10, 30),
                        user
                );

        meetingRoom.cancelReservation(bookingId);

        String availableAgain =
                meetingRoom.searchAvailableRoom(
                        LocalTime.of(10, 0),
                        LocalTime.of(10, 30)
                );

        if (availableAgain != null) {
            System.out.println("TEST 2 - Cancellation: PASS");
        } else {
            System.out.println("TEST 2 - Cancellation: FAIL");
        }
    }

    // TEST 3
    private static void testSameUserMultipleRooms() {

        MeetingRoom meetingRoom = createSystem();

        User user = new User("Aparajit");

        String availability1 =
                meetingRoom.searchAvailableRoom(
                        LocalTime.of(10, 0),
                        LocalTime.of(10, 30)
                );

        String booking1 =
                meetingRoom.bookReservation(
                        availability1,
                        LocalTime.of(10, 0),
                        LocalTime.of(10, 30),
                        user
                );

        // Search again for another room/time
        String availability2 =
                meetingRoom.searchAvailableRoom(
                        LocalTime.of(11, 0),
                        LocalTime.of(11, 30)
                );

        String booking2 =
                meetingRoom.bookReservation(
                        availability2,
                        LocalTime.of(11, 0),
                        LocalTime.of(11, 30),
                        user
                );

        if (booking1 != null && booking2 != null) {
            System.out.println("TEST 3 - Same User Multiple Rooms: PASS");
        } else {
            System.out.println("TEST 3 - Same User Multiple Rooms: FAIL");
        }
    }

    // TEST 4
    private static void testTwoUsersSameRoomDifferentTimes() {

        MeetingRoom meetingRoom = createSystem();

        User user1 = new User("Aparajit");
        User user2 = new User("Rahul");

        // First booking
        String availability1 =
                meetingRoom.searchAvailableRoom(
                        LocalTime.of(10, 0),
                        LocalTime.of(10, 30)
                );

        String booking1 =
                meetingRoom.bookReservation(
                        availability1,
                        LocalTime.of(10, 0),
                        LocalTime.of(10, 30),
                        user1
                );

        // Second booking at a different time
        String availability2 =
                meetingRoom.searchAvailableRoom(
                        LocalTime.of(11, 0),
                        LocalTime.of(11, 30)
                );

        String booking2 =
                meetingRoom.bookReservation(
                        availability2,
                        LocalTime.of(11, 0),
                        LocalTime.of(11, 30),
                        user2
                );

        if (booking1 != null && booking2 != null) {
            System.out.println("TEST 4 - Same Room Different Times: PASS");
        } else {
            System.out.println("TEST 4 - Same Room Different Times: FAIL");
        }
    }

    // TEST 5
    private static void testOverlappingBooking() {

        MeetingRoom meetingRoom = createSystem();

        User user1 = new User("Aparajit");
        User user2 = new User("Rahul");

        // Book Room 1
        String availability1 =
                meetingRoom.searchAvailableRoom(
                        LocalTime.of(10, 0),
                        LocalTime.of(10, 30)
                );

        String booking1 =
                meetingRoom.bookReservation(
                        availability1,
                        LocalTime.of(10, 0),
                        LocalTime.of(10, 30),
                        user1
                );

        // Book Room 2 for the SAME time
        String availability2 =
                meetingRoom.searchAvailableRoom(
                        LocalTime.of(10, 0),
                        LocalTime.of(10, 30)
                );

        String booking2 =
                meetingRoom.bookReservation(
                        availability2,
                        LocalTime.of(10, 0),
                        LocalTime.of(10, 30),
                        user2
                );

        // Now BOTH rooms are occupied from 10:00–10:30
        String availability3 =
                meetingRoom.searchAvailableRoom(
                        LocalTime.of(10, 15),
                        LocalTime.of(10, 20)
                );

        if (booking1 != null
                && booking2 != null
                && availability3 == null) {

            System.out.println("TEST 5 - Overlapping Booking: PASS");

        } else {

            System.out.println("TEST 5 - Overlapping Booking: FAIL");
        }
    }

    // TEST 6
    private static void testBackToBackBooking() {

        MeetingRoom meetingRoom = createSystem();

        User user1 = new User("Aparajit");
        User user2 = new User("Rahul");

        String availability1 =
                meetingRoom.searchAvailableRoom(
                        LocalTime.of(10, 0),
                        LocalTime.of(10, 30)
                );

        meetingRoom.bookReservation(
                availability1,
                LocalTime.of(10, 0),
                LocalTime.of(10, 30),
                user1
        );

        // Starts exactly when previous booking ends
        String availability2 =
                meetingRoom.searchAvailableRoom(
                        LocalTime.of(10, 30),
                        LocalTime.of(11, 0)
                );

        if (availability2 != null) {
            System.out.println("TEST 6 - Back-to-Back Booking: PASS");
        } else {
            System.out.println("TEST 6 - Back-to-Back Booking: FAIL");
        }
    }

    // TEST 7
    private static void testInvalidCancellation() {

        MeetingRoom meetingRoom = createSystem();

        meetingRoom.cancelReservation("does-not-exist");

        System.out.println("TEST 7 - Invalid Cancellation: PASS");
    }
}