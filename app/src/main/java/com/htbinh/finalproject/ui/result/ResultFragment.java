package com.htbinh.finalproject.ui.result;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import com.htbinh.finalproject.R;
import com.htbinh.finalproject.databinding.FragmentResultBinding;

import java.util.ArrayList;

public class ResultFragment extends Fragment {
    ResultAdapter adapter;

    ArrayList<ResultModel> resultModelArrayList;
    private FragmentResultBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentResultBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        final ListView listView = binding.resultList;

        resultModelArrayList = new ArrayList<>();
        resultModelArrayList.add(new ResultModel(" 1 - Năm học 2021-2022", "24","8","3","Gioi"));
        resultModelArrayList.add(new ResultModel(" 2 - Năm học 2021-2022", "20","10","4","xuat sac"));
        resultModelArrayList.add(new ResultModel(" 3 - Năm học 2021-2022", "21","6.5","2.3","Binh thuong"));
        resultModelArrayList.add(new ResultModel(" 4 - Năm học 2021-2022", "24","8","3","Gioi"));
        resultModelArrayList.add(new ResultModel(" 5 - Năm học 2021-2022", "20","10","4","xuat sac"));
        resultModelArrayList.add(new ResultModel(" 6 - Năm học 2021-2022", "21","6.5","2.3","Binh thuong"));
        adapter = new ResultAdapter(container.getContext(), R.layout.item_ketqua,resultModelArrayList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle sendBundle = new Bundle();
                sendBundle.putString("name", resultModelArrayList.get(position).getName());
                Navigation.findNavController(view).navigate(R.id.nav_resultdetails, sendBundle);
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
