package com.example.muhammadghozi41.weathernow.Service;

import com.example.muhammadghozi41.weathernow.Model.WeatherForecast;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by muhammad.ghozi41 on 10/07/17.
 */

public interface WeatherService{
        @GET("/v1/current.json")
        Call<WeatherForecast> getWeatherForecast(@Query("q") String city,@Query("key") String key);
}