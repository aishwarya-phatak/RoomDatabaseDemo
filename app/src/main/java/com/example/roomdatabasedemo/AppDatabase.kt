package com.example.roomdatabasedemo

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Customer::class], version = 1)
abstract  class AppDatabase : RoomDatabase(){
    abstract fun getCustomerDao() : CustomerDao
}