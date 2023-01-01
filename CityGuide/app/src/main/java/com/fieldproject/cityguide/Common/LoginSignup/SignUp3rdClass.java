package com.fieldproject.cityguide.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.fieldproject.cityguide.R;
import com.fieldproject.cityguide.User.UserDashboard;

public class SignUp3rdClass extends AppCompatActivity {


    //Variable
    ImageView backBtn;
    Button next, login;
    TextView titleText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up3rd_class);

        //Hooks
        backBtn = findViewById(R.id.signup_back_button);
        next = findViewById(R.id.signup_next_button);
        login = findViewById(R.id.signup_login_button);
        titleText = findViewById(R.id.signup_title_text);
    }

    public void callNextSignup3Screen(View view) {
        Intent intent = new Intent(getApplicationContext(), UserDashboard.class);

        Pair[] pairs = new Pair[4];
        pairs[0] = new Pair<View, String>(backBtn, "transition_back_arrow_btn");
        pairs[1] = new Pair<View, String>(next, "signup_next_button");
        pairs[2] = new Pair<View, String>(login, "signup_login_button");
        pairs[3] = new Pair<View, String>(titleText, "transition_login_btn");

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUp3rdClass.this, pairs);
        startActivity(intent, options.toBundle());

    }
}