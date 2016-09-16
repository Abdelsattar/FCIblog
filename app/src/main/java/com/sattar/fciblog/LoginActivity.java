package com.sattar.fciblog;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.dd.CircularProgressButton;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.login_loginBT)
    CircularProgressButton circularProgressButton;

    @BindView(R.id.login_email)
    EditText emailET;
    @BindView(R.id.login_password)
    EditText passwordET;
    @BindView(R.id.login_signUpTV)
    TextView signUpTV;

    Boolean check;
    String emailStr, passwordStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initUI();

    }

    void initUI() {
        ButterKnife.bind(this);
        check = false;
        circularProgressButton.setIndeterminateProgressMode(true);
        circularProgressButton.setOnClickListener(this);
        signUpTV.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.login_loginBT: {
                login();
                break;
            }
            case R.id.login_signUpTV: {
                startActivity(new Intent(this, SignUpActivity.class));
            }
        }
    }

    boolean login() {
        check = true;
        emailStr = emailET.getText().toString();
        passwordStr = passwordET.getText().toString();

        if (emailStr.matches("")) {
            emailET.setError("Please enter your email");
            check = false;
        }
        if (passwordStr.matches("")) {
            passwordET.setError("Please enter your password");
            check = false;
        }


        if (check) {
            emailET.setEnabled(false);
            passwordET.setEnabled(false);
            circularProgressButton.setProgress(50);
            // TODO check user exist Task here
        } else {
            return check;
        }
        return  check;
    }
}
