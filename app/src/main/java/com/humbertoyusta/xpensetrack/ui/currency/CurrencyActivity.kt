package com.humbertoyusta.xpensetrack.ui.currency

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.humbertoyusta.xpensetrack.data.enums.Currency
import com.humbertoyusta.xpensetrack.ui.auth.AuthActivity
import com.humbertoyusta.xpensetrack.ui.theme.XpenseTrackTheme

class CurrencyActivity : ComponentActivity() {
    private val exchangeRateViewModel: ExchangeRateViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            XpenseTrackTheme {
                val exchangeRates = exchangeRateViewModel.exchangeRates.observeAsState()
                exchangeRateViewModel.fetchExchangeRates(Currency.EUR.name)
                CurrencyScreen(
                    exchangeRates = exchangeRates.value,
                    logOut = { logOut() }
                )
            }
        }
    }

    private fun logOut() {
        Firebase.auth.signOut()

        val intent = Intent(this, AuthActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }
}

@Composable
@Preview
fun CurrencyActivityPreview() {
    val exchangeRateViewModel = ExchangeRateViewModel()
    XpenseTrackTheme {
        val exchangeRates = exchangeRateViewModel.exchangeRates.observeAsState()
        exchangeRateViewModel.fetchExchangeRates(Currency.EUR.name)
        CurrencyScreen(exchangeRates.value)
    }
}