package com.htbinh.finalproject.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.htbinh.finalproject.Adapter.ChiTietKetQuaAdapter;
import com.htbinh.finalproject.Model.ChiTietKetQuaModel;
import com.htbinh.finalproject.R;

import java.util.ArrayList;

public class ChiTietKetQuaActivity extends Activity {
    ListView lvChitietketqua;
    ArrayList<ChiTietKetQuaModel> arrayChiTietKetQua;
    ChiTietKetQuaAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitietketqua);

    arrayChiTietKetQua = new ArrayList<>();
        Anhxa();
        arrayChiTietKetQua.add(new ChiTietKetQuaModel("Kinh tế chính trị 500231", "500231", "8,0",
                                                              "8.0", "7.0", "10 ","8","A"));
        arrayChiTietKetQua.add(new ChiTietKetQuaModel("Lập trình web nâng cao ", "500231", "8,0",
                                                              "8.0", "7.0", "8.5", "A","A"));
        arrayChiTietKetQua.add(new ChiTietKetQuaModel("Tin học đại cương ","500231", "2", "8,0",
                                                              "8.0", "7.0", "8.2", "B"));
        arrayChiTietKetQua.add(new ChiTietKetQuaModel("Kinh tế chính trị","500231", "2", "8,0",
                                                              "8.0", "7.0", "8.2", "B"));
        arrayChiTietKetQua.add(new ChiTietKetQuaModel("Kinh tế chính trị ","500231", "2", "8,0",
                                                              "8.0", "7.0", "8.2", "B"));
        adapter = new ChiTietKetQuaAdapter(this,R.layout.item_chitietketqua, arrayChiTietKetQua);
       lvChitietketqua.setAdapter(adapter);
}

    private void Anhxa() {
        lvChitietketqua = (ListView) findViewById(R.id.lvChitietketqua);
    }

}
