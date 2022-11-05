package com.example.roomdatabasedemo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "customers")
data class Customer (
    @PrimaryKey @ColumnInfo(name = "_id") val id : Int,
    val name : String,
    val phone : String
    )