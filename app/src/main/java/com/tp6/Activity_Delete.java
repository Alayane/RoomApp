package com.tp6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity_Delete extends AppCompatActivity {

    Button btnMenu,btnDelete;
    EditText etNumPro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__delete);
        btnMenu=findViewById(R.id.btndlMenu);
        btnDelete=findViewById(R.id.btndlDelete);
        etNumPro=findViewById(R.id.eddlNumPro);
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Activity_Delete.this,MainActivity.class);
                startActivity(intent);
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(etNumPro.getText().toString())){
                    Toast.makeText(Activity_Delete.this,"Le numéro est obligatoire",Toast.LENGTH_LONG).show();
                    return;
                }
                int id=Integer.parseInt(etNumPro.getText().toString());
                Product product=new Product();
                product.setNumPro(id);
                Product p=MainActivity.db.productDAO().getProductByCode(id);
                if(p==null){
                    Toast.makeText(Activity_Delete.this,"Produit introuvable",Toast.LENGTH_LONG).show();
                    return;
                }
                MainActivity.db.productDAO().DeleteProduct(product);
                Toast.makeText(Activity_Delete.this,"Produit supprimé",Toast.LENGTH_LONG).show();
            }
        });
    }
}