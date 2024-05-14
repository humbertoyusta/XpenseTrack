package com.humbertoyusta.xpensetrack.ui.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.humbertoyusta.xpensetrack.home.HomeActivity
import com.humbertoyusta.xpensetrack.ui.theme.XpenseTrackTheme

class AuthActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            XpenseTrackTheme {
                AuthScreen(
                    login = { email, password -> login(email, password) },
                    signUp = { email, password -> signUp(email, password) }
                )
            }
        }
    }

    private fun login(email: String, password: String) {
        Firebase.auth
            .signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast
                        .makeText(this, it.exception?.localizedMessage, Toast.LENGTH_SHORT)
                        .show()
                }
            }
    }

    private fun signUp(email: String, password: String) {
        Firebase.auth
            .createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast
                        .makeText(this, it.exception?.localizedMessage, Toast.LENGTH_SHORT)
                        .show()
                }
            }
    }
}

@Preview(showBackground = true)
@Composable
fun AuthScreenPreview() {
    XpenseTrackTheme {
        AuthScreen(
            login = { _, _ -> },
            signUp = { _, _ -> },
        )
    }
}