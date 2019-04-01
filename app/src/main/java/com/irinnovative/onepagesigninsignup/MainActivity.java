package com.irinnovative.onepagesigninsignup;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.percent.PercentLayoutHelper;
import android.support.percent.PercentRelativeLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.irinnovative.onepagesigninsignup.sql.Database;
import com.irinnovative.onepagesigninsignup.sql.User;

import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private boolean isSigninScreen = true;
    private TextView tvSignupInvoker;
    private LinearLayout llSignup;
    private TextView tvSigninInvoker;
    private LinearLayout llSignin;
    private Button btnSignup;
    private Button btnSignin;

    LinearLayout llsignin,llsignup;

    private TextInputEditText userName_Login;//登录用户名
    private TextInputEditText password_Login;
    private Button btnforget;

    private TextInputEditText user_name;
    private TextInputEditText password;
    private TextInputEditText confirmpassword;
    private Button btnreset;

    private String TAG = "++++++";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        llSignin = (LinearLayout) findViewById(R.id.llSignin);
        llSignin.setOnClickListener(this);
        //LinearLayout singnin =(LinearLayout)findViewById(R.id.signin);
        llsignup =(LinearLayout)findViewById(R.id.llSignup);
        llsignup.setOnClickListener(this);
        tvSignupInvoker = (TextView) findViewById(R.id.tvSignupInvoker);
        tvSigninInvoker = (TextView) findViewById(R.id.tvSigninInvoker);

        btnSignup= (Button) findViewById(R.id.btnSignup);
        btnSignin= (Button) findViewById(R.id.btnSignin);
        btnforget=(Button)findViewById(R.id.button_forget_password);

        llSignup = (LinearLayout) findViewById(R.id.llSignup);
        llSignin = (LinearLayout) findViewById(R.id.llSignin);

        userName_Login=(TextInputEditText)findViewById(R.id.user_name_login);
        password_Login=(TextInputEditText)findViewById(R.id.password_login);

        user_name = (TextInputEditText) findViewById(R.id.user_name);
        password = (TextInputEditText) findViewById(R.id.password);
        confirmpassword= (TextInputEditText) findViewById(R.id.confirmpassword);
        btnreset = (Button) findViewById(R.id.btnreset);

        tvSignupInvoker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isSigninScreen = false;
                showSignupForm();
            }
        });

        tvSigninInvoker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isSigninScreen = true;
                showSigninForm();
            }
        });
        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user_name.setText(null);
                password.setText(null);
                confirmpassword.setText(null);
            }
        });
        showSigninForm();

        btnforget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,ForgetPassword.class);
                startActivity(intent);
            }
        });

        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(userName_Login.getText())) {
                    Toast.makeText(MainActivity.this, "账号不可为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password_Login.getText())) {
                    Toast.makeText(MainActivity.this, "密码不可为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                Database database=Database.newInstance(getApplicationContext());
                User user = database.getUser('"'+userName_Login.getText().toString()+'"');
                if (TextUtils.isEmpty(user.getUserName())) {
                    Toast.makeText(MainActivity.this, "没有该用户", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (password_Login.getText().toString().equals(user.getPassword())) {
                        Toast.makeText(MainActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(MainActivity.this, "密码错误", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation clockwise= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_right_to_left);
                if(isSigninScreen)
                    btnSignup.startAnimation(clockwise);

                if (TextUtils.isEmpty(user_name.getText())) {
                    Toast.makeText(MainActivity.this, "账号不可为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password.getText())) {
                    Toast.makeText(MainActivity.this, "密码不可为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(confirmpassword.getText())) {
                    Toast.makeText(MainActivity.this, "请确认密码", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!TextUtils.equals(confirmpassword.getText(),password.getText())) {
                    Toast.makeText(MainActivity.this, "两次输入密码不一致！", Toast.LENGTH_SHORT).show();
                    return;
                }
                Log.i(TAG, "onClick: "+user_name.getText().toString());
                Database database = Database.newInstance(getApplicationContext());
                User user = database.getUser('"'+user_name.getText().toString()+'"');
                if (TextUtils.isEmpty(user.getUserName())) {
                    user.setPassword(password.getText().toString());
                    user.setUserName(user_name.getText().toString());
                    database.insertUser(user);
                    Toast.makeText(MainActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "已有当前用户，请重新编写用户名", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void showSignupForm() {
        PercentRelativeLayout.LayoutParams paramsLogin = (PercentRelativeLayout.LayoutParams) llSignin.getLayoutParams();
        PercentLayoutHelper.PercentLayoutInfo infoLogin = paramsLogin.getPercentLayoutInfo();
        infoLogin.widthPercent = 0.15f;
        llSignin.requestLayout();


        PercentRelativeLayout.LayoutParams paramsSignup = (PercentRelativeLayout.LayoutParams) llSignup.getLayoutParams();
        PercentLayoutHelper.PercentLayoutInfo infoSignup = paramsSignup.getPercentLayoutInfo();
        infoSignup.widthPercent = 0.85f;
        llSignup.requestLayout();

        tvSignupInvoker.setVisibility(View.GONE);
        tvSigninInvoker.setVisibility(View.VISIBLE);
        Animation translate= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.translate_right_to_left);
        llSignup.startAnimation(translate);

        Animation clockwise= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_right_to_left);
        btnSignup.startAnimation(clockwise);

    }

    private void showSigninForm() {
        PercentRelativeLayout.LayoutParams paramsLogin = (PercentRelativeLayout.LayoutParams) llSignin.getLayoutParams();
        PercentLayoutHelper.PercentLayoutInfo infoLogin = paramsLogin.getPercentLayoutInfo();
        infoLogin.widthPercent = 0.85f;
        llSignin.requestLayout();


        PercentRelativeLayout.LayoutParams paramsSignup = (PercentRelativeLayout.LayoutParams) llSignup.getLayoutParams();
        PercentLayoutHelper.PercentLayoutInfo infoSignup = paramsSignup.getPercentLayoutInfo();
        infoSignup.widthPercent = 0.15f;
        llSignup.requestLayout();

        Animation translate= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.translate_left_to_right);
        llSignin.startAnimation(translate);

        tvSignupInvoker.setVisibility(View.VISIBLE);
        tvSigninInvoker.setVisibility(View.GONE);
        Animation clockwise= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_left_to_right);
        btnSignin.startAnimation(clockwise);
    }
 @Override
    public void onClick(View v) {
        if(v.getId() == R.id.llSignin || v.getId() ==R.id.llSignup){
           // Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show();
            InputMethodManager methodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            methodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),0);
        }
    }
}