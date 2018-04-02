package whu.sun.androidopensourcelibrarytest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        BottomNavigationBar bottomNavigationBar = findViewById(R.id.bottom_navigation_bar);
        bottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.account, "Test1"))
                .addItem(new BottomNavigationItem(R.drawable.account, "Test2"))
                .addItem(new BottomNavigationItem(R.drawable.account, "Test3"))
                .addItem(new BottomNavigationItem(R.drawable.account, "Test4"))
                .addItem(new BottomNavigationItem(R.drawable.account, "Test5"))
                .initialise();
        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                Toast.makeText(MainActivity.this, "Tab" + position + "selected...", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTabUnselected(int position) {
                Toast.makeText(MainActivity.this, "Tab" + position + "unselected...", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTabReselected(int position) {
                Toast.makeText(MainActivity.this, "Tab..." + position + "reselected...", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
