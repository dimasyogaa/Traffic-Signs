package com.yogadimas.trafficsigns.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.yogadimas.trafficsigns.R;
import com.yogadimas.trafficsigns.view.command.CommandActivity;
import com.yogadimas.trafficsigns.view.guide.GuideActivity;
import com.yogadimas.trafficsigns.view.prohibition.ProhibitionActivity;
import com.yogadimas.trafficsigns.view.warning.WarningActivity;
import com.yogadimas.trafficsigns.view.web.WebOneActivity;
import com.yogadimas.trafficsigns.view.web.WebTwoActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnGuide = findViewById(R.id.btn_guide_sign);
        Button btnCommand = findViewById(R.id.btn_command_sign);
        Button btnWarning = findViewById(R.id.btn_warning_sign);
        Button btnProhibition = findViewById(R.id.btn_prohibition_sign);
        Button btnWeb1 = findViewById(R.id.btn_web_1);
        Button btnWeb2 = findViewById(R.id.btn_web_2);
        btnGuide.setOnClickListener(this);
        btnCommand.setOnClickListener(this);
        btnWarning.setOnClickListener(this);
        btnProhibition.setOnClickListener(this);
        btnWeb1.setOnClickListener(this);
        btnWeb2.setOnClickListener(this);

    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_guide_sign:
                goToOtherActivity(GuideActivity.class);
                break;
            case R.id.btn_command_sign:
                goToOtherActivity(CommandActivity.class);
                break;
            case R.id.btn_warning_sign:
                goToOtherActivity(WarningActivity.class);
                break;
            case R.id.btn_prohibition_sign:
                goToOtherActivity(ProhibitionActivity.class);
                break;
            case R.id.btn_web_1:
                goToOtherActivity(WebOneActivity.class);
                break;
            case R.id.btn_web_2:
                goToOtherActivity(WebTwoActivity.class);
                break;
        }
    }

    private void goToOtherActivity(Class<?> cls) {
        Intent intent = new Intent(MainActivity.this, cls);
        startActivity(intent);
    }
}