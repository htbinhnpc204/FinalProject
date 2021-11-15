package com.htbinh.finalproject.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.htbinh.finalproject.Adapter.ExamScheduleAdapter;
import com.htbinh.finalproject.Model.ExamScheduleModel;
import com.htbinh.finalproject.R;

import java.util.ArrayList;

public class ExamScheduleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_schedule);

        ListView List;
        ArrayList<ExamScheduleModel> arraylist;
        ExamScheduleAdapter adapter;

        List = findViewById(R.id.listView);

        arraylist = new ArrayList<>();
        arraylist.add(new ExamScheduleModel("29/06/2021","220LTTQ02","Lập trình trực quan","Hoàng Thị Mỹ Lệ","21h00","ONLINE"));
        arraylist.add(new ExamScheduleModel("29/06/2021","220LTTQ02","Lập trình trực quan","Hoàng Thị Mỹ Lệ","22h00","ONLINE"));
        arraylist.add(new ExamScheduleModel("01/07/2021","220NNCNC02","Ngoại ngữ chuyên ngành công nghệ thông tin","Võ Trung Hùng","GIỜ THI: 17h00-19h00","ONLINE"));
        arraylist.add(new ExamScheduleModel("24/07/2021","220VKT01","Vẽ kỹ thuật","Nguyễn Đức Sỹ","13h00","ONLINE"));
        arraylist.add(new ExamScheduleModel("24/07/2021","220VKT01","Vẽ kỹ thuật","Nguyễn Đức Sỹ","13h00","ONLINE"));

        adapter = new ExamScheduleAdapter(ExamScheduleActivity.this,R.layout.item_exam_schedule,arraylist);
        List.setAdapter(adapter);
    }
    public void goBack(View v){
        finish();
    }
}