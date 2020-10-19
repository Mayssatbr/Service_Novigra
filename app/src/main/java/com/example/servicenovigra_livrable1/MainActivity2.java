package com.example.servicenovigra_livrable1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {
    EditText FirstName,LastName,mail,userName,password,ConfirmPass;
    Button Submit_customer;
    Button Submit_employee;
    Button btnRetour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        FirstName=(EditText)findViewById(R.id.et_firstName);
        LastName=(EditText)findViewById(R.id.et_lastName);
        mail=(EditText)findViewById(R.id.mail);
        userName=(EditText)findViewById(R.id.et_usernameS);
        password=(EditText)findViewById(R.id.et_password);
        ConfirmPass=(EditText)findViewById(R.id.et_confirmPassword);
        btnRetour=(Button) findViewById(R.id.bt_login);

        Submit_customer=(Button) findViewById(R.id.bt_customer);
        Submit_employee=(Button) findViewById(R.id.bt_employee);

        btnRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        Submit_employee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((password.length() == 0)&&(userName.length()==0)) {
                    userName.setError("Enter Username");
                    password.setError("Enter password");
                    FirstName.setError("Enter First name");
                    LastName.setError("Enter Last name");
                    ConfirmPass.setError("Please Confirm Password");
                    mail.setError("Enter Email");

                }

                if(userName.length()==0){
                    userName.setError("Enter Username");
                }
                else if(password.length()==0){
                    password.setError("Enter password");
                }
                else if(FirstName.length()==0){
                    FirstName.setError("Enter First name");
                }
                else if(LastName.length()==0){
                    LastName.setError("Enter Last name");
                }
                else if(ConfirmPass.length()==0){
                    ConfirmPass.setError("Please confirm the Password");
                }
                else if(mail.length()==0){
                    mail.setError("Enter Email");
                }

                else {
                    Intent intent = new Intent(getApplicationContext(), Welcome_employee.class);
                    String employee_name = userName.getText().toString();

                    intent.putExtra("userName", employee_name);
                    startActivity(intent);
                }


            }
        });

        Submit_customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((password.length() == 0)&&(userName.length()==0)) {
                    userName.setError("Enter Username");
                    password.setError("Enter password");
                    FirstName.setError("Enter First name");
                    LastName.setError("Enter Last name");
                    ConfirmPass.setError("Please Confirm Password");
                    mail.setError("Enter Email");

                }

                if(userName.length()==0){
                    userName.setError("Enter Username");
                }
                else if(password.length()==0){
                    password.setError("Enter password");
                }
                else if(FirstName.length()==0){
                    FirstName.setError("Enter First name");
                }
                else if(LastName.length()==0){
                    LastName.setError("Enter Last name");
                }
                else if(ConfirmPass.length()==0){
                    ConfirmPass.setError("Please confirm the Password");
                }
                else if(mail.length()==0){
                    mail.setError("Enter Email");
                }

                else {
                    Intent intent = new Intent(getApplicationContext(), Welcome_employee.class);
                    String employee_name = userName.getText().toString();

                    intent.putExtra("userName", employee_name);
                    startActivity(intent);
                }


            }
        });
        Submit_employee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (password != ConfirmPass) {
                    Intent intent = new Intent(getApplicationContext(), Welcome_employee.class);
                    String employee_name = userName.getText().toString();

                    intent.putExtra("userName", employee_name);
                    startActivity(intent);


                }
                else {
                    ConfirmPass.setError("Please use the same password");
                }
            }
        });
        Submit_employee.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ShowToast")
            @Override
            public void onClick(View v) {
                if (android.util.Patterns.EMAIL_ADDRESS.matcher(mail.getText().toString()).matches()){
                Toast.makeText(getApplicationContext(), getText(Integer.parseInt("Success")),Toast.LENGTH_SHORT);
                }
                else {
                    Toast.makeText(getApplicationContext(), getText(Integer.parseInt("Invalid please enter a valid email")) ,Toast.LENGTH_SHORT);
                } setVisible(true);
            }
        });
        Submit_customer.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ShowToast")
            @Override
            public void onClick(View v) {
                if (android.util.Patterns.EMAIL_ADDRESS.matcher(mail.getText().toString()).matches()){
                    Toast.makeText(getApplicationContext(), getText(Integer.parseInt("Success")),Toast.LENGTH_SHORT);
                }
                else {
                    Toast.makeText(getApplicationContext(), getText(Integer.parseInt("Invalid please enter a valid email")) ,Toast.LENGTH_SHORT);
                } setVisible(true);
            }
        });
    }
}
