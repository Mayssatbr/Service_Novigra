package com.example.servicenovigra_livrable1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AdminAccount extends AppCompatActivity {
    Button Log_options, btn_return;
    EditText Ad_Email, Ad_Password;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_account);

        Log_options = (Button) findViewById(R.id.LogButton);
        btn_return = (Button) findViewById(R.id.backToMain);
        Ad_Email = (EditText) findViewById(R.id.AdEmail);
        Ad_Password =(EditText) findViewById(R.id.AdPassword);

        btn_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        Log_options.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(Ad_Email.getText().toString().trim().matches(emailPattern))){
                    Ad_Email.setError("Wrong Email");
                }else if((!(Ad_Email.getText().toString().trim().matches(emailPattern)))&&(Ad_Password.length()==0)){
                    Ad_Email.setError("wrong Email");
                    Ad_Password.setError("Enter Password");
                }else{
                    Intent intent = new Intent(getApplicationContext(), Admin_Options.class);
                    startActivity(intent);
                }

            }
        });


    }
}