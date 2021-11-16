package com.htbinh.finalproject.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;


import com.htbinh.finalproject.Adapter.KetQuaAdapter;
import com.htbinh.finalproject.Adapter.TinTucAdapter;
import com.htbinh.finalproject.MainActivity;
import com.htbinh.finalproject.Model.TinTucModel;
import com.htbinh.finalproject.R;

import java.util.ArrayList;

public class TinTucActivity extends Activity {

    ListView lvTintuc;
    ArrayList<TinTucModel> arrayTintuc;
    ImageView hinhanh;
    TinTucAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tintuc);
        Anhxa();
        arrayTintuc=new ArrayList<>();
         arrayTintuc.add(new TinTucModel(R.drawable.img_tintucitem,"Sinh viên Trường Đại học Sư phạm Kỹ thuật đạt giải Nhất ...","30 THÁNG 10 2021",
               "Ngày 26/10/2021, Đại học Đà Nẵng đã thông báo kết quả xét Giải thưởng ..."));
        arrayTintuc.add(new TinTucModel(R.drawable.img_tintucitem,"Sinh viên Trường Đại học Sư phạm Kỹ thuật đạt giải Nhất ...","30 THÁNG 10 2021",
                "Ngày 26/10/2021, Đại học Đà Nẵng đã thông báo kết quả xét Giải thưởng ..."));
        arrayTintuc.add(new TinTucModel(R.drawable.img_tintucitem,"Sinh viên Trường Đại học Sư phạm Kỹ thuật đạt giải Nhất ...","30 THÁNG 10 2021",
                "Ngày 26/10/2021, Đại học Đà Nẵng đã thông báo kết quả xét Giải thưởng ..."));
        arrayTintuc.add(new TinTucModel(R.drawable.img_tintucitem,"Sinh viên Trường Đại học Sư phạm Kỹ thuật đạt giải Nhất ...","30 THÁNG 10 2021",
                "Ngày 26/10/2021, Đại học Đà Nẵng đã thông báo kết quả xét Giải thưởng ..."));
        arrayTintuc.add(new TinTucModel(R.drawable.img_tintucitem,"Sinh viên Trường Đại học Sư phạm Kỹ thuật đạt giải Nhất ...","30 THÁNG 10 2021",
                "Ngày 26/10/2021, Đại học Đà Nẵng đã thông báo kết quả xét Giải thưởng ..."));
        arrayTintuc.add(new TinTucModel(R.drawable.img_tintucitem,"Sinh viên Trường Đại học Sư phạm Kỹ thuật đạt giải Nhất ...","30 THÁNG 10 2021",
                "Ngày 26/10/2021, Đại học Đà Nẵng đã thông báo kết quả xét Giải thưởng ..."));
        arrayTintuc.add(new TinTucModel(R.drawable.img_tintucitem,"Sinh viên Trường Đại học Sư phạm Kỹ thuật đạt giải Nhất ...","30 THÁNG 10 2021",
                "Ngày 26/10/2021, Đại học Đà Nẵng đã thông báo kết quả xét Giải thưởng ..."));
        adapter = new TinTucAdapter(this, R.layout.item_tintuc,arrayTintuc);
        lvTintuc.setAdapter(adapter);

    }
    private void Anhxa() {
        hinhanh=(ImageView)findViewById(R.id.hinhanh);
        lvTintuc = (ListView) findViewById(R.id.lvTintuc);

    }
    public void menu(View v){
        Intent in=new Intent(TinTucActivity.this, MainActivity.class);
        startActivity(in);
    }

}
