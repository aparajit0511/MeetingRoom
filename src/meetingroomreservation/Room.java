package meetingroomreservation;

import java.util.ArrayList;
import java.util.UUID;

public class Room {
    private String roomId;
    private String roomName;
    private int capacity;

    private ArrayList<String> roomList = new ArrayList<String>();

    public Room(String roomName, Integer capacity) {
        this.roomId = UUID.randomUUID().toString();;
        this.roomName = roomName;
        this.capacity = capacity;
        roomList.add(this.roomName);
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

    public ArrayList getRoomList(){
        return roomList;
    }
}
