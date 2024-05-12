package com.humbertoyusta.xpensetrack.data.model.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.humbertoyusta.xpensetrack.data.model.Transaction
import com.humbertoyusta.xpensetrack.data.model.converters.DateConverter
import java.util.concurrent.Executors

private const val DATABASE_NAME = "xpense_tracker_db"

@Database(entities = [Transaction::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun transactionDAO(): TransactionDAO

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    DATABASE_NAME
                ).build()
                INSTANCE = instance
                instance
            }
        }

        val databaseWriteExecutor = Executors.newFixedThreadPool(2)
    }
}