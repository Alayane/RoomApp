package com.tp6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnAddPro,btnUpdatePro,btnDeletePro,btnDisplay;
    public static ProductDb db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAddPro= findViewById(R.id.btnAddPro);
        btnDeletePro= findViewById(R.id.btnDeletePro);
        btnUpdatePro= findViewById(R.id.btnUpdatePro);
        btnDisplay= findViewById(R.id.btnDisplay);

        db= Room.databaseBuilder(getApplicationContext(),ProductDb.class,"getproducts")
                .allowMainThreadQueries().build();
        btnAddPro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ActivityAdd.class);
                startActivity(intent);
            }
        });
        btnUpdatePro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Activity_Update.class);
                startActivity(intent);
            }
        });
        btnDeletePro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Activity_Delete.class);
                startActivity(intent);
            }
        });
        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Activity_Display.class);
                startActivity(intent);
            }
        });
    }
}