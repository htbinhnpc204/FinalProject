package com.htbinh.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import android.app.Dialog;
import android.content.Intent;
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

public class LoginActivity extends AppCompatActivity {
    Dialog dialog;
    EditText tk, mk;
    CheckBox rememberMeCheck;
    ImageView appLogo;
    RelativeLayout appName;
    ConstraintLayout loginArea;
    LinearLayout buttons;

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
            goToHome();
        }

        rememberMeCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(compoundButton.isChecked()){
                    SharedPreferences sharedPreferences = getSharedPreferences("checkbox", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("remember", "true");
                    editor.apply();
                }else{
                    SharedPreferences sharedPreferences = getSharedPreferences("checkbox", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("remember", "false");
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

    private void goToHome(){
        Intent in = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(in);
        this.finish();
    }

    public void doLogin(View v){
        goToHome();
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