package com.example.loginsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText username,password;
    Button buttonlogin;
    DBhelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.username1);
        password=(EditText) findViewById(R.id.password1);
        buttonlogin=(Button) findViewById(R.id.buttonsignin1);
        DB =new DBhelper(this);

        buttonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  String user =username.getText().toString();
                  String pass =password.getText().toString();

                  if(user.equals("")||pass.equals(""))
                      Toast.makeText(LoginActivity.this,"Please enter all the fields",Toast.LENGTH_LONG).show();
                  else{
                      Boolean checkuserpass =DB.checkusernamepassword(user,pass);
                          if(checkuserpass==true){
                              Toast.makeText(LoginActivity.this,"Sign in Successfully",Toast.LENGTH_LONG).show();
                              Intent intent=new Intent(getApplicationContext(),HomeActivity.class);
                              intent.putExtra(HomeActivity.nameextra,user);
                              startActivity(intent);
                          }
                          else{
                              Toast.makeText(LoginActivity.this,"Invalid Credentials",Toast.LENGTH_LONG).show();
                          }
                      }
                  }
        });
    }
}