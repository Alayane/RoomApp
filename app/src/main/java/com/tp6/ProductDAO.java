package com.tp6;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ProductDAO {
    @Insert
    public void AddProduct(Product p);
    @Update
    public void UpdateProduct(Product p);
    @Delete
    public void DeleteProduct(Product p);
    @Query("select * from Product")
    public List<Product>getProducts();
    @Query("select * from Product where NumPro=:id")
    public Product getProductByCode(int id);

}
