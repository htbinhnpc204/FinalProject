package com.htbinh.finalproject.ui.schedule;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.htbinh.finalproject.ui.schedule.Day.ScheduleDayFragment;
import com.htbinh.finalproject.ui.schedule.Week.ScheduleWeekFragment;

public class ScheduleAdapter extends FragmentStateAdapter {

    public ScheduleAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position){
            case 1:
                return new ScheduleWeekFragment();
        }

        return new ScheduleDayFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
