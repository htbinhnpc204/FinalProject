package com.htbinh.finalproject.ui.schedule.Week;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.ListFragment;

import com.htbinh.finalproject.Services.SessionServices;
import com.htbinh.finalproject.R;
import com.htbinh.finalproject.ui.schedule.ScheduleModel;

import java.util.ArrayList;
import java.util.List;

public class ScheduleWeekFragment extends ListFragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    ArrayList<ScheduleModel> listTKB;
    ScheduleWeekAdapter adapter;
    private List<String> listThu;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ScheduleWeekFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static ScheduleWeekFragment newInstance(String param1, String param2) {
        ScheduleWeekFragment fragment = new ScheduleWeekFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        listThu = new ArrayList<>();
        listThu.add("Thứ 2");
        listThu.add("Thứ 3");
        listThu.add("Thứ 4");
        listThu.add("Thứ 5");
        listThu.add("Thứ 6");
        listThu.add("Thứ 7");
        listThu.add("Chủ nhật");

        if(SessionServices.getListSchedule() != null){
            listTKB = SessionServices.getListSchedule();
        }
        else{
            listTKB = new ArrayList<>();
            Toast.makeText(getContext(), "List is null", Toast.LENGTH_SHORT).show();
        }

        adapter = new ScheduleWeekAdapter(getActivity(), R.layout.item_schedule_week, listTKB, listThu);
        setListAdapter(adapter);

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_schedule_week, container, false);
    }
}