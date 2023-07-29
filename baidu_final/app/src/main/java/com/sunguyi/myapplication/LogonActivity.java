package com.sunguyi.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.sunguyi.myapplication.util.ToastUtil;
import com.sunguyi.myapplication.R;

public class LogonActivity extends Activity {
    private Button logon;
    private Button register;
    private Button back;
    private EditText userid;
    private EditText password;

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_log_on);

        logon = findViewById(R.id.logon);
        register = findViewById(R.id.register);
        back = findViewById(R.id.backBack);

        userid = findViewById(R.id.userid);
        password = findViewById(R.id.password);

        sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(LogonActivity.this, HomepageActivity.class);
                startActivity(intent);
            }
        });

        logon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = userid.getText().toString();
                String user_password = password.getText().toString();

                String pass = sharedPreferences.getString(username, null);

                if (pass != null && pass.equals(user_password)) {
                    Intent intent = null;
                    intent = new Intent(LogonActivity.this, LoginActivity.class);
                    intent.putExtra("name",username);
                    startActivity(intent);
                }else{
                    ToastUtil.showMsg(getApplicationContext(), "错误的用户名或者密码");
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username1 = userid.getText().toString();
                String password1 = password.getText().toString();
                String savedPassword = sharedPreferences.getString(username1, null);
                if (savedPassword != null) {
                    ToastUtil.showMsg(getApplicationContext(), "Registration failed, user already exist");
                } else if (username1.equals("")) {
                    ToastUtil.showMsg(getApplicationContext(), "Registration failed, username can't blank");
                    //showToast("Registration failed, username can't blank")
                } else if (password1.equals("")) {
                    ToastUtil.showMsg(getApplicationContext(), "Registration failed, password can't blank");
                } else {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(username1, password1);
                    editor.apply();
                    ToastUtil.showMsg(getApplicationContext(), "注册成功");

                }

            }
        });
    }


//    //匹配对应的用户名和密码才能登录
//    public void onClick(View v) {
//        //需要获取输入的用户名和密码
//        String userid1 = userid.getText().toString();
//        String password1 = password.getText().toString();
//        //弹出的内容设置
//        String ok = "登录成功！";
//        String fail = "账号或密码有误，请重新登录！";
//        String userCorrect = "njuse";
//        String passwordCorrect = "12345678";
//        Intent intent = null;
//
//        //假设账号密码如下
//        if (userid1.equals(userCorrect) && password1.equals(passwordCorrect)) {
//
//            ToastUtil.showMsg(getApplicationContext(), ok);
//
//            //正确的话进行跳转
//            Intent intent1 = null;
//            intent1 = new Intent(LogonActivity.this, LoginActivity.class);
//            startActivity(intent1);
//
//        } else {
//
//            ToastUtil.showMsg(getApplicationContext(), fail);
//        }
//    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}