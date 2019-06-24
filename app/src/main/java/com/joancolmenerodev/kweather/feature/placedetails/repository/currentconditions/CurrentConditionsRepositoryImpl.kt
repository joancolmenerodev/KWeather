package com.joancolmenerodev.kweather.feature.placedetails.repository.currentconditions

import com.joancolmenerodev.kweather.BuildConfig
import com.joancolmenerodev.kweather.service.WeatherService

class CurrentConditionsRepositoryImpl(private val weatherService: WeatherService) : CurrentConditionsRepository {
    override suspend fun getCurrentConditions(cityKey: String) = weatherService.getCurrentConditions(cityKey,BuildConfig.AccuWeatherApiKey,true)
}