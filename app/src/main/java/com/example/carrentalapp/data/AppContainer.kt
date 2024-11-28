package com.example.carrentalapp.data

import android.content.Context

/**
 * App container for Dependency injection.
 */
interface AppContainer {
    val carRepository: CarRepository
}


/**
 * [AppContainer] implementation that provides instance of [OfflineCarRepository]
 */
class AppDataContainer(private val context: Context) : AppContainer {
    /**
     * Implementation for [CarRepository]
     */
    override val carRepository: CarRepository by lazy {
        OfflineCarRepository(CarDatabase.getDatabase(context).carDao())
    }
}