package com.htbinh.finalproject.ui.result;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
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
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Bundle bundle = new Bundle();
                bundle.putString("Hocky ", resultModelArrayList.get(i).getHocky());
                String api = "https://studentapp-backend.herokuapp.com/kqhoctap/chitiet?hocKy=";
                RequestQueue queue = Volley.newRequestQueue(getActivity());

//                JsonArrayRequest resultdetailsRequest = new JsonArrayRequest(Request.Method.GET,
//                        api + URI.create(resultModelArrayList.get(i).getHocky().replaceAll(" |:|-","")), null, new Response.Listener<JSONArray>() {
//                    @Override
//                    public void onResponse(JSONArray response) {
//                        ArrayList<ResultDetailsModel> objs = new ArrayList<>();
//                        for (int i = 0; i < response.length(); i++) {
//                            try {
//                                JSONObject obj = response.getJSONObject(i);
//                                objs.add(new ResultDetailsModel(
//                                        obj.getString("tenMh"),
//                                        obj.getString("maHp"),
//                                        obj.getString("diemChu"),
//                                        obj.getString("tinChi"),
//                                        obj.getString("diemCc"),
//                                        obj.getString("diemGk"),
//                                        obj.getString("diemCk"),
//                                        obj.getString("diemTk")
//                                ));
//                            } catch (Exception e) {
//                            }
//                        }
//                        bundle.putParcelableArrayList("resultdetailsRequest", objs);
//                        Navigation.findNavController(view).navigate(R.id.nav_resultdetails, bundle);
//
//                    }
//                }, new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                          bundle.putString("Error", error.toString());
//
//                    }
//                });
//                queue.add(resultdetailsRequest);
                Toast.makeText(getContext(), resultModelArrayList.get(i).getHocky().replaceAll("\\D",""), Toast.LENGTH_SHORT).show();
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