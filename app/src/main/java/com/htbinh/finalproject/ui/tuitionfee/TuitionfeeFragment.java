package com.htbinh.finalproject.ui.tuitionfee;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.htbinh.finalproject.R;
import com.htbinh.finalproject.Services.SessionServices;
import com.htbinh.finalproject.databinding.FragmentTuitionfeeBinding;

import java.util.ArrayList;

public class TuitionfeeFragment extends Fragment {

    ArrayList<TuitionfeeModel> tuitionfeeModels;
    TuitionfeeAdapter adapter;
    private FragmentTuitionfeeBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if(SessionServices.getListTuition() != null){
            tuitionfeeModels = SessionServices.getListTuition();
        }
        else{
            tuitionfeeModels = new ArrayList<>();
        }

        binding = FragmentTuitionfeeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final ListView listView= binding.listTuitionfee;
        adapter = new TuitionfeeAdapter(container.getContext(), R.layout.item_tuitionfee,tuitionfeeModels);
        listView.setAdapter(adapter);


        return root;
    }
}