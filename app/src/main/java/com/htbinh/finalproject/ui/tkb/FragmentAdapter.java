package com.htbinh.finalproject.ui.tkb;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.htbinh.finalproject.ui.tkb.DayFragment;
import com.htbinh.finalproject.ui.tkb.WeekFragment;

public class FragmentAdapter extends FragmentStateAdapter {

    public FragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position){
            case 1:
                return new WeekFragment();
        }

        return new DayFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}