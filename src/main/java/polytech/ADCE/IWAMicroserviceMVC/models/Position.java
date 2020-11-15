package polytech.ADCE.IWAMicroserviceMVC.models;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.simple.JSONObject;

import java.util.Date;

public class Position {

    private int userId;
    private double longitude;
    private double latitude;
    private Date timestamp;

    public Position(int userId, double longitude, double latitude, Date timestamp) {
        this.setLatitude(latitude);
        this.setLongitude(longitude);
        this.setTimestamp(timestamp);
        this.setUserId(userId);
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

    public String toString() {
        return this.getUserId() + ":" + this.getLatitude() + ":" + this.getLongitude()  + ":" + this.getTimestamp();
    }

    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        json.put("userid", this.getUserId());
        json.put("latitude", this.getLatitude());
        json.put("longitude", this.getLongitude());
        json.put("timestamp", this.getTimestamp());
        return json;
    }
}
