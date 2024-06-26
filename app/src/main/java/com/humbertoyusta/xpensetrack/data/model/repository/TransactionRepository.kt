package com.humbertoyusta.xpensetrack.data.model.repository

import com.humbertoyusta.xpensetrack.data.model.Transaction

class TransactionRepository(
    private val transactionDAO: TransactionDAO
) {
    val allTransactions = transactionDAO.getAll()

    fun insert(transaction: Transaction) {
        AppDatabase.databaseWriteExecutor.execute {
            transactionDAO.insert(transaction)
        }
    }

    fun update(transaction: Transaction) {
        AppDatabase.databaseWriteExecutor.execute {
            transactionDAO.update(transaction)
        }
    }

    fun delete(transaction: Transaction) {
        AppDatabase.databaseWriteExecutor.execute {
            transactionDAO.delete(transaction)
        }
    }
}