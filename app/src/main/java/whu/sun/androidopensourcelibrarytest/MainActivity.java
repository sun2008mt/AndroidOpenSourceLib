package whu.sun.androidopensourcelibrarytest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.header.MaterialHeader;
import in.srain.cube.views.ptr.util.PtrLocalDisplay;

public class MainActivity extends AppCompatActivity {

    private PtrFrameLayout ptrFrameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        ptrFrameLayout = findViewById(R.id.ptr_frame);
        //MaterialDesign头部风格
        MaterialHeader header = new MaterialHeader(this);
        header.setPadding(0, PtrLocalDisplay.dp2px(15), 0, 0);
        ptrFrameLayout.setHeaderView(header);
        ptrFrameLayout.addPtrUIHandler(header);
        ptrFrameLayout.setPtrHandler(new PtrDefaultHandler() {
            @Override
            public void onRefreshBegin(final PtrFrameLayout frame) {
                frame.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        frame.refreshComplete();
                    }
                }, 1800);
            }

            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                return super.checkCanDoRefresh(frame, content, header);
            }
        });

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
