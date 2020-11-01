package com.example.servicenovigra_livrable1;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {
    EditText mail,password;
    Button btnLogin_client;
    Button btnLogin_employee;
    Button btn_Admin;
    Button  btnSign_up;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;

    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mail=(EditText)findViewById(R.id.mail);
        password=(EditText)findViewById(R.id.et_password);
        btnSign_up=(Button) findViewById(R.id.bt_signUp);

        btnLogin_client=(Button) findViewById(R.id.customerbt);
        btnLogin_employee=(Button) findViewById(R.id.employeebt);
        btn_Admin=(Button) findViewById(R.id.bt_Administrator);
        fAuth=FirebaseAuth.getInstance();
        fStore=FirebaseFirestore.getInstance();





        btnLogin_client.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mail.getText().toString().isEmpty()) {
                    mail.setError("enter your mail address");
                }else {
                    if (!(mail.getText().toString().trim().matches(emailPattern))) {
                        mail.setError("invalid mail address");
                    }
                }
                if(password.length()==0){
                    password.setError("Enter password");
                }
                else {
                    Intent intent = new Intent(getApplicationContext(), Welcome_cutomer.class);
                    String customer_name = mail.getText().toString();
                    intent.putExtra("userName", customer_name);
                    startActivity(intent);
                }

            }
        });


//        btnLogin_employee.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //if ((password.length() == 0)&&(userName.length()==0)) {
//                    //userName.setError("Enter Username");
//                   // password.setError("Enter password");
//                }
//
//                if(userName.length()==0){
//                    userName.setError("Enter Username");
//                }
//                else if(password.length()==0){
//                    password.setError("Enter password");
//                }
//
//                else {
//                    Intent intent = new Intent(getApplicationContext(), Welcome_employee.class);
//                    String employee_name = userName.getText().toString();
//
//                    intent.putExtra("userName", employee_name);
//                    startActivity(intent);
//                }
//
//
//            }
//
//        });

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
                Intent intent=new Intent(getApplicationContext(),Admin_Options.class);
                startActivity(intent);
            }
        });





    }
    @Override
    protected void onStart() {
        super.onStart();
        if (FirebaseAuth.getInstance().getCurrentUser()!=null){
            startActivity(new Intent(getApplicationContext(),Admin_Options.class));
            finish();
        }
    }


}