package com.htbinh.finalproject.ui.result.resultdetails;

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
        tv.setText(tv.getText() + getArguments().getString("hocKy"));

        resultDetailsModelArrayList = getArguments().getParcelableArrayList("list");

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


