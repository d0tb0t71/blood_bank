package com.example.bloodbank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {


    EditText registration_name,registration_email,registration_phone,registration_password,registration_address,registration_blood_group;

    Button register_btn;

    TextView register_to_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        registration_name = findViewById(R.id.registration_name);
        registration_email = findViewById(R.id.registration_email);
        registration_phone = findViewById(R.id.registration_phone);
        registration_password = findViewById(R.id.registration_password);
        registration_address = findViewById(R.id.registration_address);
        registration_blood_group = findViewById(R.id.registration_blood_group);

        register_btn = findViewById(R.id.register_btn);

        register_to_login = findViewById(R.id.register_to_login);



        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name=registration_name.getText().toString();
                String email=registration_email.getText().toString();
                String phone=registration_phone.getText().toString();
                String pass=registration_password.getText().toString();
                String address= registration_address.getText().toString();
                String bGroup= registration_blood_group.getText().toString();


                FirebaseAuth mAuth= FirebaseAuth.getInstance();

                mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {


                        if (task.isSuccessful()) {

                            FirebaseUser user=mAuth.getCurrentUser();

                            String uid= user.getUid();

                            HashMap<Object ,String> hashMap = new HashMap<>();

                            hashMap.put("email",email);
                            hashMap.put("uid",uid);
                            hashMap.put("name",name);
                            hashMap.put("phone",phone);
                            hashMap.put("address",address);
                            hashMap.put("bGroup",bGroup);

                            FirebaseDatabase database=FirebaseDatabase.getInstance();
                            DatabaseReference reference=database.getReference("Users");
                            reference.child(uid).setValue(hashMap);

                            Toast.makeText(getApplicationContext(), "User Registered Successfully", Toast.LENGTH_SHORT).show();

                            startActivity(new Intent(getApplicationContext(), HomeActivity.class ));
                            finish();

                        } else {
                            Toast.makeText(getApplicationContext(), "Registration Error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }


                    }
                });
                Toast.makeText(getApplicationContext(), "Register Clicked", Toast.LENGTH_SHORT).show();
            }
        });


        register_to_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(RegisterActivity.this,MainActivity.class));

            }
        });




    }
}