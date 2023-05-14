package com.example.worldskils;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MotionEventCompat;

import java.util.Objects;

public class AppInfoActivity extends AppCompatActivity {
    TextView infoview;
    Button skip,next;
    Resources res;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appinfo);

        //основные переменные
        infoview = findViewById(R.id.infotext);
        skip = findViewById(R.id.Skip);
        next = findViewById(R.id.next);
        res = getResources();
        infoview.setText(res.getStringArray(R.array.info)[0]);


        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AppInfoActivity.this, MainActivity.class));
            }
        });

        //событие кнопки next , по нажатию идет переключение инфы и после последней страницы
        //переключениме на другую activity
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (infoview.getText().toString().equals(res.getStringArray(R.array.info)[res.getStringArray(R.array.info).length - 1]))
                    startActivity(new Intent(AppInfoActivity.this, MainActivity.class));

                for (int i = 0; i < res.getStringArray(R.array.info).length - 1; i++) {
                    if (Objects.equals(res.getStringArray(R.array.info)[i], infoview.getText().toString())) {
                        infoview.setText(res.getStringArray(R.array.info)[i + 1]);
                        break;
                    }
                }
            }
        });
    }

    @Override
    public boolean onTouchEvent (MotionEvent event){
        int action = MotionEventCompat.getActionMasked(event);
        if(action == MotionEvent.AXIS_HSCROLL) {

            for (int i = 0; i < res.getStringArray(R.array.info).length - 1; i++) {
                if (Objects.equals(res.getStringArray(R.array.info)[i], infoview.getText().toString())) {
                    infoview.setText(res.getStringArray(R.array.info)[i + 1]);
                    break;
                }
            }
        }
            return super.onTouchEvent(event);

    }
}

