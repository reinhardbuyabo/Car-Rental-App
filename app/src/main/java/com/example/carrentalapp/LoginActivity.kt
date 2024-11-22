package com.example.carrentalapp

import android.os.Bundle
import androidx.activity.ComponentActivity

class LoginActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val authenticationManager = AuthenticationManager(this)
    }
}