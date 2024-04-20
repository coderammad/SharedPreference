package com.example.sharedpreference;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.xml.sax.Parser;

public class MainActivity extends AppCompatActivity {
EditText Name,Age;
SharedPreferences sp;
Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
sp= getSharedPreferences("data",0);
Name=findViewById(R.id.Name);
Age=findViewById(R.id.Age);
save=findViewById(R.id.Save);

save.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String name=Name.getText().toString();
        String age=Age.getText().toString();
        if(TextUtils.isEmpty(name) || TextUtils.isEmpty(age)){
            Toast.makeText(MainActivity.this, "Please Fill Field", Toast.LENGTH_SHORT).show();
        }
        else{
            int agetext=Integer.parseInt(age);
            savedata(name,agetext);
        }
    }

    private void savedata(String name,int agetext) {
    SharedPreferences.Editor editor=sp.edit();
    editor.putString("Name",name);
    editor.putString("Age", String.valueOf(agetext));
    editor.apply();
    Intent i =new Intent(getApplicationContext(), Retrivedata.class);
    startActivity(i);

    }
});
    }
}