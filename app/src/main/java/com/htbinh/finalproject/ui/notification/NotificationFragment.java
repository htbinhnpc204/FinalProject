package com.htbinh.finalproject.ui.notification;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.htbinh.finalproject.R;
import com.htbinh.finalproject.Services.SessionServices;
import com.htbinh.finalproject.databinding.FragmentNotificationBinding;

import java.util.ArrayList;

public class NotificationFragment extends Fragment {

    private TextView txtthongbao;

    ArrayList<NotificationModel> notificationModels;
    NotificationAdapter adapter;
    private FragmentNotificationBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentNotificationBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        txtthongbao = binding.txtthongbao;
        final ListView listView = binding.notifyList;

        if(SessionServices.getListNotification() != null){
            notificationModels = SessionServices.getListNotification();
            txtthongbao.setVisibility(View.GONE);
        }
        else{
            notificationModels = new ArrayList<>();
            txtthongbao.setVisibility(View.VISIBLE);
        }
        Toast.makeText(getContext(), "" + notificationModels.size(), Toast.LENGTH_SHORT).show();

        adapter = new NotificationAdapter(container.getContext(), R.layout.item_notification, notificationModels);
        listView.setAdapter(adapter);
        return root;
    }
}