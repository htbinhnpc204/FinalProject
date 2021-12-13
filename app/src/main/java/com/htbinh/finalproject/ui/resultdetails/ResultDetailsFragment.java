package com.htbinh.finalproject.ui.resultdetails;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.htbinh.finalproject.databinding.FragmentResultdetailsBinding;

import java.util.ArrayList;

public class ResultDetailsFragment extends Fragment {

    ResultDetailsAdapter adapter;

    ArrayList<ResultDetailsModel> resultDetailsModelArrayList;
    private FragmentResultdetailsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        resultDetailsModelArrayList = new ArrayList<>();

        binding = FragmentResultdetailsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();






        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}


