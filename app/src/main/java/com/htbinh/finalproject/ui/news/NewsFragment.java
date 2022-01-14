package com.htbinh.finalproject.ui.news;

import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.htbinh.finalproject.Dialog.LoadingDialog;
import com.htbinh.finalproject.R;
import com.htbinh.finalproject.Services.PicassoImageGetter;
import com.htbinh.finalproject.Services.SessionServices;
import com.htbinh.finalproject.databinding.FragmentNewsBinding;

import java.util.ArrayList;

public class NewsFragment extends Fragment {

    ArrayList<NewsModel> newsModel;
    private FragmentNewsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentNewsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        if(SessionServices.getListNews() != null){
            newsModel = SessionServices.getListNews();
        }
        else{
            newsModel = new ArrayList<>();
        }

        final ListView listView = binding.listNews;
        NewsItemAdapter adapter = new NewsItemAdapter(container.getContext(), R.layout.item_news, newsModel);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle sendBundle = new Bundle();
                sendBundle.putString("title", newsModel.get(i).getTitle());
                String api = "https://studentapp-backend.herokuapp.com/getNewsDetails?URL=";
                RequestQueue queue = Volley.newRequestQueue(getActivity());
                final LoadingDialog loading = new LoadingDialog(getActivity());
                loading.startLoading();

                StringRequest html = new StringRequest(Request.Method.GET, api + newsModel.get(i).getDetailsLink(), new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        loading.dismissLoading();
                        sendBundle.putString("html", response);
                        Navigation.findNavController(view).navigate(R.id.nav_newsdetails, sendBundle);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        loading.dismissLoading();
                        Toast.makeText(getContext(), "Gặp lỗi khi tải tin tức, vui lòng thử lại sau!", Toast.LENGTH_SHORT).show();
                    }
                });

                queue.add(html);

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
