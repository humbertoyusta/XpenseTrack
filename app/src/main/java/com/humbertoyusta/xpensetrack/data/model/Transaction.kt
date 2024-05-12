package com.humbertoyusta.xpensetrack.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.humbertoyusta.xpensetrack.data.enums.TransactionType
import com.humbertoyusta.xpensetrack.data.model.converters.DateConverter
import java.util.Date

@Entity(tableName = "transactions")
class Transaction(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "category")
    val category: String,

    @ColumnInfo(name = "amount")
    val amount: Double,

    @ColumnInfo(name = "currency")
    val type: TransactionType,

    @ColumnInfo(name = "date")
    @TypeConverters(DateConverter::class)
    val date: Date,
)
