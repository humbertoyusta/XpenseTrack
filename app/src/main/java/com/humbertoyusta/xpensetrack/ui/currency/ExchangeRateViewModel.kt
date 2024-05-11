package com.humbertoyusta.xpensetrack.ui.currency

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.humbertoyusta.xpensetrack.api.ExchangeRateApiProvider
import com.humbertoyusta.xpensetrack.data.model.ExchangeRateResponse
import com.humbertoyusta.xpensetrack.data.model.cb.ExchangeRateResult

private const val TAG = "ExchangeRateViewModel"

class ExchangeRateViewModel : ViewModel(), ExchangeRateResult {
    private val _exchangeRates = MutableLiveData<ExchangeRateResponse?>()
    val exchangeRates: LiveData<ExchangeRateResponse?> = _exchangeRates

    private val provider by lazy {
        ExchangeRateApiProvider()
    }

    fun fetchExchangeRates(fromCurrency: String) {
        provider.fetchExchangeRates(fromCurrency, this)
    }

    override fun onDataFetchedSuccess(exchangeRate: ExchangeRateResponse) {
        _exchangeRates.value = exchangeRate
    }

    override fun onDataFetchedFailed() {
        _exchangeRates.value = null
        Log.d(TAG, "Unable to retrieve exchange rates")
    }
}