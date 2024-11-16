package LLD.DesignParkingLot;

public class Account {
    private String username;
    private String password;
    private boolean status;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
        this.status = true;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
