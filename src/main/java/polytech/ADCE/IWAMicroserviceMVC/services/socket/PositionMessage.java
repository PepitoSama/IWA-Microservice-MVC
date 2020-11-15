package polytech.ADCE.IWAMicroserviceMVC.services.socket;

import java.util.Date;

public class PositionMessage {

    private int userId;
    private double longitude;
    private double latitude;
    private Date timestamp;

    public PositionMessage() {}

    public PositionMessage(int userId, double longitude, double latitude, Date timestamp) {
        this.userId = userId;
        this.longitude = longitude;
        this.latitude = latitude;
        this.timestamp = timestamp;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
