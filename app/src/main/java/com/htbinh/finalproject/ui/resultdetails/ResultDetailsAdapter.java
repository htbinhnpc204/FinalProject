package com.htbinh.finalproject.ui.resultdetails;

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

public class ResultDetailsAdapter extends BaseAdapter {
    private final Context context;
    private final int layout;
    private final List<ResultDetailsModel> chitietketquaList;

    public ResultDetailsAdapter(Context context, int layout, List<ResultDetailsModel> chitietketquaList) {
        this.context = context;
        this.layout = layout;
        this.chitietketquaList = chitietketquaList;
    }

    @Override
    public int getCount() {
        return (chitietketquaList== null) ? 0 : chitietketquaList.size();
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

        view = inflater.inflate(layout,null);
        //ánh xạ view
        TextView tenMh =(TextView) view.findViewById(R.id.textviewtenhp);
        TextView maHp = (TextView) view.findViewById(R.id.textviewma);
        TextView diemChu = (TextView) view.findViewById(R.id.textviewdiemc);
        TextView tinChi = (TextView) view.findViewById(R.id.textviewsotc);
        TextView diemCc = (TextView) view.findViewById(R.id.textviewdiemcc);
        TextView diemGk = (TextView) view.findViewById(R.id.textviewdiemgk);
        TextView diemCk = (TextView) view.findViewById(R.id.textviewdiemck);
        TextView diemTk = (TextView) view.findViewById(R.id.textviewdiemtk);

        //gán giá trị
        ResultDetailsModel chitietketqua = chitietketquaList.get(i);

        tenMh.setText(chitietketqua.getTenMh());
        maHp.setText(chitietketqua.getMaHp());
        diemChu.setText(chitietketqua.getDiemChu());
        tinChi.setText(chitietketqua.getTinChi());
        diemCc.setText(chitietketqua.getDiemCc());
        diemGk.setText(chitietketqua.getDiemGk());
        diemCk.setText(chitietketqua.getDiemCk());
        diemTk.setText(chitietketqua.getDiemTk());

        Animation anim = AnimationUtils.loadAnimation(context, R.anim.left_slide);
        view.startAnimation(anim);

        return view;
    }
}
