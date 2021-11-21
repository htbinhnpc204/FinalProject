package com.htbinh.finalproject.ui.notification;

import android.content.Context;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.htbinh.finalproject.R;

import java.util.List;

public class NotificationAdapter extends BaseAdapter {
private Context context;
private int layout;
private List<NotificationModel> arraylist;

    public NotificationAdapter(Context context, int layout, List<NotificationModel> arraylist) {
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

        LayoutInflater inflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        view =inflater.inflate(layout,null);

        NotificationModel THONGBAO = arraylist.get(i);
        //ánh xạ
        ConstraintLayout itemThongbao = view.findViewById(R.id.itemThongbao);
        LinearLayout itemnoidung = view.findViewById(R.id.itemnoidung);
        TextView noidung= view.findViewById(R.id.textviewnoidung);
        TextView  xemchitiet = view.findViewById(R.id.textviewxemchitiet);
        TextView tengv =view.findViewById(R.id.textviewgv);
        TextView lophp = view.findViewById(R.id.textviewlhp);
        TextView ngaynhan = view.findViewById(R.id.textviewnn);

        tengv.setText(THONGBAO.getTengv());
        lophp.setText(THONGBAO.getLophp());
        ngaynhan.setText(THONGBAO.getNgaynhan());
        noidung.setText(THONGBAO.getNoidung());

        Animation anim = AnimationUtils.loadAnimation(context, R.anim.left_slide);
        view.startAnimation(anim);



        xemchitiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(itemnoidung.getVisibility() == View.GONE){
                    xemchitiet.setText("Thu gọn");
                    TransitionManager.beginDelayedTransition(itemThongbao, new AutoTransition());
                    itemnoidung.setVisibility(View.VISIBLE);
                }else{
                    xemchitiet.setText("Xem thêm");
                    TransitionManager.beginDelayedTransition(itemThongbao, new AutoTransition());
                    itemnoidung.setVisibility(View.GONE);
                }
            }
        });
        return view;


    }

}
