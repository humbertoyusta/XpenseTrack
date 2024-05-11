package com.humbertoyusta.xpensetrack.data.model.cb

import com.humbertoyusta.xpensetrack.data.model.ExchangeRateResponse

interface ExchangeRateResult {

    fun onDataFetchedSuccess(exchangeRate: ExchangeRateResponse)

    fun onDataFetchedFailed()
}