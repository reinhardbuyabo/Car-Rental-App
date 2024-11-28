package com.example.carrentalapp.data

import kotlinx.coroutines.flow.Flow

class OfflineCarRepository(private val carDao: CarDao) : CarRepository {

    override fun getAllCarsStream(): Flow<List<Car>> = carDao.fetchAllCars()

    override fun getCarByIdStream(id: Int): Flow<Car> = carDao.getCarById(id)

    override suspend fun insertCar(car: Car) = carDao.insertCar(car)

    override suspend fun insertManyCars(cars: List<Car>) = carDao.insertManyCars(cars)

    override suspend fun updateCar(car: Car) = carDao.updateCar(car)
}
