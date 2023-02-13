package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var dataBase: ContactDataBase;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dataBase = Room.databaseBuilder(applicationContext,ContactDataBase::class.java,"contactDB").build()
        GlobalScope.launch {
            dataBase.createDB().insertContact(Contact(0,"lokesh","123"))
        }
    }
    fun onClickButton(view:View){
        dataBase.createDB().query().observe(this, Observer {
            Log.d("Kotlin",it.toString())
        })
    }
}