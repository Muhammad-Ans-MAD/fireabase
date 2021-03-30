package com.example.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity2 extends AppCompatActivity {
EditText t1,t2;
Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        t1=(EditText)findViewById(R.id.email);
        t2=(EditText)findViewById(R.id.Password);
        btn1=(Button)findViewById(R.id.button);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = t1.getText().toString().trim();
                String password  = t2.getText().toString().trim();
                FirebaseAuth.getInstance().signInWithEmailAndPassword(email,password).
                        addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    //display some message here

                                    Toast.makeText(MainActivity2.this,"Successfully Login",Toast.LENGTH_LONG).show();
                                    Intent intent=new Intent(MainActivity2.this,MainActivity3.class);
                                    startActivity(intent);
                                }else{
                                    //display some message here
                                    Toast.makeText(MainActivity2.this,"Login Error",Toast.LENGTH_LONG).show();
                                }
                            }
                        });
            }
        });

    }
}