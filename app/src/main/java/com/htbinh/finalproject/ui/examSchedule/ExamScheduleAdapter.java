package com.htbinh.finalproject.ui.examSchedule;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.htbinh.finalproject.R;

import java.util.List;

public class ExamScheduleAdapter extends BaseAdapter {

    private final Context context;
    private final int layout;
    private final List<ExamScheduleModel> arraylist;

    public ExamScheduleAdapter(Context context, int layout, List<ExamScheduleModel> arraylist) {
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

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        view = inflater.inflate(layout, null);

        ExamScheduleModel lichthi = arraylist.get(i);

        //ánh xạ
        TextView ngaythi = view.findViewById(R.id.tvngaythi);
        TextView tenlhp = view.findViewById(R.id.tvtenlhp);
        TextView tenhp = view.findViewById(R.id.tvtenhp);
        TextView giangvien = view.findViewById(R.id.tvgiangvien);
        TextView giothi = view.findViewById(R.id.tvgiothi);
        TextView phongthi = view.findViewById(R.id.tvphongthi);

        ngaythi.setText(lichthi.getNgaythi());
        tenlhp.setText(lichthi.getTenlhp() );
        tenhp.setText(lichthi.getTenhp());
        giangvien.setText(lichthi.getGiangvien());
        giothi.setText(lichthi.getGiothi());
        phongthi.setText(lichthi.getPhongthi());

        Animation anim = AnimationUtils.loadAnimation(context, R.anim.left_slide);
        view.startAnimation(anim);

        return view;
    }
}
