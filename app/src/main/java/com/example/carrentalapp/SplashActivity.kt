package com.example.carrentalapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.window.SplashScreen
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.carrentalapp.ui.theme.CarRentalAppTheme
import kotlinx.coroutines.delay

@SuppressLint("CustomSplashScreen")
class SplashActivity: ComponentActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CarRentalAppTheme {
                SplashScreen()
            }
        }
    }

    @Composable
    private fun SplashScreen(){
        LaunchedEffect(key1 = true, block = {
            delay(2000)
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
        })
        Box(modifier = Modifier.fillMaxSize().background(
            Color(0xFFFFFFFF)
        )  , contentAlignment = Alignment.Center){
            Image(painter = painterResource(R.drawable.suv_jpeg), contentDescription = null)
        }
    }
}