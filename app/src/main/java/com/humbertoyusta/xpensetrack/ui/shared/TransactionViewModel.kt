package com.humbertoyusta.xpensetrack.ui.shared

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.humbertoyusta.xpensetrack.data.model.Transaction
import com.humbertoyusta.xpensetrack.data.model.repository.AppDatabase
import com.humbertoyusta.xpensetrack.data.model.repository.TransactionRepository

class TransactionViewModel(
    application: Application
) : AndroidViewModel(application) {
    private val database = AppDatabase.getInstance(application.applicationContext)
    private val repository = TransactionRepository(database.transactionDAO())

    fun getAllTransactions(): LiveData<List<Transaction>> = repository.allTransactions

    fun insertTransaction(transaction: Transaction) {
        repository.insert(transaction)
    }
}