package com.example.servicenovigra_livrable1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText userName,password;
    Button btnLogin_client;
    Button btnLogin_employee;
    Button btn_Admin;
    Button  btnSign_up;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName=(EditText)findViewById(R.id.et_usernameL);
        password=(EditText)findViewById(R.id.et_password);
        btnSign_up=(Button) findViewById(R.id.bt_signUp);

        btnLogin_client=(Button) findViewById(R.id.customerbt);
        btnLogin_employee=(Button) findViewById(R.id.employeebt);
        btn_Admin=(Button) findViewById(R.id.bt_Administrator);



        btnLogin_client.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((password.length() == 0)&&(userName.length()==0)) {
                    userName.setError("Enter Username");
                    password.setError("Enter password");
                }
                else if (userName.length() == 0) {
                    userName.setError("Enter Username");
                } else if (password.length() == 0) {
                    password.setError("Enter password");
                }
                else {
                    Intent intent = new Intent(getApplicationContext(), Welcome_cutomer.class);
                    String customer_name = userName.getText().toString();
                    intent.putExtra("userName", customer_name);
                    startActivity(intent);
                }

            }
        });


        btnLogin_employee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((password.length() == 0)&&(userName.length()==0)) {
                    userName.setError("Enter Username");
                    password.setError("Enter password");
                }

                if(userName.length()==0){
                    userName.setError("Enter Username");
                }
                else if(password.length()==0){
                    password.setError("Enter password");
                }

                else {
                    Intent intent = new Intent(getApplicationContext(), Welcome_employee.class);
                    String employee_name = userName.getText().toString();

                    intent.putExtra("userName", employee_name);
                    startActivity(intent);
                }


            }
        });

        btnSign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent=new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(intent);
            }
        });

        btn_Admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent=new Intent(getApplicationContext(),AdminAccount.class);
                startActivity(intent);
            }
        });





    }

}