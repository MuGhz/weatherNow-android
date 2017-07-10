package com.example.muhammadghozi41.weathernow;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class WeatherForecastActivity extends AppCompatActivity {
    final Context context = WeatherForecastActivity.this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_forecast);
        String city = getIntent().getStringExtra("city");
        String temperature = getIntent().getStringExtra("temperature");
        String weather = getIntent().getStringExtra("weather");
        String detail = "Weather @"+city+"\n"+"Temperature = "+temperature+"\n"+weather;
        TextView txt = (TextView) findViewById(R.id.textDetail);
        txt.setText(detail);
    }
}
