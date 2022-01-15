package com.htbinh.finalproject.ui.schedule.Day;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import com.htbinh.finalproject.R;
import com.htbinh.finalproject.Services.SessionServices;
import com.htbinh.finalproject.ui.schedule.ScheduleModel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ScheduleDayFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ScheduleDayFragment extends ListFragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    ArrayList<ScheduleModel> listTKB;
    ScheduleDayAdapter adapter;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ScheduleDayFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static ScheduleDayFragment newInstance(String param1, String param2) {
        ScheduleDayFragment fragment = new ScheduleDayFragment();
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

        if(SessionServices.getListSchedule() != null){
            listTKB = SessionServices.getListSchedule();
        }
        else{
            listTKB = new ArrayList<>();
            Toast.makeText(getContext(), "List is null", Toast.LENGTH_SHORT).show();
        }

        ArrayList<ScheduleModel> tmp = new ArrayList<>();

        for (ScheduleModel item:
             listTKB) {
            if(getDayOfWeek().equals(item.getThu())){
                tmp.add(item);
            }
        }

        adapter = new ScheduleDayAdapter(getActivity(), R.layout.item_schedule_day, tmp);
        setListAdapter(adapter);

        return inflater.inflate(R.layout.fragment_schedule_day, container, false);
    }

    private String getDayOfWeek(){
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        return c.get(Calendar.DAY_OF_WEEK) == 0 ? "Chủ nhật" : "Thứ " + c.get(Calendar.DAY_OF_WEEK);
    }
}