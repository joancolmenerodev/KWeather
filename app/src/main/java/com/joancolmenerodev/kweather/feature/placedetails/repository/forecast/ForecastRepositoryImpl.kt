package com.joancolmenerodev.kweather.feature.placedetails.repository.forecast

import com.joancolmenerodev.kweather.BuildConfig
import com.joancolmenerodev.kweather.service.WeatherService

class ForecastRepositoryImpl(private val weatherService: WeatherService) : ForecastRepository {
    override suspend fun getForecast5Days(cityKey: String) = weatherService.getForecastOf5Day(cityKey,BuildConfig.AccuWeatherApiKey)

}