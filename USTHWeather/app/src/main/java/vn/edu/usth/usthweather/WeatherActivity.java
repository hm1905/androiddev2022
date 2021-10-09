package vn.edu.usth.usthweather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class WeatherActivity extends AppCompatActivity {
    private ViewPager2 ViewPager;
    private FragmentAdapter FragmentAdapter;
    private TabLayout tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("WeatherActivity", "Created");

        ViewPager = findViewById(R.id.pager);
        tab = findViewById(R.id.tab2);
        FragmentManager manager = getSupportFragmentManager();

        FragmentAdapter = new FragmentAdapter(manager, getLifecycle());
        ViewPager.setAdapter((RecyclerView.Adapter) FragmentAdapter);

        new TabLayoutMediator(tab, ViewPager, (tab, position) -> {
            switch (position){
                case 0:
                    tab.setText("Hanoi");
                    break;
                case 1:
                    tab.setText("France");
                    break;
                case 2:
                    tab.setText("Toulous");
                    break;
            }
        }).attach();

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