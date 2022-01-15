package com.htbinh.finalproject.ui.schedule.Day;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import com.htbinh.finalproject.R;
import com.htbinh.finalproject.Services.SessionServices;
import com.htbinh.finalproject.ui.schedule.ScheduleModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ScheduleDayFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ScheduleDayFragment extends ListFragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    DatePickerDialog.OnDateSetListener dateSetListener;

    ArrayList<ScheduleModel> listTKB;
    ScheduleDayAdapter adapter;
    String datePicker;
    ArrayList<ScheduleModel> list;
    TextView dateText;
    ImageView prevDate, nextDate;

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

        if (SessionServices.getListSchedule() != null) {
            listTKB = SessionServices.getListSchedule();
        } else {
            listTKB = new ArrayList<>();
            Toast.makeText(getContext(), "List is null", Toast.LENGTH_SHORT).show();
        }

        View v = inflater.inflate(R.layout.fragment_schedule_day, container, false);
        dateText = (TextView) v.findViewById(R.id.currentDate);
        prevDate = v.findViewById(R.id.datePrev);
        nextDate = v.findViewById(R.id.dateNext);

        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
        datePicker = format1.format(c.getTime());

        int selectedYear = Calendar.getInstance().get(Calendar.YEAR);
        int selectedMonth = Calendar.getInstance().get(Calendar.MONTH);
        int selectedDayOfMonth = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);

        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year,
                                  int monthOfYear, int dayOfMonth) {
                String Day = "" + (dayOfMonth < 10 ? "0" + dayOfMonth : dayOfMonth);
                String Month = (monthOfYear + 1) < 10 ? "0" + (monthOfYear + 1) : (monthOfYear + 1) + "";
                String Year = "" + year;
                datePicker = Day + "/" + Month + "/" + Year;

                setData();
            }
        };

        setData();


        dateText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), dateSetListener, selectedYear, selectedMonth, selectedDayOfMonth);
                datePickerDialog.show();
            }
        });

        prevDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                minusDay();
            }
        });

        nextDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                plusDay();
            }
        });

        return v;
    }

    private void setData() {
        dateText.setText(getDayOfWeek(datePicker) + " " + datePicker);
        list = getList();
        adapter = new ScheduleDayAdapter(getActivity(), R.layout.item_schedule_day, list);
        setListAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private ArrayList<ScheduleModel> getList() {
        ArrayList<ScheduleModel> tmp = new ArrayList<>();

        for (ScheduleModel item :
                listTKB) {
            if (item.getThu().equals(getDayOfWeek(datePicker))) {
                tmp.add(item);
            }
        }
        return tmp;
    }

    private String getDayOfWeek() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        return c.get(Calendar.DAY_OF_WEEK) == 1 ? "Chủ nhật" : "Thứ " + c.get(Calendar.DAY_OF_WEEK);
    }

    private String getDayOfWeek(String date) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        try {
            cal.setTime(sdf.parse(date));// all done
        } catch (ParseException e) {
            Log.e("Parse date", "Cannot parse " + date + " to date format");
        }
        return cal.get(Calendar.DAY_OF_WEEK) == 1 ? "Chủ nhật" : "Thứ " + cal.get(Calendar.DAY_OF_WEEK);
    }

    private void minusDay() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        try {
            cal.setTime(sdf.parse(datePicker));
            cal.add(Calendar.DATE, -1);
            Date date;
            datePicker = sdf.format(cal.getTime());
            setData();
        } catch (ParseException e) {
            Log.e("Parse date", "Cannot parse " + datePicker + " to date format");
        }
    }

    private void plusDay() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        try {
            cal.setTime(sdf.parse(datePicker));
            cal.add(Calendar.DATE, 1);
            setData();
            datePicker = sdf.format(cal.getTime());
        } catch (ParseException e) {
            Log.e("Parse date", "Cannot parse " + datePicker + " to date format");
        }
    }
}