package com.tp6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity_Update extends AppCompatActivity {

    Button btnMenu,btnupSearch,btnupUpdate;
    EditText etNumPro,etDesig,etPrix;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__update);
        btnMenu=findViewById(R.id.btnupMenu);
        btnupSearch=findViewById(R.id.btnupSearch);
        btnupUpdate=findViewById(R.id.btnupUpdate);
        etNumPro=findViewById(R.id.edupNumPro);
        etDesig=findViewById(R.id.edupDesig);
        etPrix=findViewById(R.id.edupPrix);
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Activity_Update.this,MainActivity.class);
                startActivity(intent);
            }
        });
        btnupUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(etNumPro.getText().toString())){
                    Toast.makeText(Activity_Update.this,"La désignation est obligatoire",Toast.LENGTH_LONG).show();
                    return;
                }
                if(TextUtils.isEmpty(etDesig.getText().toString())){
                    Toast.makeText(Activity_Update.this,"La désignation est obligatoire",Toast.LENGTH_LONG).show();
                    return;
                }
                if(TextUtils.isEmpty(etPrix.getText().toString())){
                    Toast.makeText(Activity_Update.this,"Le prix unitaire est obligatoire",Toast.LENGTH_LONG).show();
                    return;
                }
                int numPro=Integer.parseInt(etNumPro.getText().toString());
                String desig=etDesig.getText().toString();
                Double prix=Double.parseDouble(etPrix.getText().toString());
                Product product=new Product();
                product.setNumPro(numPro);
                product.setDesignation(desig);
                product.setPrix(prix);
                MainActivity.db.productDAO().UpdateProduct(product);
                etNumPro.setText("");
                etDesig.setText("");
                etPrix.setText("");
                Toast.makeText(Activity_Update.this,"Produit modifie",Toast.LENGTH_LONG).show();
            }

        });
        btnupSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(etNumPro.getText().toString())){
                    Toast.makeText(Activity_Update.this,"Le numéro est obligatoire",Toast.LENGTH_LONG).show();
                    return;
                }
                int id=Integer.parseInt(etNumPro.getText().toString());
                Product product= MainActivity.db.productDAO().getProductByCode(id);
                if(product!=null){
                    etDesig.setText(product.getDesignation());
                    etPrix.setText(String.valueOf(product.getPrix()));
                }
                else
                    Toast.makeText(Activity_Update.this,"Produit introuvable",Toast.LENGTH_LONG).show();
            }
        });
    }
}