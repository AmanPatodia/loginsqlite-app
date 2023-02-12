package com.example.loginsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

     EditText username,password ,repassword;
     Button signin;
     Button signup;
     DBhelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username =(EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        repassword = (EditText) findViewById(R.id.repassword);
        signin = (Button) findViewById(R.id.buttonsignin);
        signup = (Button) findViewById(R.id.buttonsignup);
        DB=new DBhelper(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repss =repassword.getText().toString();

                if(user.equals("")||pass.equals("")||repss.equals(""))
                    Toast.makeText(MainActivity.this,"Please field all the empty lists",Toast.LENGTH_LONG).show();
                else{
                    if(pass.equals(repss)){
                        Boolean checkuser = DB.checkusername(user);
                        if(checkuser==false){
                            Boolean insert =DB.insertData(user,pass);
                            if(insert==true){
                                Toast.makeText(MainActivity.this,"Registered Successfully",Toast.LENGTH_LONG).show();
                                Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(MainActivity.this,"Regestration Failed",Toast.LENGTH_LONG).show();
                            }
                        }
                        else{
                            Toast.makeText(MainActivity.this,"User Already exixts plz sign in",Toast.LENGTH_LONG).show();
                        }
                    }
                    else{
                        Toast.makeText(MainActivity.this,"Password not matching",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}