package com.htbinh.finalproject.Activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
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
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
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
import com.htbinh.finalproject.ui.notification.NotificationModel;
import com.htbinh.finalproject.ui.personInfo.StudentModel;
import com.htbinh.finalproject.ui.result.ResultModel;
import com.htbinh.finalproject.ui.schedule.ScheduleModel;
import com.htbinh.finalproject.ui.tuitionfee.TuitionfeeModel;

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

    private final String baseURL = "https://studentapp-backend.herokuapp.com/";
    private final String loginURL = "login";
    private final String personInfoURL = "sinhvien/getinfo";
    private final String scheduleURL = "sinhvien/schedule/";
    private final String newsURL = "getNews";
    private final String resultURL = "sinhvien/hkresult/";
    private final String notificationURL = "sinhvien/getnoti";
    private final String tuitionURL = "sinhvien/getfee/";
    private final String examScheduleURL = "sinhvien/examSchedule/";

    //endregion

    Animation topAnimation;
    private boolean doubleBackToExitPressedOnce;

    private void Mapping() {
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
        String rememberMeText = sharedPreferences.getString("remember", "");

        if (rememberMeText.equals("true")) {
            String msv = sharedPreferences.getString("msv", "");
            String pass = sharedPreferences.getString("pw", "");
            tk.setText(msv);
            mk.setText(pass);
            rememberMeCheck.setChecked(true);
        }

        rememberMeCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (compoundButton.isChecked()) {
                    SharedPreferences sharedPreferences = getSharedPreferences("checkbox", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("remember", "true");
                    editor.putString("msv", tk.getText().toString());
                    editor.putString("pw", mk.getText().toString());
                    editor.apply();
                } else {
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

    public void doForgot(View v) {
        openDialog();
    }

    private void openDialog() {
        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dia_forgot);

        Window window = dialog.getWindow();

        if (window == null) {
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

    private void goToHome(String msv, String pass) {
        final LoadingDialog loading = new LoadingDialog(this);
        loading.startLoading();
        RequestQueue queue = Volley.newRequestQueue(this);
        JSONObject loginJSON = new JSONObject();
        try {
            loginJSON.put("msv", msv);
            loginJSON.put("password", pass);
        } catch (Exception e) {
        }
        String loginString = loginJSON.toString();

        //Make all request here !!
        //region Request
        //notification
        ArrayList<NotificationModel> notification = new ArrayList<>();
        JsonArrayRequest notificationRequest = new JsonArrayRequest(Request.Method.GET, getLink(baseURL, notificationURL, msv), null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Toast.makeText(getApplicationContext(), response.length() + "", Toast.LENGTH_LONG).show();
                        for(int i = 0; i < response.length(); i++){
                            try {
                                JSONObject obj = response.getJSONObject(i);
                                notification.add( new NotificationModel(
                                        obj.getString("tengv"),
                                        obj.getString("lophp"),
                                        obj.getString("ngaynhan"),
                                        obj.getString("noidung")
                                ));
                            } catch (JSONException e) {
                            }
                        }
                        SessionServices.setListNotification(notification);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "notification could not be loaded!", Toast.LENGTH_SHORT).show();
                    }
                });

                //tuitionfee
                ArrayList<TuitionfeeModel> tuitionfee = new ArrayList<>();
                JsonArrayRequest tuitionfeeRequest = new JsonArrayRequest(Request.Method.GET, getLink(baseURL, tuitionURL, msv), null,
                    new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Toast.makeText(getApplicationContext(), response.length() + "", Toast.LENGTH_LONG).show();
                        for(int i = 0; i < response.length(); i++){
                            try {
                                JSONObject obj = response.getJSONObject(i);
                                tuitionfee.add( new TuitionfeeModel(
                                        obj.getString("hocKy"),
                                        obj.getString("soTinChi"),
                                        obj.getString("hocPhi"),
                                        obj.getString("noKyTruoc"),
                                        obj.getString("tong")
                                ));
                            } catch (JSONException e) {
                            }
                        }
                        SessionServices.setListTuition(tuitionfee);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "Tuition could not be loaded!", Toast.LENGTH_SHORT).show();
                    }
                });


//        ArrayList<ResultModel> result = new ArrayList<>();
//        JsonArrayRequest resultRequest = new JsonArrayRequest(Request.Method.GET, getLink(baseURL, resultURL, msv), null,
//                new Response.Listener<JSONArray>() {
//                    @Override
//                    public void onResponse(JSONArray response) {
//                        for (int i = 0; i < response.length(); i++) {
//                            try {
//                                JSONObject obj = response.getJSONObject(i);
//                                result.add(new ResultModel(
//                                        obj.getString("hocKy"),
//                                        obj.getString("soTcTichLuy"),
//                                        obj.getString("xepLoai"),
//                                        obj.getString("diemTbcHocKy"),
//                                        obj.getString("diemTbcHocBong")
//                                ));
//                            } catch (JSONException e) {
//
//                            }
//                        }
//                        SessionServices.setListResult(result);
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        result.clear();
//                    }
//                });
//
//        //notification
//        ArrayList<NotificationModel> notification = new ArrayList<>();
//        JsonArrayRequest notificationRequest = new JsonArrayRequest(Request.Method.GET, getLink(baseURL, notificationURL, msv), null,
//                new Response.Listener<JSONArray>() {
//                    @Override
//                    public void onResponse(JSONArray response) {
//                        if(response.length() > 0){
//                            Toast.makeText(getApplicationContext(), "Bạn có: " + response.length() + " thông báo từ giảng viên", Toast.LENGTH_SHORT).show();
//                        }
//                        for (int i = 0; i < response.length(); i++) {
//                            try {
//                                JSONObject obj = response.getJSONObject(i);
//                                notification.add(new NotificationModel(
//                                        obj.getString("from"),
//                                        obj.getString("toClasses"),
//                                        obj.getString("date"),
//                                        obj.getString("details")
//                                ));
//                            } catch (JSONException e) {
//                            }
//                        }
//                        SessionServices.setListNotification(notification);
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Toast.makeText(getApplicationContext(), "Notification could not be loaded!", Toast.LENGTH_SHORT).show();
//                    }
//                });
//

        ArrayList<ExamScheduleModel> examScheduleModels = new ArrayList<>();
        JsonArrayRequest examScheduleRequest = new JsonArrayRequest(Request.Method.GET, getLink(baseURL, examScheduleURL, msv), null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject obj = response.getJSONObject(i);
                                examScheduleModels.add(new ExamScheduleModel(
                                        obj.getString("ngaythi"),
                                        obj.getString("tenlhp"),
                                        obj.getString("tenhp"),
                                        obj.getString("giangvien"),
                                        obj.getString("giothi"),
                                        obj.getString("phongthi")
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
                    public void onErrorResponse(VolleyError error) {
                        examScheduleModels.clear();
                    }
                });

        JsonObjectRequest personInfoRequest = new JsonObjectRequest(Request.Method.GET, getLink(baseURL, personInfoURL, msv), null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e("Info log", "" + response.toString());
                        StudentModel personInfoModel = null;
                        try {
                            personInfoModel = new StudentModel(
                                    response.getString("ma_sv"),
                                    response.getString("ten_sv"),
                                    response.getString("lop"),
                                    response.getString("nganh"),
                                    response.getString("ngaySinh"),
                                    response.getString("soCMND"),
                                    response.getString("noiSinh"),
                                    response.getString("soDienThoai"),
                                    response.getString("email")
                            );
                        } catch (JSONException e) {
                            Log.e("Info log", "" + e.toString());
                        }
                        SessionServices.setPersonInfoModel(personInfoModel);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Info log", "" + error.toString());

                        Toast.makeText(getApplicationContext(), "Error when getting information!!", Toast.LENGTH_LONG);
                    }
                });
        personInfoRequest.setRetryPolicy(new DefaultRetryPolicy(
                30000, //set timeout 30s
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
//
//        ArrayList<ScheduleModel> schedule = new ArrayList<>();
//        JsonArrayRequest scheduleRequest = new JsonArrayRequest(Request.Method.GET, getLink(baseURL, scheduleURL, msv), null,
//                new Response.Listener<JSONArray>() {
//                    @Override
//                    public void onResponse(JSONArray response) {
//                        for (int i = 0; i < response.length(); i++) {
//                            try {
//                                JSONObject obj = response.getJSONObject(i);
//                                schedule.add(new ScheduleModel(
//                                        obj.getString("thu"),
//                                        obj.getString("tenHp"),
//                                        obj.getString("tiet"),
//                                        obj.getString("giangVien"),
//                                        obj.getString("phong")
//                                ));
//                            } catch (JSONException e) {
//
//                            }
//                        }
//                        SessionServices.setListSchedule(schedule);
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//            }
//        });

        ArrayList<ScheduleModel> schedule = new ArrayList<>();
        JsonArrayRequest scheduleRequest = new JsonArrayRequest(Request.Method.GET, getLink(baseURL, scheduleURL, msv), null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject obj = response.getJSONObject(i);
                                schedule.add(new ScheduleModel(
                                        obj.getString("thu"),
                                        obj.getString("tenHp"),
                                        obj.getString("tiet"),
                                        obj.getString("giangVien"),
                                        obj.getString("phong")
                                ));
                            } catch (JSONException e) {

                            }
                        }
                        SessionServices.setListSchedule(schedule);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });

        ArrayList<NewsModel> news = new ArrayList<>();
        JsonArrayRequest newsRequest = new JsonArrayRequest(Request.Method.GET, baseURL + newsURL, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject obj = response.getJSONObject(i);
                                news.add(new NewsModel(
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

                        loading.dismissLoading();
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        loading.dismissLoading();
                        Toast.makeText(getApplicationContext(), "Lỗi đăng nhập, vui lòng thử lại sau!", Toast.LENGTH_SHORT).show();
                    }
                });

        StringRequest loginRequest = new StringRequest(Request.Method.POST, baseURL + loginURL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("true")) {
                    queue.add(newsRequest);
                    queue.add(personInfoRequest);
                    queue.add(scheduleRequest);
                    queue.add(examScheduleRequest);
                    queue.add(tuitionfeeRequest);
//                    queue.add(notificationRequest);
//                    queue.add(resultRequest);
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
                Toast.makeText(getApplicationContext(), "Lỗi đăng nhập, vui lòng thử lại sau!", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            public byte[] getBody() throws AuthFailureError {
                return loginString.getBytes(StandardCharsets.UTF_8);
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Content-Type", "application/json");
                return params;
            }
        };
        //endregion
        queue.add(loginRequest);
        Toast.makeText(getApplicationContext(), "Đang đăng nhập vui lòng chờ", Toast.LENGTH_SHORT).show();
    }

    public void doLogin(View v) {
        String msv = tk.getText().toString();
        String pass = mk.getText().toString();

        if (!(TextUtils.isEmpty(msv) || TextUtils.isEmpty(pass))) {
            goToHome(msv, pass);
        } else {
            Toast.makeText(getApplicationContext(), "Tài khoản hoặc mật khẩu không được để trống"
                    , Toast.LENGTH_SHORT).show();
        }
    }
//ua sao day
    private String getLink(String base, String api, String msv) {
        return base + api + msv;
    }

//    private String getLink(String base, String api, String msv) {
//        return base + api + "?SessionID=" + msv;
//    }

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
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }
}