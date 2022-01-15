package com.htbinh.finalproject.ui.tuitionfee;

import android.content.Context;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.htbinh.finalproject.R;

import java.util.List;

public class TuitionfeeAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<TuitionfeeModel> arrayList;

    public TuitionfeeAdapter(Context context, int layout, List<TuitionfeeModel> arrayList) {
        this.context = context;
        this.layout = layout;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
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
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        view =inflater.inflate(layout,null);

        TuitionfeeModel HOCPHI = arrayList.get(i);
        //anh xa
        RelativeLayout itemhocphi = view.findViewById(R.id.itemHocphi);
        ConstraintLayout itemnoidunghp = view.findViewById(R.id.itemnoidunghocphi);
        TextView hocky= view.findViewById(R.id.textviewhocky);
        TextView xemchitiethp = view.findViewById(R.id.textviewxemchitiethocphi);
        TextView sotcdk =view.findViewById(R.id.textviewsotcdk);
        TextView hocphipn = view.findViewById(R.id.textviewhppn);
        TextView sonokt = view.findViewById(R.id.textviewsonkt);
        TextView tongtien = view.findViewById(R.id.textviewtongtienpn);

        hocky.setText("Học kỳ: " + HOCPHI.getHocki());
        sotcdk.setText(HOCPHI.getStcdk());
        hocphipn.setText(HOCPHI.getHocphipn());
        sonokt.setText(HOCPHI.getSonokt());
        tongtien.setText(HOCPHI.getTongtien());

        Animation anim = AnimationUtils.loadAnimation(context, R.anim.left_slide);
        view.startAnimation(anim);



        xemchitiethp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(itemnoidunghp.getVisibility() == View.GONE){
                    xemchitiethp.setText("Thu gọn");
                    TransitionManager.beginDelayedTransition(itemhocphi, new AutoTransition());
                    itemnoidunghp.setVisibility(View.VISIBLE);
                }else{
                    xemchitiethp.setText("Xem chi tiết");
                    TransitionManager.beginDelayedTransition(itemhocphi, new AutoTransition());
                    itemnoidunghp.setVisibility(View.GONE);
                }
            }
        });
        return view;
    }
}
