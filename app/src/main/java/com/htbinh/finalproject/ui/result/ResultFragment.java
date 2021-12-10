package com.htbinh.finalproject.ui.result;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.htbinh.finalproject.R;
import com.htbinh.finalproject.Services.SessionServices;
import com.htbinh.finalproject.databinding.FragmentResultBinding;

import java.util.ArrayList;

public class ResultFragment extends Fragment {
    ResultAdapter adapter;
    ArrayList<ResultModel> resultModelArrayList;
    private FragmentResultBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState){


        if(SessionServices.getListResult() != null){
            resultModelArrayList = SessionServices.getListResult();
        }
        else{
            resultModelArrayList = new ArrayList<>();
        }

        binding = FragmentResultBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        final ListView listView= binding.resultList;
        adapter = new ResultAdapter(container.getContext(), R.layout.item_ketqua,resultModelArrayList);
        listView.setAdapter(adapter);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}