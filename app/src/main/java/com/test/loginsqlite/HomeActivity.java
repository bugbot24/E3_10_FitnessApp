package com.test.loginsqlite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    Button btnbmi, btnrun;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnbmi = (Button) findViewById(R.id.btnbmi);
        btnrun = (Button)  findViewById(R.id.btnrun);
        btnbmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBmiActivity();
            }
        });
        btnrun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openrunner();
            }
        });


    }

    private void openrunner() {
        Intent intent1 = new Intent(this,runner.class);
    }


    private void openBmiActivity() {
        Intent intent = new Intent(this,BmiActivity.class);
        startActivity(intent);




    }


    }