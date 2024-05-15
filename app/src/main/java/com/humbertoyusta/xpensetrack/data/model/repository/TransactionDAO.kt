package com.humbertoyusta.xpensetrack.data.model.repository

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.humbertoyusta.xpensetrack.data.model.Transaction

@Dao
interface TransactionDAO {
    @Query("SELECT * FROM transactions ORDER BY date DESC")
    fun getAll(): LiveData<List<Transaction>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(transaction: Transaction)

    @Update
    fun update(transaction: Transaction)

    @Delete
    fun delete(transaction: Transaction)
}