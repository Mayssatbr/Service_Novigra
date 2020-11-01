package com.example.servicenovigra_livrable1;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.rpc.context.AttributeContext;

import java.util.HashMap;
import java.util.Map;

public class MainActivity2 extends AppCompatActivity {
    EditText FirstName,LastName,mail,userName,password;

    Button Submit_customer, Submit_employee;
    FirebaseAuth fAuth;
    ProgressBar progressBar;
    FirebaseFirestore fStore;

    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        fAuth=FirebaseAuth.getInstance();

        fStore=FirebaseFirestore.getInstance();
        FirstName=(EditText)findViewById(R.id.et_firstName);
        LastName=(EditText)findViewById(R.id.et_lastName);
        mail=(EditText) findViewById(R.id.mail);
        userName=(EditText)findViewById(R.id.et_usernameS);
        password=(EditText)findViewById(R.id.et_password);

        String email = mail.getText().toString().trim();
        String passw = password.getText().toString().trim();

        fAuth=FirebaseAuth.getInstance();
        //progressBar = findViewById(R.id.progressBar);


        Submit_customer=(Button) findViewById(R.id.bt_customer);
        Submit_employee=(Button) findViewById(R.id.bt_employee);

        if(fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();

        }

        Submit_employee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(email.matches(emailPattern))){
                    mail.setError("wrong email");
                }
                if(TextUtils.isEmpty(email)){
                    mail.setError("Email is Required");

                }
                if(TextUtils.isEmpty(passw)){
                    password.setError("Empty Password");
                }
                //progressBar.setVisibility(View.VISIBLE);

                fAuth.createUserWithEmailAndPassword(email, passw).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (task.isSuccessful()) {
                                    Toast.makeText(MainActivity2.this, "User created" , Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(getApplicationContext(), MainActivity.class));


                                } else {
                                    Toast.makeText(MainActivity2.this, "Authentication failed." + task.getException(),Toast.LENGTH_SHORT).show();
                                }
                            }
                        });


            }
        });

//        Submit_employee.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(mail.getText().toString().isEmpty()) {
//                    mail.setError("enter your mail address");
//                }else {
//                    if (!(mail.getText().toString().trim().matches(emailPattern))) {
//                        mail.setError("invalid mail address");
//                    }
//                }
//
//
//
//                if (userName.length()==0){
//                    userName.setError("Enter Username");
//                }
//                if(password.length()==0){
//                    password.setError("Enter password");
//                }
//                if(FirstName.length()==0){
//                    FirstName.setError("Enter First name");
//                }
//                if(LastName.length()==0){
//                    LastName.setError("Enter Last name");
//                }
//
//
//                if((!(mail.getText().toString().isEmpty()))&&(mail.getText().toString().trim().matches(emailPattern))&&(userName.length()!=0)&&(password.length()!=0)&&(FirstName.length()!=0)&&(LastName.length()!=0)&&(mail.length()!=0)) {
//                    fAuth.createUserWithEmailAndPassword(mail.getText().toString(),password.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
//                        @Override
//                        public void onSuccess(AuthResult authResult) {
//                            FirebaseUser user=fAuth.getCurrentUser();
//                            Toast.makeText(MainActivity2.this, "Account Created", Toast.LENGTH_SHORT).show();
//                            DocumentReference df = fStore.collection("Users").document(user.getUid());
//                            HashMap<Object, String> userInfo = new HashMap<>();
//
//                            userInfo.put("FirstName", FirstName.getText().toString());
//                            userInfo.put("LastName", LastName.getText().toString());
//                            userInfo.put("userName",userName.getText().toString());
//                            userInfo.put("UserEmail",mail.getText().toString());
//
//
//                            userInfo.put("isUser","1");
//                            df.set(userInfo);
//                            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
//
//                            startActivity(intent);
//                            finish();
//                        }
//                    }).addOnFailureListener(new OnFailureListener() {
//                        @Override
//                        public void onFailure(@NonNull Exception e) {
//                            Toast.makeText(MainActivity2.this, "failed to create Account", Toast.LENGTH_SHORT).show();
//                        }
//                    });
//
//
//
//                }
//
//
//            }
//        });
//
//
//
//
//
//        Submit_customer.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(mail.getText().toString().isEmpty()) {
//                    mail.setError("enter your mail");
//                }else {
//                    if (!(mail.getText().toString().trim().matches(emailPattern))) {
//                        mail.setError("invalid mail address");
//                    }
//                }
//
//
//                if(userName.length()==0){
//                    userName.setError("Enter Username");
//                }
//                if(password.length()==0){
//                    password.setError("Enter password");
//                }
//                if(FirstName.length()==0){
//                    FirstName.setError("Enter First name");
//                }
//                if(LastName.length()==0){
//                    LastName.setError("Enter Last name");
//                }
//
//
//
//
//                if((!(mail.getText().toString().isEmpty()))&&(mail.getText().toString().trim().matches(emailPattern))&&(userName.length()!=0)&&(password.length()!=0)&&(FirstName.length()!=0)&&(LastName.length()!=0)&&(mail.length()!=0)) {
//                    fAuth.createUserWithEmailAndPassword(mail.getText().toString(),password.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
//                        @Override
//                        public void onSuccess(AuthResult authResult) {
//                            FirebaseUser user=fAuth.getCurrentUser();
//                            Toast.makeText(MainActivity2.this, "Account Created", Toast.LENGTH_SHORT).show();
//                            DocumentReference df= fStore.collection("Users").document(user.getUid());
//                            Map<String,Object> userInfo= new HashMap<>();
//                            userInfo.put("FirstName",FirstName.getText().toString());
//                            userInfo.put("LastName",LastName.getText().toString());
//                            userInfo.put("userName",userName.getText().toString());
//                            userInfo.put("UserEmail",mail.getText().toString());
//
//
//                            userInfo.put("isUser","1");
//                            df.set(userInfo);
//                            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
//
//                            startActivity(intent);
//                            finish();
//                        }
//                    }).addOnFailureListener(new OnFailureListener() {
//                        @Override
//                        public void onFailure(@NonNull Exception e) {
//                            Toast.makeText(MainActivity2.this, "failed to create Account", Toast.LENGTH_SHORT).show();
//                        }
//                    });
//
//
//
//                }
//
//
//
//
//            }
//        });



    }
}
