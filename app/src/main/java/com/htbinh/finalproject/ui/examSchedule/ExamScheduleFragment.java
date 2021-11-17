package com.htbinh.finalproject.ui.examSchedule;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.htbinh.finalproject.R;
import com.htbinh.finalproject.databinding.FragmentExamScheduleBinding;

import java.util.ArrayList;

public class ExamScheduleFragment extends Fragment {

    ArrayList<ExamScheduleModel> examScheduleModels;
    private FragmentExamScheduleBinding binding;
    ExamScheduleAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        examScheduleModels = new ArrayList<>();

        binding = FragmentExamScheduleBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        examScheduleModels.add(new ExamScheduleModel("29/06/2021","220LTTQ02","Lập trình trực quan","Hoàng Thị Mỹ Lệ","21h00","ONLINE"));
        examScheduleModels.add(new ExamScheduleModel("29/06/2021","220LTTQ02","Lập trình trực quan","Hoàng Thị Mỹ Lệ","22h00","ONLINE"));
        examScheduleModels.add(new ExamScheduleModel("01/07/2021","220NNCNC02","Ngoại ngữ chuyên ngành CNTT","Võ Trung Hùng","17h00-19h00","ONLINE"));
        examScheduleModels.add(new ExamScheduleModel("24/07/2021","220VKT01","Vẽ kỹ thuật","Nguyễn Đức Sỹ","13h00","ONLINE"));
        examScheduleModels.add(new ExamScheduleModel("24/07/2021","220VKT01","Vẽ kỹ thuật","Nguyễn Đức Sỹ","13h00","ONLINE"));

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
