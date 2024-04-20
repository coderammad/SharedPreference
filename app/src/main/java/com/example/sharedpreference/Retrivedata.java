package com.example.sharedpreference;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Retrivedata extends AppCompatActivity {
TextView name,age;
SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_retrivedata);
       sp=getSharedPreferences("data",0);
       name=findViewById(R.id.name);
       age=findViewById(R.id.age);
       String Name=sp.getString("Name","");
       String Age=sp.getString("Age","");
       int agetext=Integer.parseInt(Age);
       name.setText(Name);
       age.setText(String.valueOf(agetext));
    }
}