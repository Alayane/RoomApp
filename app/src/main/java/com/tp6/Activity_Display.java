package com.tp6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class Activity_Display extends AppCompatActivity {

    Button btnMenu;
    ListView lvDisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__display);
        //
        btnMenu=findViewById(R.id.btndsMenu);
        ArrayList<Product> list;
        ProductAdpter adpter;
        lvDisplay=findViewById(R.id.lvDisplay);
        //
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Activity_Display.this,MainActivity.class);
                startActivity(intent);
            }
        });

        list=(ArrayList<Product>)MainActivity.db.productDAO().getProducts();
        adpter=new ProductAdpter(list,Activity_Display.this);
        lvDisplay.setAdapter(adpter);


    }
}