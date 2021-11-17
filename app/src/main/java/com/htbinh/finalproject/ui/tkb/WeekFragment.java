package com.htbinh.finalproject.ui.tkb;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.htbinh.finalproject.databinding.FragmentDayBinding;
import com.htbinh.finalproject.databinding.FragmentExamScheduleBinding;
import com.htbinh.finalproject.databinding.FragmentWeekBinding;
import com.htbinh.finalproject.ui.examSchedule.ExamScheduleAdapter;
import com.htbinh.finalproject.ui.examSchedule.ExamScheduleModel;
import com.htbinh.finalproject.ui.tkb.TkbAdapter;
import com.htbinh.finalproject.ui.tkb.TkbModel;
import com.htbinh.finalproject.R;

import java.util.ArrayList;

public class WeekFragment  extends ListFragment {

    ArrayList<TkbModel> listTKB;
    private FragmentWeekBinding binding;
    TkbAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentWeekBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        listTKB = new ArrayList<>();
        listTKB.add(new TkbModel("06/11/2021","Lập trình di động 1","7-9","Đỗ Phú Huy","ONLINE"));
        listTKB.add(new TkbModel("07/11/2021","Lập trình di động 2","7-9","Đỗ Phú Huy","ONLINE"));
        listTKB.add(new TkbModel("08/11/2021","Lập trình di động 3","7-9","Đỗ Phú Huy","ONLINE"));
        listTKB.add(new TkbModel("09/11/2021","Lập trình di động 4","7-9","Đỗ Phú Huy","ONLINE"));
        listTKB.add(new TkbModel("10/11/2021","Lập trình di động 5","7-9","Đỗ Phú Huy","ONLINE"));
        listTKB.add(new TkbModel("11/11/2021","Lập trình di động 6","7-9","Đỗ Phú Huy","ONLINE"));
        listTKB.add(new TkbModel("12/11/2021","Lập trình di động 7 ","7-9","Đỗ Phú Huy","ONLINE"));
        listTKB.add(new TkbModel("13/11/2021","Lập trình di động 8","7-9","Đỗ Phú Huy","ONLINE"));


        final ListView listView = binding.list;
        adapter = new TkbAdapter(container.getContext(),R.layout.item_tkb_week, listTKB);
        listView.setAdapter(adapter);
        return root;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}

