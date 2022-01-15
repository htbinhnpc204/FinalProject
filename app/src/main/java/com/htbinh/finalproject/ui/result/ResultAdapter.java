package com.htbinh.finalproject.ui.result;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.htbinh.finalproject.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ResultAdapter extends BaseAdapter {
    private final Context context;
    private final int layout;
    private final List<ResultModel> ketquaList;

    public ResultAdapter(Context context, int layout, List<ResultModel> ketquaList) {
        this.context = context;
        this.layout = layout;
        this.ketquaList = ketquaList;
    }

    @Override
    public int getCount() {
        return ketquaList.size();
    }

    @Override
    public Object getItem(int i) {
        return ketquaList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout,null);

        TextView hocky =(TextView) view.findViewById(R.id.textviewname);
        TextView soTcTichLuy = (TextView)  view.findViewById(R.id.textViewtc);
        TextView xeploai = (TextView) view.findViewById(R.id.textViewxl);
        TextView diemTbcHocKy = (TextView) view.findViewById(R.id.textViewdiem);
        TextView diemTbcHocBong  = (TextView)  view.findViewById(R.id.textViewhbong);

        ResultModel ketqua = ketquaList.get(i);

        hocky.setText(ketqua.getHocky());
        soTcTichLuy.setText(ketqua.getSoTcTichLuy());
        xeploai.setText(ketqua.getXeploai());
        diemTbcHocKy.setText(ketqua.getDiemTbcHocKy());
        diemTbcHocBong.setText(ketqua.getDiemTbcHocBong());
        return view;
    }
}
