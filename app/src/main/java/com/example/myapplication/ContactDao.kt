package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface ContactDao {
    @Insert
    suspend fun insertContact(contact: Contact)
    @Update
    suspend fun updateContac(contact: Contact)
    @Delete
    suspend fun deleteContact(contact: Contact)
    @Query("SELECT * FROM contact_table")
    fun query():LiveData<List<Contact>>
}