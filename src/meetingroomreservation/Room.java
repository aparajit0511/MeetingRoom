package meetingroomreservation;

import java.util.UUID;

public class Room {
    private String roomId;
    private String roomName;
    private int capacity;

    public Room(String roomName, Integer capacity) {
        this.roomId = UUID.randomUUID().toString();;
        this.roomName = roomName;
        this.capacity = capacity;
    }

    public String getRoomId() {
        return roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}
