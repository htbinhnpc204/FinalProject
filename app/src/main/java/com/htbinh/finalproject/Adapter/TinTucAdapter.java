package com.htbinh.finalproject.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.htbinh.finalproject.Model.TinTucModel;
import com.htbinh.finalproject.R;

import java.util.List;

public class TinTucAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<TinTucModel> TintucList;

    public TinTucAdapter(Context context, int layout, List<TinTucModel> tintucList) {
        this.context = context;
        this.layout = layout;
        TintucList = tintucList;
    }

    @Override
    public int getCount() {
        return (TintucList==null) ? 0 :TintucList.size();
    }

    @Override
    public Object getItem(int i) {
        return TintucList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout, null);

        ImageView imghinh = (ImageView) view.findViewById(R.id.hinhanh);
        TextView txtthongtin = (TextView) view.findViewById(R.id.thongtin);
        TextView txtngay = (TextView) view.findViewById(R.id.ngay);
        TextView txtnoidung = (TextView) view.findViewById(R.id.noidung);

        TinTucModel Tintuc = TintucList.get(i);

        imghinh.setImageResource(Tintuc.getHinhanh());
        txtthongtin.setText(Tintuc.getThongtin());
        txtngay.setText(Tintuc.getNgay());
        txtnoidung.setText(Tintuc.getNoidung());

        Animation anim = AnimationUtils.loadAnimation(context, R.anim.left_slide);
        view.startAnimation(anim);

        return view;
    }
}
