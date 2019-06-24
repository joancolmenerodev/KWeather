package com.joancolmenerodev.kweather.feature.placedetails.model.viewmodels

import com.joancolmenerodev.kweather.feature.placedetails.model.responses.forecasts.DailyForecast

data class Forecast5DaysViewModel(
    val text: String,
    val dailyForecasts: List<DailyForecast>
)