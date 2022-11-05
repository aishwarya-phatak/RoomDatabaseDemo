package com.example.roomdatabasedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var db : AppDatabase
    lateinit var customerDao: CustomerDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "android_db"
        ).build()

        CoroutineScope(Dispatchers.IO).launch {

            customerDao = db.getCustomerDao()

            customerDao.addCustomer(Customer(1,"Mayuri","9090909090"))
            customerDao.addCustomer(Customer(2,"Pallavi","8987797989"))
            customerDao.addCustomer(Customer(3,"Aditya","999999999"))
            customerDao.addCustomer(Customer(4,"Pooja","8989997989"))

            var customers = customerDao.getAllCustomers()
            Log.e("tag","-------------GetAll-------------")
            for(eachCustomer in customers){
                Log.e("tag","${eachCustomer.toString()}")
            }
            Log.e("tag","----------Update Query----------------")
            customerDao.updateCustomer(Customer(2,"Vaishnavi","9903322334"))

            customers = customerDao.getAllCustomers()
            Log.e("tag","------------GetAll After Update--------------")
            for(eachCustomer in customers){
                Log.e("tag","${eachCustomer.toString()}")
            }
            customerDao.deleteCustomer(Customer(1,"Mayuri","9090909090"))

            Log.e("tag","-----------------------------")
            customers = customerDao.getAllCustomers()
            Log.e("tag","------------GetAll After Delete--------------")
            for(eachCustomer in customers){
                Log.e("tag","${eachCustomer.toString()}")
            }
            db.close()
        }
    }
}