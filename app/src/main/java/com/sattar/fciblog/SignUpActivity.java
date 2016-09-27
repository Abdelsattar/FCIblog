package com.sattar.fciblog;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.dd.CircularProgressButton;
import com.sattar.fciblog.Adapters.ImageAdapter;
import com.sattar.fciblog.Helpers.GridViewScrollable;
import com.sattar.fciblog.Helpers.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {


    @BindView(R.id.signup_profile_pic)
    ImageView profileImage;
    @BindView(R.id.signup_signUpBT)
    CircularProgressButton circularProgressButton;

    @BindView(R.id.signup_userName)
    EditText userName;
    @BindView(R.id.signup_email)
    EditText email;
    @BindView(R.id.signup_password)
    EditText password;
    @BindView(R.id.signup_loginTV)
    TextView signUpTV;

    String userNameStr, emailStr, passwordStr;
    Integer imageID;
    ProgressDialog progressDialog;
    boolean check;
    public Integer[] mThumbIds
            = {
            R.drawable.pic_0, R.drawable.pic_2,
            R.drawable.pic_3, R.drawable.pic_4,
            R.drawable.pic_5, R.drawable.pic_6,
            R.drawable.pic_7, R.drawable.pic_8,
            R.drawable.pic_9, R.drawable.pic_10,
            R.drawable.pic_11, R.drawable.pic_12,
            R.drawable.pic_13, R.drawable.pic_14,
            R.drawable.pic_15, R.drawable.pic_16,
            R.drawable.pic_17, R.drawable.pic_18,
            R.drawable.pic_19, R.drawable.pic_20,
            R.drawable.pic_21, R.drawable.pic_22,
            R.drawable.pic_23, R.drawable.pic_24,

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        initUI();
    }

    void initUI() {
        ButterKnife.bind(this);
        imageID = 0;

        circularProgressButton.setOnClickListener(this);
        signUpTV.setOnClickListener(this);

        GridViewScrollable gridView = (GridViewScrollable) findViewById(R.id.grid_view);

        // Instance of ImageAdapter Class
        gridView.setAdapter(new ImageAdapter(this, mThumbIds));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                profileImage.setImageResource(mThumbIds[position]);
//                int integer = 2130837624;
//                profileImage.setImageResource(integer);
                Log.d("Image_ID", imageID + "");

            }
        });
    }

    public ProgressDialog makeProgressBar(String message) {
        progressDialog = new ProgressDialog(this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage(message);
        return progressDialog;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.signup_signUpBT: {
                if (signUp()) {
                    //TODO make signUp Task here
                    Intent intent = new Intent(this, HomeActivity.class);
//                intent.putExtra("image_ID", imageID);
                    startActivity(intent);
                }

                break;
            }
            case R.id.signup_loginTV: {
                finish();
                break;
            }
        }
    }

    // TODO add a custom dialog with a view that in it image view with image icon
    boolean signUp() {
        check = false;
        userNameStr = userName.getText().toString();
        emailStr = email.getText().toString();
        passwordStr = password.getText().toString();

        if (emailStr.matches("")) {
            email.setError("Please enter your email");
            check = false;
        } else {
            if (!Utils.isEmailValid(emailStr)) {
                email.setError("Email is not valid");
                check = false;
            }
        }
        if (passwordStr.matches("")) {
            password.setError("Please enter your password");
            check = false;
        }
        if (userNameStr.matches("")) {
            userName.setError("Please enter your password");
            check = false;
        }


        if (check) {
            email.setEnabled(false);
            password.setEnabled(false);
            userName.setEnabled(false);
            circularProgressButton.setProgress(50);
            // TODO check user exist Task here
        } else {
            return check;
        }
        return check;
    }

    public void setGridViewHeightBasedOnChildren(GridView gridView, int columns) {
        ListAdapter listAdapter = gridView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = 0;
        int items = listAdapter.getCount();
        int rows = 0;

        View listItem = listAdapter.getView(0, null, gridView);
        listItem.measure(0, 0);
        totalHeight = listItem.getMeasuredHeight();

        float x = 1;
        if (items > columns) {
            x = items / columns;
            rows = (int) (x + 1);
            totalHeight *= rows;
        }

        ViewGroup.LayoutParams params = gridView.getLayoutParams();
        params.height = totalHeight;
        gridView.setLayoutParams(params);

    }
}

