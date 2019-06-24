package com.joancolmenerodev.kweather.feature.placedetails.model.mapper

import com.joancolmenerodev.kweather.feature.placedetails.model.responses.forecasts.ForecastResponse
import com.joancolmenerodev.kweather.feature.placedetails.model.viewmodels.Forecast5DaysViewModel

fun forecast5DaysMapper(forecastResponse: ForecastResponse) = run {
    Forecast5DaysViewModel(
        forecastResponse.headline.text,
        forecastResponse.dailyForecasts
    )
}