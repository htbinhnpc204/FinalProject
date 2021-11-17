package com.htbinh.finalproject.ui.tkb;



import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.htbinh.finalproject.R;
import com.htbinh.finalproject.ui.tkb.TkbAdapter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TkbOfDayAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<TkbModel> arraylist;

    public TkbOfDayAdapter(Context context, int layout, List<TkbModel> arraylist) {
        this.context = context;
        this.layout = layout;
        this.arraylist = arraylist;
    }

    @Override
    public int getCount() {
        return arraylist.size();
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
        TextView monhoc = view.findViewById(R.id.textview_MonHoc);
        TextView tiet = view.findViewById(R.id.textview_Tiet);
        TextView gv = view.findViewById(R.id.textview_Gv);
        TextView phong = view.findViewById(R.id.textview_Phong);

        monhoc.setText("Môn: " + LICHHOC.getMonhoc());
        tiet.setText("Tiết: " + LICHHOC.getTiet());
        gv.setText("Giảng viên: " + LICHHOC.getGv());
        phong.setText("Phòng: " + LICHHOC.getPhong());

        Animation anim = AnimationUtils.loadAnimation(context, R.anim.left_slide);
        view.startAnimation(anim);

        return view;
    }


}


