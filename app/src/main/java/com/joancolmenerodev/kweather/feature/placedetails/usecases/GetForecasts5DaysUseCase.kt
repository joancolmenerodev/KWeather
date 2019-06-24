package com.joancolmenerodev.kweather.feature.placedetails.usecases

import com.joancolmenerodev.kweather.base.usecase.UseCase
import com.joancolmenerodev.kweather.feature.placedetails.model.mapper.forecast5DaysMapper
import com.joancolmenerodev.kweather.feature.placedetails.model.viewmodels.Forecast5DaysViewModel
import com.joancolmenerodev.kweather.feature.placedetails.repository.forecast.ForecastRepositoryImpl

class GetForecasts5DaysUseCase(private val forecastRepositoryImpl: ForecastRepositoryImpl) : UseCase<Forecast5DaysViewModel,String>() {
    override suspend fun run(params: String?) = forecast5DaysMapper(forecastRepositoryImpl.getForecast5Days(cityKey = params?: ""))
}