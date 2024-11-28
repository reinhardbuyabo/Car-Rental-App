package com.example.carrentalapp

import android.app.Application
import com.example.carrentalapp.data.AppContainer
import com.example.carrentalapp.data.AppDataContainer

/**
 * Custom Application class for initializing dependencies.
 */
class CarRentalApplication : Application() {

    /**
     * AppContainer instance used by the rest of the app to obtain dependencies.
     */
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        // Initialize the dependency container
        container = AppDataContainer(this)
    }
}
