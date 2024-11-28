package com.example.carrentalapp.data

import kotlinx.coroutines.flow.Flow

/**
 * Repository that provides insert, update, delete, and retrieve of [Car] from a given data source.
 */
interface CarRepository {
    /**
     * Retrieve all cars from the data source as a stream.
     */
    fun getAllCarsStream(): Flow<List<Car>>

    /**
     * Retrieve a car from the data source that matches with the [id].
     */
    fun getCarByIdStream(id: Int): Flow<Car>

    /**
     * Insert a car into the data source.
     */
    suspend fun insertCar(car: Car)

    /**
     * Insert multiple cars into the data source.
     */
    suspend fun insertManyCars(cars: List<Car>)

    /**
     * Update a car in the data source.
     */
    suspend fun updateCar(car: Car)
}
