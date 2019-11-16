package com.example.lenovog580.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "login";
    Button lbtn,fpbtn,rbtn;
    EditText ete,etp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        methodListener();


    }


    private void init() {
        ete = (EditText) findViewById(R.id.ete);
        etp = (EditText) findViewById(R.id.etp);
        lbtn = (Button) findViewById(R.id.lbtn);
        rbtn =(Button) findViewById(R.id.rbtn);

    }
    private void methodListener() {
        lbtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                String enteredEmail = ete.getText().toString();
                String enteredPass = etp.getText().toString();
                if (enteredEmail.equals("") || enteredPass.equals("")) {
                    Toast.makeText(MainActivity.this, "Fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    if (enteredEmail.equals("admin@admin") && enteredPass.equals("admin")) {
                        Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        ete.setText("");
                        etp.setText("");
                    } else {
                        Toast.makeText(MainActivity.this, "Login Unsuccessful", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        rbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });
    }

    private void register() {

        Intent intent=new Intent(MainActivity.this,secondActivity.class);
        startActivity(intent);
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }
}
