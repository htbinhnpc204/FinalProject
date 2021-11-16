package com.htbinh.finalproject.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.htbinh.finalproject.Adapter.KetQuaAdapter;
import com.htbinh.finalproject.Model.KetQuaModel;
import com.htbinh.finalproject.R;

import java.util.ArrayList;

public class KetQuaActivity extends AppCompatActivity {
    ListView lvKetqua;
    ArrayList<KetQuaModel> arrayKetqua;
    ImageView btnXemChiTiet;
    KetQuaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ketqua);
        Anhxa();
        arrayKetqua = new ArrayList<>();
        arrayKetqua.add(new KetQuaModel(" 1 - Năm học 2021-2022", "24","8","3","Gioi"));
        arrayKetqua.add(new KetQuaModel(" 1 - Năm học 2021-2022", "20","10","4","xuat sac"));
        arrayKetqua.add(new KetQuaModel(" 1 - Năm học 2021-2022", "21","6.5","2.3","Binh thuong"));
        arrayKetqua.add(new KetQuaModel(" 1 - Năm học 2021-2022", "24","8","3","Gioi"));
        arrayKetqua.add(new KetQuaModel(" 1 - Năm học 2021-2022", "20","10","4","xuat sac"));
        arrayKetqua.add(new KetQuaModel(" 1 - Năm học 2021-2022", "21","6.5","2.3","Binh thuong"));
        adapter = new KetQuaAdapter(this, R.layout.item_ketqua,arrayKetqua);
        lvKetqua.setAdapter(adapter);
    }
    private void Anhxa() {
        btnXemChiTiet=findViewById(R.id.btnXemthem);
        lvKetqua = (ListView) findViewById(R.id.lvKetqua);

    }
    public void goBack(View v){
        finish();
    }
    public void viewxemthem(View v){
        Intent in =new Intent(KetQuaActivity.this,ChiTietKetQuaActivity.class);
        startActivity(in);
    }


}
