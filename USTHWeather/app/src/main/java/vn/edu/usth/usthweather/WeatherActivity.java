package vn.edu.usth.usthweather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class WeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("WeatherActivity", "Created");

        ForecastFragment  firstFragment = new ForecastFragment();
        // Add the fragment to the 'container' FrameLayout
        getSupportFragmentManager().beginTransaction().add(R.id.container, firstFragment).commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("WeatherActivity", "Started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("WeatherActivity", "Resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("WeatherActivity", "Pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("WeatherActivity", "Stopped");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("WeatherActivity", "Destroy");
    }
}