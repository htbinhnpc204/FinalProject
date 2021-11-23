package com.htbinh.finalproject.ui.notification;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.htbinh.finalproject.R;
import com.htbinh.finalproject.databinding.FragmentNotificationBinding;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NotificationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NotificationFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NotificationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NotificationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NotificationFragment newInstance(String param1, String param2) {
        NotificationFragment fragment = new NotificationFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    ArrayList<NotificationModel> notificationModels;
    NotificationAdapter adapter;
    private FragmentNotificationBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        notificationModels = new ArrayList<>();

        binding = FragmentNotificationBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        notificationModels.add(new NotificationModel("Ngô Lê","12XML01","15/11/2021","Lịch thi giữa kì ngày 15/11/2021. Hình thức thi trắc nghiệm online, 30 câu, 40'. "));
        notificationModels.add(new NotificationModel("Ngô Lê","12XML01","15/11/2021","Lịch thi giữa kì ngày 15/11/2021. Hình thức thi trắc nghiệm online, 30 câu, 40'. "));
        notificationModels.add(new NotificationModel("Ngô Lê","12XML01","15/11/2021","Lịch thi giữa kì ngày 15/11/2021. Hình thức thi trắc nghiệm online, 30 câu, 40'.Lịch thi giữa kì ngày 15/11/2021. Hình thức thi trắc nghiệm online, 30 câu, 40'.Lịch thi giữa kì ngày 15/11/2021. Hình thức thi trắc nghiệm online, 30 câu, 40'. "));
        notificationModels.add(new NotificationModel("Ngô Lê","12XML01","15/11/2021","Lịch thi giữa kì ngày 15/11/2021. Hình thức thi trắc nghiệm online, 30 câu, 40'. "));
        notificationModels.add(new NotificationModel("Ngô Lê","12XML01","15/11/2021","Lịch thi giữa kì ngày 15/11/2021. Hình thức thi trắc nghiệm online, 30 câu, 40'. "));
        notificationModels.add(new NotificationModel("Ngô Lê","12XML01","15/11/2021","Lịch thi giữa kì ngày 15/11/2021. Hình thức thi trắc nghiệm online, 30 câu, 40'. "));


        final ListView listView= binding.listNotification;
        adapter = new NotificationAdapter(container.getContext(), R.layout.item_notification,notificationModels);
        listView.setAdapter(adapter);
        return root;

        // Inflate the layout for this fragment


    }
}