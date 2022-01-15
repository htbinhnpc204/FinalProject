package com.htbinh.finalproject.ui.result;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.htbinh.finalproject.Dialog.LoadingDialog;
import com.htbinh.finalproject.R;
import com.htbinh.finalproject.Services.SessionServices;
import com.htbinh.finalproject.databinding.FragmentResultBinding;
import com.htbinh.finalproject.ui.personInfo.StudentModel;
import com.htbinh.finalproject.ui.result.resultdetails.ResultDetailsModel;

import org.json.JSONArray;
import org.json.JSONObject;

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
        StudentModel sModel = SessionServices.getPersonInfoModel();
        final String api = "https://studentapp-backend.herokuapp.com/sinhvien/hkresult/details/" + sModel.getMa_sv() + "?maHk=";

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle b = new Bundle();
                String hocKy = resultModelArrayList.get(i).getHocky();
                b.putString("hocKy", hocKy);
                RequestQueue queue = Volley.newRequestQueue(getActivity());
                final LoadingDialog loading = new LoadingDialog(getActivity());
                loading.startLoading();
                ArrayList<ResultDetailsModel> list = new ArrayList<>();
                JsonArrayRequest details = new JsonArrayRequest(Request.Method.GET, api + hocKy.replaceAll("\\D", ""), null, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        loading.dismissLoading();
                        try{
                            for(int i = 0; i < response.length(); i++){
                                JSONObject obj = response.getJSONObject(i);
                                list.add(new ResultDetailsModel(
                                        obj.getString("tenMh"),
                                        obj.getString("maHp"),
                                        obj.getString("diemChu"),
                                        obj.getString("tinChi"),
                                        obj.getString("diemTk")
                                ));
                            }
                        }catch (Exception e){}
                        b.putParcelableArrayList("list", list);
                        Navigation.findNavController(view).navigate(R.id.nav_resultdetails, b);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        loading.dismissLoading();
                    }
                });

                queue.add(details);
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