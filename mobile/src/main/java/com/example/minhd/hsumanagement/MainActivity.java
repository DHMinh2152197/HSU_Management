package com.example.minhd.hsumanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtUserName, edtPassword;
    CheckBox chboxSaveInfor;
    Button btnSignIn, btnSignUp;
    TextView txtGetPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeActivity();
        setBtnSignIn();
        setBtnSignUp();
        setChboxSaveInfor();
        setTxtGetPassword();
    }

    private void initializeActivity() {
        edtUserName = findViewById(R.id.edt_userName);
        edtPassword = findViewById(R.id.edt_password);
        chboxSaveInfor = findViewById(R.id.chbox_saveInformation);
        btnSignIn = findViewById(R.id.btn_signin);
        btnSignUp = findViewById(R.id.btn_signup);
        txtGetPassword = findViewById(R.id.txt_getPassWord);
    }

    public void setChboxSaveInfor() {
        chboxSaveInfor.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(MainActivity.this, "Infor Saved", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void setBtnSignIn() {
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ControlActivity.class);
                startActivity(intent);
            }
        });
    }

    public void setBtnSignUp() {
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Sign up Clicked", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void setTxtGetPassword() {
        txtGetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Forgot Password Clicked", Toast.LENGTH_LONG).show();
            }
        });
    }
}
