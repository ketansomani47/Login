package com.example.lenovog580.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class secondActivity extends AppCompatActivity {
    Button lbtn,rbtn;
    EditText etn,etm,ete,etp,etcp;
    RadioGroup rg;
    CheckBox cb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        init();
        methodListener();
    }
    private void init() {
        //button
        lbtn= (Button) findViewById(R.id.lbtn);
        rbtn= (Button) findViewById(R.id.rbtn);

        //edit text
        etn= (EditText) findViewById(R.id.etn);
        etm= (EditText) findViewById(R.id.etm);
        ete= (EditText) findViewById(R.id.ete);
        etp= (EditText) findViewById(R.id.etp);
        etcp= (EditText) findViewById(R.id.etcp);

        //radio group
        rg= (RadioGroup) findViewById(R.id.rg);

        //checkbox
        cb= (CheckBox) findViewById(R.id.cb );

    }
    private void methodListener() {
        lbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
        rbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                register();
            }

        });
    }

    private void register() {
        rbtn.getText();
        String name = etn.getText().toString();
        String mobile = etm.getText().toString();
        String email = ete.getText().toString();
        String password = etp.getText().toString();
        String cpassword = etcp.getText().toString();
        int selectid=rg.getCheckedRadioButtonId();

        if (name.equals("") || mobile.equals("") || email.equals("") || password.equals("") || cpassword.equals("")) {
            Toast.makeText(secondActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();


        } else if (!name.matches("[a-zA-z\\s]+[\\.{0,1}[a-zA-z]]+")) {
            Toast.makeText(secondActivity.this, "fill valid name", Toast.LENGTH_SHORT).show();
        } else if (!mobile.matches("[789][0-9]{9}")) {
            Toast.makeText(secondActivity.this, "enter 10 digit number", Toast.LENGTH_SHORT).show();
        } else if (!email.matches("[a-zA-Z0-9][a-zA-z0-9_.]*@[a-zA-z0-9]+([.][a-zA-Z]+)+")) {
            Toast.makeText(secondActivity.this, "enter valid email", Toast.LENGTH_SHORT).show();
        } else if (!password.matches(".*|| password.length()<6")) {
            Toast.makeText(secondActivity.this, "enter valid password", Toast.LENGTH_SHORT).show();
        } else if (!cpassword.matches(password)) {
            Toast.makeText(secondActivity.this, "password not matched", Toast.LENGTH_SHORT).show();
        }
        else if (selectid==-1) {
            Toast.makeText(secondActivity.this, "Select gender", Toast.LENGTH_SHORT).show();
        }
        else if(!cb.isChecked()){
            Toast.makeText(secondActivity.this, "select tems and condition", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(secondActivity.this, "Registred Successfully", Toast.LENGTH_SHORT).show();
            etn.setText("");
            etm.setText("");
            ete.setText("");
            etp.setText("");
            etcp.setText("");
            rg.clearCheck();
            cb.toggle();
        }


    }

    private void login() {
        lbtn.getText();
        Intent intent=new Intent(secondActivity.this,MainActivity.class);
        startActivity(intent);
        finish();

    }
}
