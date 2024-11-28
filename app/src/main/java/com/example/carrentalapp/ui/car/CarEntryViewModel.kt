package com.example.carrentalapp.ui.car

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.carrentalapp.data.Car
import com.example.carrentalapp.data.CarRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.text.NumberFormat


class CarEntryViewModel(private val carRepository: CarRepository) : ViewModel() {
    // State for UI to handle car details and validation
    private val _uiState = MutableStateFlow(CarUiState())
    val uiState: StateFlow<CarUiState> = _uiState

    // Update car details in the UI state
    fun updateCarDetails(carDetails: CarDetails) {
        val isValid = validateCarEntry(carDetails)
        _uiState.value = CarUiState(carDetails = carDetails, isEntryValid = isValid)
    }

    // Validate car entry
    private fun validateCarEntry(carDetails: CarDetails): Boolean {
        return carDetails.name.isNotBlank() &&
                carDetails.price.toDoubleOrNull() != null &&
                carDetails.type.isNotBlank()
    }

    // Save a new car to the repository
    suspend fun saveCar() {
        carRepository.insertCar(_uiState.value.carDetails.toCar())
        }

    private fun validateInput(uiState: CarDetails = _uiState.value.carDetails): Boolean {
        return with(uiState) {
            name.isNotBlank() && type.isNotBlank() && price.isNotBlank()
        }
    }
}

/**
 * Represents UI State for a Car.
 */
data class CarUiState(
    val carDetails: CarDetails = CarDetails(),
    val isEntryValid: Boolean = false
)

/**
 * Represents the detailed data for a Car.
 */
data class CarDetails(
    val id: Int = 0,
    val image: Int = 0,
    val name: String = "",
    val type: String = "",
    val price: String = "",
    val quality: String = "",
    val info: String = ""
)

/**
 * Extension function to convert [CarDetails] to [Car].
 * If the value of [CarDetails.price] is not valid, it defaults to 0.0.
 */
fun CarDetails.toCar(): Car = Car(
    id = id,
    image = image,
    name = name,
    type = type,
    price = price.toDoubleOrNull() ?: 0.0,
    quality = quality,
    info = info
)

/**
 * Extension function to convert [Car] to [CarUiState].
 */
fun Car.toCarUiState(isEntryValid: Boolean = false): CarUiState = CarUiState(
    carDetails = this.toCarDetails(),
    isEntryValid = isEntryValid
)

/**
 * Extension function to convert [Car] to [CarDetails].
 */
fun Car.toCarDetails(): CarDetails = CarDetails(
    id = id,
    image = image,
    name = name,
    type = type,
    price = price.toString(),
    quality = quality,
    info = info
)

/**
 * Extension function to format the price of a car as currency.
 */
fun Car.formattedPrice(): String {
    return NumberFormat.getCurrencyInstance().format(price)
}
