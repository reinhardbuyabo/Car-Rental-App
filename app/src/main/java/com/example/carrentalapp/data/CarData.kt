package com.example.carrentalapp.data

import com.example.carrentalapp.R

data class carData(
    val id: Int,
    val image: Int,
    val name: String,
    val quality: String,
    val type: String,
    val price: String,
    val info: String
)

fun fetchAll():List<carData>{
    return listOf<carData>(
        carData(1, R.drawable.tx ,"Land Cruiser TX","Excellent","Manual","20,000 Ksh", info = "Audited and inspected by NTSA on 20th November, 2024 ✅"),
        carData(2, R.drawable.noah ,"Toyota Noah","Excellent","Manual","20,000 Ksh", info = "Yet to be audited"),
        carData(3, R.drawable.toyota_vitz ,"Toyota Vitz","Excellent","Manual","20,000 Ksh", info = "Audited and inspected by NTSA on 21st November, 2024 ✅"),
        carData(4, R.drawable.premio ,"Toyota Premio","Excellent","Manual","20,000 Ksh", info = "Yet to be audited"),
    )
}