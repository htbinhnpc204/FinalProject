package com.htbinh.finalproject.ui.personInfo;

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

import com.htbinh.finalproject.Services.SessionServices;
import com.htbinh.finalproject.databinding.FragmentPersonInforBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class PersonInfoFragment extends Fragment {

    private FragmentPersonInforBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        StudentModel personInfoModel;

        binding = FragmentPersonInforBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final EditText stdID = binding.edtStdId;
        final EditText stdName = binding.edtName;
        final EditText stdIdCard = binding.edtIdCard;
        final EditText stdPoB = binding.edtpob;
        final EditText stdPhone = binding.edtPhone;
        final EditText stdEmail = binding.edtEmail;
//        final CircleImageView img = binding.imgvAvt;

        if(SessionServices.getPersonInfoModel() != null){
            personInfoModel = SessionServices.getPersonInfoModel();
            stdID.setText(personInfoModel.getMa_sv());
            stdName.setText(personInfoModel.getTen_sv());
            stdIdCard.setText(personInfoModel.getSoCMND());
            stdPhone.setText(personInfoModel.getSoDienThoai());
            stdPoB.setText(personInfoModel.getNoiSinh());
            stdEmail.setText(personInfoModel.getEmail());

        }
        else{
            Toast.makeText(getContext(), "Lỗiiiii", Toast.LENGTH_SHORT).show();
        }

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
