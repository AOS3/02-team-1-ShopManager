package com.lion.team_1_shopmanager.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.lion.team_1_shopmanager.dao.ShopDao
import com.lion.team_1_shopmanager.vo.ShopVo

@Database(entities = [ShopVo::class], version = 1, exportSchema = true)
abstract class ShopDatabase : RoomDatabase() {
    abstract fun shopDAO() : ShopDao

    companion object{
        var shopDatabase:ShopDatabase? = null
        @Synchronized
        fun getInstance(context: Context) : ShopDatabase?{
            synchronized(ShopDatabase::class){
                shopDatabase = Room.databaseBuilder(
                    context.applicationContext, ShopDatabase::class.java,
                    "Shop.db"
                ).build()
            }
            return shopDatabase
        }
    }
}