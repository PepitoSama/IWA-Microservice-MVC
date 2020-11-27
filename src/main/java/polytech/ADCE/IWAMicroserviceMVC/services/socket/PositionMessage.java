package polytech.ADCE.IWAMicroserviceMVC.services.socket;

import java.util.Date;

public class PositionMessage {

    private String username;
    private double longitude;
    private double latitude;
    private Date timestamp;

    public PositionMessage() {}

    public PositionMessage(String username, double longitude, double latitude, Date timestamp) {
        this.username = username;
        this.longitude = longitude;
        this.latitude = latitude;
        this.timestamp = timestamp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
