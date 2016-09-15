package com.sattar.fciblog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.dd.CircularProgressButton;

import butterknife.BindView;

public class SignUpActivity extends AppCompatActivity {

    @BindView(R.id.signup_signUpBT)
    CircularProgressButton circularProgressButton;

    @BindView(R.id.signup_userName)
    EditText userNameET;
    @BindView(R.id.signup_email)
    EditText emailET;
    @BindView(R.id.signup_password)
    EditText passwordET;
    @BindView(R.id.login_signUpTV)
    TextView signUpTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }
}
