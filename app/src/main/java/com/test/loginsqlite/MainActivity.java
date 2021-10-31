package com.test.loginsqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText username, password, repassword;
    Button btnSignup, btnSignIn;
    DBHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        repassword = (EditText) findViewById(R.id.repassword);

        btnSignIn = (Button) findViewById(R.id.btnSignIn);
        btnSignup = (Button) findViewById(R.id.btnSignUp);

        myDB = new DBHelper(this);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();


                if (user.equals("") || pass.equals("") || repass.equals("")) {
                    Toast.makeText(MainActivity.this, "Fill all the fields", Toast.LENGTH_SHORT).show();
                } else {
                    if(pass.equals(repass))
                    {
                       Boolean usercheckResult=myDB.checkUsername(user);
                       if(usercheckResult ==  false)
                       {
                          Boolean regResult = myDB.insertData(user,pass);
                       if(regResult == true){
                           Toast.makeText(MainActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                           Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                           startActivity(intent);
                       }
                       else
                       {
                           Toast.makeText(MainActivity.this, "Registration UnSuccessful", Toast.LENGTH_SHORT).show();
                       }
                       }
                       else {
                           Toast.makeText(MainActivity.this, "User already exists", Toast.LENGTH_SHORT).show();
                       }
                           
                    }

                    else
                    {
                        Toast.makeText(MainActivity.this,"Password does not match", Toast.LENGTH_SHORT).show();
                    }

                }


            }


        });
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =   new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });


    }

}
