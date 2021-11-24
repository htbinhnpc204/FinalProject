package com.htbinh.finalproject.ui.tuitionfee;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.htbinh.finalproject.R;
import com.htbinh.finalproject.databinding.FragmentTuitionfeeBinding;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TuitionfeeFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class TuitionfeeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TuitionfeeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TuitionfeeFragment newInstance(String param1, String param2) {
        TuitionfeeFragment fragment = new TuitionfeeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public TuitionfeeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    ArrayList<TuitionfeeModel> tuitionfeeModels;
    TuitionfeeAdapter adapter;
    private FragmentTuitionfeeBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        tuitionfeeModels = new ArrayList<>();

        binding = FragmentTuitionfeeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        tuitionfeeModels.add(new TuitionfeeModel("Học kì: 1","- Năm 2020-2021","21","6,862,800","676,000","7,538,800 đồng "));
        tuitionfeeModels.add(new TuitionfeeModel("Học kì: 2","- Năm 2020-2021","25","6,862,800","676,000","7,538,800 đồng "));
        tuitionfeeModels.add(new TuitionfeeModel("Học kì: 3","- Năm 2021-2022","22","6,862,800","676,000","7,538,800 đồng "));
        tuitionfeeModels.add(new TuitionfeeModel("Học kì: 4","- Năm 2021-2022","23","6,862,800","676,000","7,538,800 đồng "));
        tuitionfeeModels.add(new TuitionfeeModel("Học kì: 5","- Năm 2023-2024","24","6,862,800","676,000","7,538,800 đồng "));
        tuitionfeeModels.add(new TuitionfeeModel("Học kì: 6","- Năm 2023-2024","25","6,862,800","676,000","7,538,800 đồng "));

        final ListView listView= binding.listTuitionfee;
        adapter = new TuitionfeeAdapter(container.getContext(), R.layout.item_tuitionfee,tuitionfeeModels);
        listView.setAdapter(adapter);
        return root;
    }
}