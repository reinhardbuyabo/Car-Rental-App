/*
 * Copyright (C) 2023 Car Rental App
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.carrentalapp.ui

import android.app.Application
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.carrentalapp.CarRentalApplication
import com.example.carrentalapp.ui.screens.home.HomeViewModel
import com.example.carrentalapp.ui.screens.car.CarDetailsViewModel
import com.example.carrentalapp.ui.screens.car.CarEditViewModel
import com.example.carrentalapp.ui.screens.car.CarEntryViewModel

/**
 * Provides Factory to create instance of ViewModel for the entire Car Rental app
 */
object AppViewModelProvider {
    val Factory = viewModelFactory {
        // Initializer for CarEditViewModel
        initializer {
            CarEditViewModel(
                this.createSavedStateHandle(),
                carRentalApplication().container.carsRepository
            )
        }
        // Initializer for CarEntryViewModel
        initializer {
            CarEntryViewModel(carRentalApplication().container.carsRepository)
        }

        // Initializer for CarDetailsViewModel
        initializer {
            CarDetailsViewModel(
                this.createSavedStateHandle(),
                carRentalApplication().container.carsRepository
            )
        }

        // Initializer for HomeViewModel
        initializer {
            HomeViewModel(carRentalApplication().container.carsRepository)
        }
    }
}

/**
 * Extension function to query for [Application] object and return an instance of
 * [CarRentalApplication].
 */
fun CreationExtras.carRentalApplication(): CarRentalApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as CarRentalApplication)
