package com.htbinh.finalproject.ui.news.details;

import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.htbinh.finalproject.Services.PicassoImageGetter;
import com.htbinh.finalproject.databinding.FragmentNewsDetailsBinding;

public class NewsDetailsFragment extends Fragment {

    private FragmentNewsDetailsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentNewsDetailsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textView;
        final TextView titleView = binding.newsTitle;

        String title = getArguments().getString("title");
        String details = getArguments().getString("html");

        titleView.setText(title);
        textView.setText(details);

        PicassoImageGetter pi = new PicassoImageGetter(textView, getActivity());
        Spanned spanned = Html.fromHtml(details, pi, null);
        textView.setText(spanned);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
