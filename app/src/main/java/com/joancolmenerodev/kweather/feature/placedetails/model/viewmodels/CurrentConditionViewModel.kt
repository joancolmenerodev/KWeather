package com.joancolmenerodev.kweather.feature.placedetails.model.viewmodels

import com.joancolmenerodev.kweather.feature.placedetails.model.responses.currentInfo.Temperature
import com.joancolmenerodev.kweather.feature.placedetails.model.responses.currentInfo.TemperatureSummary
import com.joancolmenerodev.kweather.feature.placedetails.model.responses.currentInfo.Wind

data class CurrentConditionViewModel(
    val weatherText: String,
    val weatherIcon: Int,
    val dayTime: Boolean,
    val temperature: Temperature,
    val minTemp: TemperatureSummary,
    val maxTemp: TemperatureSummary,
    val relativeHumidity: Int,
    val wind: Wind,
    val cloudCover: Int
)