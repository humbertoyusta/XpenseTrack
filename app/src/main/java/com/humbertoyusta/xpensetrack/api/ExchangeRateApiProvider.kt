package com.humbertoyusta.xpensetrack.api

import com.humbertoyusta.xpensetrack.data.model.ExchangeRateResponse
import com.humbertoyusta.xpensetrack.data.model.cb.ExchangeRateResult
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

private const val BASE_URL = "https://v6.exchangerate-api.com/v6/"

class ExchangeRateApiProvider {

    private val retrofit by lazy {

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create<ExchangeRateApi>()
    }

    fun fetchExchangeRates(fromCurrency: String, cb: ExchangeRateResult) {
        retrofit.getExchangeRate(fromCurrency).enqueue(object : Callback<ExchangeRateResponse> {
            override fun onResponse(
                call: Call<ExchangeRateResponse>,
                response: Response<ExchangeRateResponse>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    cb.onDataFetchedSuccess(response.body()!!)
                } else {
                    cb.onDataFetchedFailed()
                }

            }

            override fun onFailure(call: Call<ExchangeRateResponse>, t: Throwable) {
                cb.onDataFetchedFailed()
            }
        })
    }
}