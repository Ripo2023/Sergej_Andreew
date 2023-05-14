package com.example.worldskils;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    EditText phone;
    Button next;
    CheckBox privatpolicy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phone.findViewById(R.id.editTextPhone);
        next.findViewById(R.id.chip);
        privatpolicy.findViewById(R.id.checkBox);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(privatpolicy.callOnClick()){
                    
                }
            }
        });







    }
}