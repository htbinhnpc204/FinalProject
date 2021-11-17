package com.htbinh.finalproject.ui.tkb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.google.android.material.tabs.TabLayout;
import com.htbinh.finalproject.ui.tkb.FragmentAdapter;
import com.htbinh.finalproject.R;
import com.htbinh.finalproject.ui.tkb.TkbAdapter;
import com.htbinh.finalproject.ui.tkb.TkbModel;

import java.util.ArrayList;

public class TkbAvtivity  extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewPager2;
    FragmentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tkb);

        tabLayout = findViewById(R.id.tabTKB);
        viewPager2 = findViewById(R.id.pager2);


        viewPager2.setAdapter(adapter);

        tabLayout.addTab(tabLayout.newTab().setText("Ngày"));
        tabLayout.addTab(tabLayout.newTab().setText("Tuần"));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });

    }
    public void goBack(View v){
        finish();
    }
}
