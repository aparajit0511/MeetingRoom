package meetingroomreservation;

import java.util.UUID;

public class User {
    private String userId;
    private String userName;

    public User(String userId, String userName) {
        this.userId = UUID.randomUUID().toString();;
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
