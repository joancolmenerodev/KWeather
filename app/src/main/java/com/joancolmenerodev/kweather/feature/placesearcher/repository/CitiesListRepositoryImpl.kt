package com.joancolmenerodev.kweather.feature.placesearcher.repository

import com.joancolmenerodev.kweather.BuildConfig
import com.joancolmenerodev.kweather.service.WeatherService

class CitiesListRepositoryImpl(private val weatherService: WeatherService) {

    suspend fun getCities(city: String) = weatherService.getGithubUser(BuildConfig.AccuWeatherApiKey, city)
}
