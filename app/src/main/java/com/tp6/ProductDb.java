package com.tp6;

import androidx.room.Database;
import androidx.room.RoomDatabase;
@Database(entities = {Product.class},version = 1)
public abstract class ProductDb extends RoomDatabase {
    public abstract ProductDAO productDAO();
}
