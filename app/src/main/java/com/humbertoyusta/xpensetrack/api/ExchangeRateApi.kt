package com.humbertoyusta.xpensetrack.api

import com.humbertoyusta.xpensetrack.data.model.ExchangeRateResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

private const val API_KEY = "2328bd4e46aeb142c1b96340"

interface ExchangeRateApi {

    @GET("$API_KEY/latest/{fromCurrency}")
    fun getExchangeRate(
        @Path("fromCurrency") fromCurrency: String
    ): Call<ExchangeRateResponse>
}