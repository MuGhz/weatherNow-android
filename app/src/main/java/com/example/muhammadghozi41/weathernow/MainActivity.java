package com.example.muhammadghozi41.weathernow;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import com.example.muhammadghozi41.weathernow.Model.*;
import com.example.muhammadghozi41.weathernow.Service.WeatherService;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;


import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText location;
    private AppCompatButton appCompatButtonSearch;
    private AppCompatButton appCompatButtonFavorite;
    final Context context = MainActivity.this;
    private String city;
    private WeatherForecast currentWeather;
    private Forecast fc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        currentWeather = new WeatherForecast();
        location = (TextInputEditText) findViewById(R.id.textInputEditTextLocation);
        appCompatButtonSearch = (AppCompatButton) findViewById(R.id.appCompatButtonSearch);
        appCompatButtonFavorite = (AppCompatButton) findViewById(R.id.appCompatButtonFavorite);
        initListeners();
        }
    private void initListeners() {
        appCompatButtonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                city = location.getText().toString();
                fc = new Forecast(city);
                fc.execute();

            }
        });
        appCompatButtonFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
    public class Forecast extends AsyncTask<Void,Void,Boolean>{
        private String city;
        private Intent i = new Intent(MainActivity.this, WeatherForecastActivity.class);


        Forecast(String city){
            this.city = city;
        }

        @Override
        protected Boolean doInBackground(Void... voids) {
            Retrofit client = new Retrofit.Builder()
                    .baseUrl("https://api.apixu.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            WeatherService service = client.create(WeatherService.class);
            Call<WeatherForecast> call = service.getWeatherForecast(city,"6a884a34927c4adab8462858171007");

            try {
                Response<WeatherForecast> response = call.execute();
                currentWeather = response.body();

                //i.putExtra("myMenu", new Gson().toJson(items));

            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        }

        @Override
        protected void onPostExecute(Boolean success) {
            if(success) {
                Toast.makeText(context,currentWeather.getCurrent().getCondition().getText()+"", Toast.LENGTH_LONG).show();
                i.putExtra("temperature",currentWeather.getCurrent().getTemp_c()+"");
                i.putExtra("weather",currentWeather.getCurrent().getCondition().getText());
                i.putExtra("city",currentWeather.getLocation().getName()+", "+currentWeather.getLocation().getRegion()+", "+currentWeather.getLocation().getCountry());
                startActivity(i);
            }
        }
    }


}
