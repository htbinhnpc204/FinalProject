package com.htbinh.finalproject.ui.tkb;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import com.htbinh.finalproject.R;
import com.htbinh.finalproject.databinding.FragmentDayBinding;
import com.htbinh.finalproject.databinding.FragmentExamScheduleBinding;
import com.htbinh.finalproject.ui.examSchedule.ExamScheduleAdapter;
import com.htbinh.finalproject.ui.examSchedule.ExamScheduleModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class DayFragment extends ListFragment {

    ArrayList<TkbModel> listTKB;
    private FragmentDayBinding binding;
    TkbOfDayAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentDayBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        listTKB = new ArrayList<>();
        listTKB.add(new TkbModel("06/11/2021", "Lập trình di động 1", "7-9", "Đỗ Phú Huy", "ONLINE"));
        listTKB.add(new TkbModel("07/11/2021", "Lập trình di động 2", "7-9", "Đỗ Phú Huy", "ONLINE"));
        listTKB.add(new TkbModel("08/11/2021", "Lập trình di động 3", "7-9", "Đỗ Phú Huy", "ONLINE"));
        listTKB.add(new TkbModel("09/11/2021", "Lập trình di động 4", "7-9", "Đỗ Phú Huy", "ONLINE"));
        listTKB.add(new TkbModel("10/11/2021", "Lập trình di động 5", "7-9", "Đỗ Phú Huy", "ONLINE"));
        listTKB.add(new TkbModel("11/11/2021", "Lập trình di động 6", "7-9", "Đỗ Phú Huy", "ONLINE"));
        listTKB.add(new TkbModel("12/11/2021", "Lập trình di động 7 ", "7-9", "Đỗ Phú Huy", "ONLINE"));
        listTKB.add(new TkbModel("13/11/2021", "Lập trình di động 8", "7-9", "Đỗ Phú Huy", "ONLINE"));

        final ListView listView = binding.list;
        adapter = new TkbOfDayAdapter(container.getContext(),R.layout.item_tkb_day, listTKB);
        listView.setAdapter(adapter);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

