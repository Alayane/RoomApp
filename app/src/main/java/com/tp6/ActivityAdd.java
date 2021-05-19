package com.tp6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityAdd extends AppCompatActivity {

    EditText etNumPro,etDesig,etPrix;
    Button btnMenu,btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        //
        btnMenu=findViewById(R.id.btnMenu);
        btnAdd=findViewById(R.id.btnAdd);
        etNumPro=findViewById(R.id.edNumPro);
        etDesig=findViewById(R.id.edDesig);
        etPrix=findViewById(R.id.edPrix);
        //

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ActivityAdd.this,MainActivity.class);
                startActivity(intent);
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(etNumPro.getText().toString())){
                    Toast.makeText(ActivityAdd.this,"Le numéro est obligatoire",Toast.LENGTH_LONG).show();
                    return;
                }
                if (TextUtils.isEmpty(etDesig.getText().toString())){
                    Toast.makeText(ActivityAdd.this,"Le désignation est obligatoire",Toast.LENGTH_LONG).show();
                    return;
                }
                if (TextUtils.isEmpty(etPrix.getText().toString())){
                    Toast.makeText(ActivityAdd.this,"prix unitaire est obligatoire",Toast.LENGTH_LONG).show();
                    return;
                }
                int numPro=Integer.parseInt(etNumPro.getText().toString());
                String desig=etDesig.getText().toString();
                Double prix=Double.parseDouble(etPrix.getText().toString());

                Product product=new Product();
                product.setNumPro(numPro);
                product.setDesignation(desig);
                product.setPrix(prix);

                MainActivity.db.productDAO().AddProduct(product);
                etNumPro.setText("");
                etDesig.setText("");
                etPrix.setText("");
                Toast.makeText(ActivityAdd.this,"Produit ajouté",Toast.LENGTH_LONG).show();
            }
        });

    }
}