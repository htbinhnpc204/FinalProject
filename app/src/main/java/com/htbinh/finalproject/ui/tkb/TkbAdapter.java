package com.htbinh.finalproject.ui.tkb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

import com.htbinh.finalproject.R;

import java.util.ArrayList;
import java.util.List;

public class TkbAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<TkbModel> arraylist;

    public TkbAdapter(Context context, int layout, List<TkbModel> arraylist) {
        this.context = context;
        this.layout = layout;
        this.arraylist = arraylist;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        view = inflater.inflate(layout, null);
        TkbModel LICHHOC = arraylist.get(i);

        //ánh xạ
        TextView ngay = view.findViewById(R.id.textview_ngay);
        TextView monhoc = view.findViewById(R.id.textview_monhoc);
        TextView tiet = view.findViewById(R.id.textview_tiet);
        TextView gv = view.findViewById(R.id.textview_gv);
        TextView phong = view.findViewById(R.id.textview_phong);

        ngay.setText("Ngày: " + LICHHOC.getNgay());
        monhoc.setText("Môn: " + LICHHOC.getMonhoc());
        tiet.setText("Tiết: " + LICHHOC.getTiet());
        gv.setText("Giảng viên: " + LICHHOC.getGv());
        phong.setText("Phòng: " + LICHHOC.getPhong());

        Animation anim = AnimationUtils.loadAnimation(context, R.anim.left_slide);
        view.startAnimation(anim);

        return view;

    }



}
