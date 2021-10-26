package vn.edu.usth.usthweather;

import static com.google.android.material.internal.ContextUtils.getActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class WeatherActivity extends AppCompatActivity {
    private ViewPager2 ViewPager;
    private FragmentAdapter FragmentAdapter;
    private TabLayout tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Handler handler = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(Message msg) {
                String content = msg.getData().getString("server_response");
                Toast.makeText(getApplicationContext(), content, Toast.LENGTH_SHORT).show();
            }
        };
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Bundle bundle = new Bundle();
                bundle.putString("server_response", "some sample json here");

                Message msg = new Message();
                msg.setData(bundle);
                handler.sendMessage(msg);
            }
        });
        t.start();


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
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu2:
                Toast toast = Toast.makeText(getApplicationContext(), "refresh", Toast.LENGTH_SHORT);
                toast.show();
                break;
            case R.id.menu1:
                Intent intent = new Intent(getApplicationContext(), PrefActivity.class);
                startActivity(intent);
                break;
        }
        return true;
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