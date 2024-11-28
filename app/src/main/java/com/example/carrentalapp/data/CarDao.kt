package com.example.carrentalapp.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface CarDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCar(car: Car)

    @Update
    suspend fun updateCar(car: Car)

    @Insert
    suspend fun insertManyCars(cars: List<Car>)

    @Query("SELECT * FROM car WHERE id = :id")
    fun getCarById(id: Int): Flow<Car>

    @Query("SELECT * FROM car")
    fun fetchAllCars(): Flow<List<Car>>
}