package com.htbinh.finalproject.Activity;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.htbinh.finalproject.Adapter.KetQuaAdapter;
import com.htbinh.finalproject.Model.KetQuaModel;
import com.htbinh.finalproject.R;

import java.util.ArrayList;

public class KetQuaActivity extends AppCompatActivity {
    ListView lvKetqua;
    ArrayList<KetQuaModel> arrayKetqua;

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
        lvKetqua = (ListView) findViewById(R.id.lvKetqua);
    }



}
