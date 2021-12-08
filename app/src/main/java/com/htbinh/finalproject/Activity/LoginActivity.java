package com.htbinh.finalproject.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.htbinh.finalproject.Dialog.LoadingDialog;
import com.htbinh.finalproject.R;
import com.htbinh.finalproject.Services.SessionServices;
import com.htbinh.finalproject.ui.examSchedule.ExamScheduleModel;
import com.htbinh.finalproject.ui.news.NewsModel;
import com.htbinh.finalproject.ui.personInfo.StudentModel;
import com.htbinh.finalproject.ui.schedule.scheduleModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    //region AnhXa
    Dialog dialog;
    EditText tk, mk;
    CheckBox rememberMeCheck;
    ImageView appLogo;
    RelativeLayout appName;
    ConstraintLayout loginArea;
    LinearLayout buttons;
    //endregion

    //region APIlink
    private String baseURL = "https://studentapp-backend.herokuapp.com/";
    private String loginURL = "login";
    private String personInfoURL = "sinhvien/getinfo";
    private String scheduleURL = "sinhvien/gettkb";
    private String newsURL = "getNews";
    private String resultURL = "sinhvien/kqhoctap";
    private String resultDetailsURL = "sinhvien/kqhoctap/chitiet";
    private String notificationURL = "getnoti";
    private String tuitionURL = "sinhvien/getfee";
    private String examScheduleURL = "sinhvien/lichthi";
    //endregion

    Animation topAnimation;
    private boolean doubleBackToExitPressedOnce;

    private void Mapping(){
        tk = findViewById(R.id.edUser);
        mk = findViewById(R.id.edPass);
        rememberMeCheck = findViewById(R.id.cbSave);

        appLogo = findViewById(R.id.appLogo);
        appName = findViewById(R.id.appName);
        loginArea = findViewById(R.id.loginArea);
        buttons = findViewById(R.id.buttonArea);

        topAnimation = AnimationUtils.loadAnimation(this, R.anim.top_animation);

        appLogo.startAnimation(topAnimation);
        appName.startAnimation(topAnimation);
        loginArea.startAnimation(topAnimation);
        buttons.startAnimation(topAnimation);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Mapping();
        SharedPreferences sharedPreferences = getSharedPreferences("checkbox", MODE_PRIVATE);
        String rememberMeText = sharedPreferences.getString("remember","");

        if(rememberMeText.equals("true")){
            String msv = sharedPreferences.getString("msv","");
            String pass = sharedPreferences.getString("pw", "");
            tk.setText(msv);
            mk.setText(pass);
            rememberMeCheck.setChecked(true);
        }

        rememberMeCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(compoundButton.isChecked()){
                    SharedPreferences sharedPreferences = getSharedPreferences("checkbox", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("remember", "true");
                    editor.putString("msv", tk.getText().toString());
                    editor.putString("pw", mk.getText().toString());
                    editor.apply();
                }else{
                    SharedPreferences sharedPreferences = getSharedPreferences("checkbox", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("remember", "false");
                    editor.putString("msv", "");
                    editor.putString("pw", "");
                    editor.apply();
                }

            }
        });

    }

    public void doForgot(View v){
        openDialog();
    }

    private void openDialog(){
        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dia_forgot);

        Window window = dialog.getWindow();

        if(window == null){
            return;
        }

        window.setWindowAnimations(R.style.AnimationForCustomDialog);
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams params = window.getAttributes();
        params.gravity = Gravity.CENTER;

        window.setAttributes(params);

        dialog.show();
    }

    public void Close(View v) {
        dialog.dismiss();
    }

    private void goToHome(String msv, String pass){
        final LoadingDialog loading = new LoadingDialog(this);
        loading.startLoading();
        RequestQueue queue = Volley.newRequestQueue(this);
        String log = baseURL + loginURL;

        //Make all request here !!
        //region Request

        ArrayList<ExamScheduleModel> examScheduleModels = new ArrayList<>();
        JsonArrayRequest examScheduleRequest = new JsonArrayRequest(Request.Method.GET, baseURL + examScheduleURL, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for(int i = 0; i < response.length(); i++){
                            try {
                                JSONObject obj = response.getJSONObject(i);
                                examScheduleModels.add( new ExamScheduleModel(
                                        obj.getString("ngayThi"),
                                        obj.getString("tenLopHp"),
                                        obj.getString("tenHp"),
                                        obj.getString("giangVien"),
                                        obj.getString("gioThi"),
                                        obj.getString("phongThi")
                                ));
                            } catch (JSONException e) {
                                examScheduleModels.clear();
                            }
                        }
                        SessionServices.setListExamSchedule(examScheduleModels);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {examScheduleModels.clear();}
                });

        JsonObjectRequest personInfoRequest = new JsonObjectRequest(Request.Method.GET, baseURL + personInfoURL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        StudentModel personInfoModel = null;
                        try {
                             personInfoModel = new StudentModel(
                                     response.getString("ma_sv"),
                                     response.getString("ten_sv"),
                                     response.getString("lop"),
                                     response.getString("nganh"),
                                     response.getString("khoa"),
                                     response.getString("ngaySinh"),
                                     response.getString("soCMND"),
                                     response.getString("noiSinh"),
                                     response.getString("soDienThoai"),
                                     response.getString("email"),
                                     response.getString("avatarLink")
                            );
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(), "Error when creating information!!", Toast.LENGTH_LONG);

                        }
                        Toast.makeText(getApplicationContext(), "" + personInfoModel.toString(), Toast.LENGTH_LONG);
                        SessionServices.setPersonInfoModel(personInfoModel);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "Error when getting information!!", Toast.LENGTH_LONG);
                    }
                });

        ArrayList<scheduleModel> schedule = new ArrayList<>();
        JsonArrayRequest scheduleRequest = new JsonArrayRequest(Request.Method.GET, baseURL + scheduleURL, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for(int i = 0; i < response.length(); i++){
                            try {
                                JSONObject obj = response.getJSONObject(i);
                                schedule.add( new scheduleModel(
                                obj.getString("thu"),
                                obj.getString("tenHp"),
                                obj.getString("tiet"),
                                obj.getString("giangVien"),
                                obj.getString("phong")
                                ));
                            } catch (JSONException e) {

                            }
                        }
                        Toast.makeText(getApplicationContext(), schedule.size() + "", Toast.LENGTH_LONG).show();
                        SessionServices.setListSchedule(schedule);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });

                StringRequest loginRequest = new StringRequest(Request.Method.POST, log, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("true")) {
                    queue.add(examScheduleRequest);
                    queue.add(personInfoRequest);
                    queue.add(scheduleRequest);
                    loading.dismissLoading();
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                } else {
                    loading.dismissLoading();
                    Toast.makeText(getApplicationContext(), "Tài khoản hoặc mật khẩu không chính xác!"
                            , Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                loading.dismissLoading();
                Toast.makeText(getApplicationContext(), "Login error!", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            public byte[] getBody() throws AuthFailureError {
                JSONObject result = new JSONObject();
                try {
                    result.put("msv", msv);
                    result.put("password", pass);
                } catch (Exception e) {
                }
                return result.toString().getBytes(StandardCharsets.UTF_8);
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Content-Type", "application/json");
                return params;
            }
        };

        ArrayList<NewsModel> news = new ArrayList<>();
        JsonArrayRequest newsRequest = new JsonArrayRequest(Request.Method.GET, baseURL + newsURL, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for(int i = 0; i < response.length(); i++){
                            try {
                                JSONObject obj = response.getJSONObject(i);
                                news.add( new NewsModel(
                                        obj.getString("title"),
                                        obj.getString("description"),
                                        obj.getString("date"),
                                        obj.getString("imgLink"),
                                        obj.getString("detailsLink")
                                ));
                            } catch (JSONException e) {
                            }
                        }
                        SessionServices.setListNews(news);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {}
                });

        //endregion

        //Then add this into queue
        queue.add(loginRequest);
        queue.add(newsRequest);


        Toast.makeText(getApplicationContext(), "Đang đăng nhập vui lòng chờ", Toast.LENGTH_SHORT).show();
    }

    public void doLogin(View v){
        String msv = tk.getText().toString();
        String pass = mk.getText().toString();

        if(!(TextUtils.isEmpty(msv) || TextUtils.isEmpty(pass))){
            goToHome(msv, pass);
        }
        else {
            Toast.makeText(getApplicationContext(), "Tài khoản hoặc mật khẩu không được để trống"
                    , Toast.LENGTH_SHORT).show();
        }

    }

    //exit by double tap
    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(getApplicationContext(), "Swipe again to exit!", Toast.LENGTH_SHORT).show();

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }
}