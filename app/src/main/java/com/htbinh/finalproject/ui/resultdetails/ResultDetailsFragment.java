package com.htbinh.finalproject.ui.resultdetails;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.htbinh.finalproject.R;
import com.htbinh.finalproject.databinding.FragmentResultdetailsBinding;

import java.util.ArrayList;

public class ResultDetailsFragment extends Fragment {

    ResultDetailsAdapter adapter;

    ArrayList<ResultDetailsModel> resultDetailsModelArrayList;
    private FragmentResultdetailsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentResultdetailsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        final ListView listView = binding.resultdetailsList;

        TextView tv = binding.txtHocKy;
        tv.setText(tv.getText() + getArguments().getString("name"));

        resultDetailsModelArrayList = new ArrayList<>();
        resultDetailsModelArrayList .add(new ResultDetailsModel("Kinh tế chính trị 500231", "500231", "8,0",
                "8.0", "7.0", "10 ","8","A"));
        resultDetailsModelArrayList .add(new ResultDetailsModel("Lập trình web nâng cao ", "500231", "8,0",
                "8.0", "7.0", "8.5", "A","A"));
        resultDetailsModelArrayList .add(new ResultDetailsModel("Tin học đại cương ","500231", "2", "8,0",
                "8.0", "7.0", "8.2", "B"));
        resultDetailsModelArrayList .add(new ResultDetailsModel("Kinh tế chính trị","500231", "2", "8,0",
                "8.0", "7.0", "8.2", "B"));
        resultDetailsModelArrayList .add(new ResultDetailsModel("Kinh tế chính trị ","500231", "2", "8,0",
                "8.0", "7.0", "8.2", "B"));
        adapter = new ResultDetailsAdapter(container.getContext(), R.layout.item_chitietketqua,resultDetailsModelArrayList);
        listView.setAdapter(adapter);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}


