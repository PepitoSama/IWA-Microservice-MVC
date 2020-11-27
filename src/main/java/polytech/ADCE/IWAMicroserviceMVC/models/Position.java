package polytech.ADCE.IWAMicroserviceMVC.models;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.simple.JSONObject;

import java.util.Date;

public class Position {

    private String username;
    private double longitude;
    private double latitude;
    private Date timestamp;

    public Position(String username, double longitude, double latitude, Date timestamp) {
        this.setLatitude(latitude);
        this.setLongitude(longitude);
        this.setTimestamp(timestamp);
        this.setUsername(username);
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

    public String toString() {
        return this.getUsername() + ":" + this.getLatitude() + ":" + this.getLongitude()  + ":" + this.getTimestamp();
    }

    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        json.put("username", this.getUsername());
        json.put("latitude", this.getLatitude());
        json.put("longitude", this.getLongitude());
        json.put("timestamp", this.getTimestamp());
        return json;
    }
}
