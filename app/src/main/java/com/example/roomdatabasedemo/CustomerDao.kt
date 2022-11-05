package com.example.roomdatabasedemo

import androidx.room.*

@Dao
interface CustomerDao {

    @Query("select * from customers")
    fun getAllCustomers() : List<Customer>

    @Insert
    fun addCustomer(customer : Customer)

    @Update
    fun updateCustomer(customer: Customer)

    @Delete
    fun deleteCustomer(customer: Customer)
}