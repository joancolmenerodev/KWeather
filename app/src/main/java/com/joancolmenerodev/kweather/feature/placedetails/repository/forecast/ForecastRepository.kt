package com.joancolmenerodev.kweather.feature.placedetails.repository.forecast

import com.joancolmenerodev.kweather.feature.placedetails.model.responses.forecasts.ForecastResponse

interface ForecastRepository {

    suspend fun getForecast5Days(cityKey : String) : ForecastResponse

}