package com.example.muhammadghozi41.weathernow.Model;

/**
 * Created by muhammad.ghozi41 on 10/07/17.
 */

public class WeatherForecast {
    private Location location;
    private Current current;

    public WeatherForecast(){}
    public WeatherForecast(Location location, Current current) {
        this.location = location;
        this.current = current;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }
}
