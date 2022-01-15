package com.htbinh.finalproject.ui.examSchedule;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.htbinh.finalproject.R;
import com.htbinh.finalproject.Services.SessionServices;
import com.htbinh.finalproject.databinding.FragmentExamScheduleBinding;

import java.util.ArrayList;

public class ExamScheduleFragment extends Fragment {

    ArrayList<ExamScheduleModel> examScheduleModels;
    private FragmentExamScheduleBinding binding;
    ExamScheduleAdapter adapter;
    TextView tvthongbao;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        examScheduleModels = new ArrayList<>();

        binding = FragmentExamScheduleBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        tvthongbao = binding.tvthongbao;

        if(SessionServices.getListExamSchedule() != null){
            examScheduleModels = SessionServices.getListExamSchedule();
            tvthongbao.setVisibility(View.GONE);
        }
        else{
            examScheduleModels = new ArrayList<>();
            tvthongbao.setVisibility(View.VISIBLE);
        }

        Log.e("ExamSchedule 2 log", "" + SessionServices.getListExamSchedule());

        final ListView listView = binding.listExSchedule;
        adapter = new ExamScheduleAdapter(container.getContext(),R.layout.item_exam_schedule,examScheduleModels);
        listView.setAdapter(adapter);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
