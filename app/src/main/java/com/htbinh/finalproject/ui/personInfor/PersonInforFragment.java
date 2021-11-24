package com.htbinh.finalproject.ui.personInfor;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.htbinh.finalproject.R;
import com.htbinh.finalproject.databinding.FragmentNewsBinding;
import com.htbinh.finalproject.databinding.FragmentPersonInforBinding;

public class PersonInforFragment extends Fragment {

    private FragmentPersonInforBinding binding;
    private int layout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        PersonInforModel personInforModel;

        binding = FragmentPersonInforBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        personInforModel = new PersonInforModel("1911505310112", "HỒ THÁI BÌNH", "0123456789",
                "Đà Nẵng", "0987654321", "sinhvienute@gmail.com");

        final EditText stdID = binding.edtStdId;
        final EditText stdName = binding.edtName;
        final EditText stdIdCard = binding.edtIdCard;
        final EditText stdPoB = binding.edtpob;
        final EditText stdPhone = binding.edtPhone;
        final EditText stdEmail = binding.edtEmail;

        stdID.setText(personInforModel.getStdid());
        stdName.setText(personInforModel.getName());
        stdIdCard.setText(personInforModel.getCtzcard());
        stdPhone.setText(personInforModel.getPhone());
        stdPoB.setText(personInforModel.getPob());
        stdEmail.setText(personInforModel.getEmail());

        final Button btnUpdate = binding.btnUpdate;

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "You have just been updated your information!", Toast.LENGTH_SHORT).show();
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
