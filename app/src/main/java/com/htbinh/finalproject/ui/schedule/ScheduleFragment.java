package com.htbinh.finalproject.ui.schedule;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.htbinh.finalproject.databinding.FragmentScheduleBinding;
import com.htbinh.finalproject.ui.home.HomeViewModel;

public class ScheduleFragment extends Fragment {

    TabLayout tabLayout;
    ViewPager2 viewPager2;
    ScheduleAdapter adapter;

    private HomeViewModel homeViewModel;
    private FragmentScheduleBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new HomeViewModel();

        binding = FragmentScheduleBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

//        final TextView textView = binding.textHome;

        tabLayout = binding.tabTKB;
        viewPager2 = binding.pager2;

        tabLayout.addTab(tabLayout.newTab().setText("Theo ngày"));
        tabLayout.addTab(tabLayout.newTab().setText("Theo tuần"));

        adapter = new ScheduleAdapter(getFragmentManager() , getLifecycle());
        viewPager2.setAdapter(adapter);

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

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}