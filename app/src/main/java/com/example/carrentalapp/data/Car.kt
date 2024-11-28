package com.example.carrentalapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "car")
data class Car(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val image: Int,
    val name: String,
    val quality: String,
    val type: String,
    val price: Double,
    val info: String
)