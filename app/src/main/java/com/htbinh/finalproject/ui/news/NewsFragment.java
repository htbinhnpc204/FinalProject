package com.htbinh.finalproject.ui.news;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.htbinh.finalproject.R;
import com.htbinh.finalproject.databinding.FragmentNewsBinding;

import java.util.ArrayList;

public class NewsFragment extends Fragment {

    ArrayList<NewsModel> newsModel;
    private FragmentNewsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        newsModel = new ArrayList<>();

        binding = FragmentNewsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        newsModel.add(new NewsModel("Bản tin thời sự DaNang TV tối ngày 12/11/2021 \"ĐẨY MẠNH CHUYỂN ĐỔI SỐ TRONG CÁC TRƯỜNG ĐẠI HỌC\"", "Bản tin thời sự DaNang TV tối ngày 12/11/2021 \"ĐẨY MẠNH CHUYỂN ĐỔI SỐ TRONG CÁC TRƯỜNG ĐẠI HỌC\"", "15 tháng 11 2021", "https://ute.udn.vn/Upload/TinTuc/hinhbia151121103153.JPG", "../../TinTuc/3635/1/Ban-tin-thoi-su-DaNang-TV-toi-ngay-12112021-DAY-MANH-CHUYEN-DOI-SO-TRONG-CAC-TRUONG-DAI-HOC.aspx"));
        newsModel.add(new NewsModel("Bản tin thời sự DaNang TV tối ngày 12/11/2021 \"ĐẨY MẠNH CHUYỂN ĐỔI SỐ TRONG CÁC TRƯỜNG ĐẠI HỌC\"", "Bản tin thời sự DaNang TV tối ngày 12/11/2021 \"ĐẨY MẠNH CHUYỂN ĐỔI SỐ TRONG CÁC TRƯỜNG ĐẠI HỌC\"", "15 tháng 11 2021", "https://ute.udn.vn/Upload/TinTuc/hinhbia151121103153.JPG", "../../TinTuc/3635/1/Ban-tin-thoi-su-DaNang-TV-toi-ngay-12112021-DAY-MANH-CHUYEN-DOI-SO-TRONG-CAC-TRUONG-DAI-HOC.aspx"));
        newsModel.add(new NewsModel("Bản tin thời sự DaNang TV tối ngày 12/11/2021 \"ĐẨY MẠNH CHUYỂN ĐỔI SỐ TRONG CÁC TRƯỜNG ĐẠI HỌC\"", "Bản tin thời sự DaNang TV tối ngày 12/11/2021 \"ĐẨY MẠNH CHUYỂN ĐỔI SỐ TRONG CÁC TRƯỜNG ĐẠI HỌC\"", "15 tháng 11 2021", "https://ute.udn.vn/Upload/TinTuc/hinhbia151121103153.JPG", "../../TinTuc/3635/1/Ban-tin-thoi-su-DaNang-TV-toi-ngay-12112021-DAY-MANH-CHUYEN-DOI-SO-TRONG-CAC-TRUONG-DAI-HOC.aspx"));
        newsModel.add(new NewsModel("Bản tin thời sự DaNang TV tối ngày 12/11/2021 \"ĐẨY MẠNH CHUYỂN ĐỔI SỐ TRONG CÁC TRƯỜNG ĐẠI HỌC\"", "Bản tin thời sự DaNang TV tối ngày 12/11/2021 \"ĐẨY MẠNH CHUYỂN ĐỔI SỐ TRONG CÁC TRƯỜNG ĐẠI HỌC\"", "15 tháng 11 2021", "https://ute.udn.vn/Upload/TinTuc/hinhbia151121103153.JPG", "../../TinTuc/3635/1/Ban-tin-thoi-su-DaNang-TV-toi-ngay-12112021-DAY-MANH-CHUYEN-DOI-SO-TRONG-CAC-TRUONG-DAI-HOC.aspx"));
        final ListView listView = binding.listNews;
        NewsItemAdapter adapter = new NewsItemAdapter(container.getContext(), R.layout.item_news, newsModel);
        listView.setAdapter(adapter);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
