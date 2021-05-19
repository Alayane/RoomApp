package com.tp6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ProductAdpter extends BaseAdapter {
    ArrayList<Product> listProduct;
    Context ctx;
    LayoutInflater inflater;

    public ProductAdpter(ArrayList<Product> listProduct, Context ctx) {
        this.listProduct = listProduct;
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return listProduct.size();
    }

    @Override
    public Object getItem(int position) {
        return listProduct.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listProduct.get(position).getNumPro();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Product product=listProduct.get(position);
        if (convertView==null){
            inflater =(LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.products_list,parent,false);
        }
        TextView tvNumPor=convertView.findViewById(R.id.tvNumPro);
        TextView tvDesignation=convertView.findViewById(R.id.tvDesig);
        TextView tvPrix=convertView.findViewById(R.id.tvPrix);


        tvNumPor.setText(tvNumPor.getText().toString()+": " +String.valueOf(product.getNumPro()));
        tvDesignation.setText(tvDesignation.getText().toString()+": " +String.valueOf(product.getDesignation()));
        tvPrix.setText(tvPrix.getText().toString()+": " +String.valueOf(product.getPrix()));

        return convertView;
    }
}
