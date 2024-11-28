package com.example.carrentalapp.data

import android.content.Context
import androidx.room.Room

@androidx.room.Database(entities = [Car::class], version = 1, exportSchema = false)
abstract class CarDatabase : androidx.room.RoomDatabase() {
    abstract fun carDao(): CarDao

    companion object {
        @Volatile
        private var Instance: CarDatabase? = null

        fun getDatabase(context: Context): CarDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    CarDatabase::class.java,
                    "car_database"
                )
                    .build()
                    .also {Instance = it}
            }
        }
    }
}