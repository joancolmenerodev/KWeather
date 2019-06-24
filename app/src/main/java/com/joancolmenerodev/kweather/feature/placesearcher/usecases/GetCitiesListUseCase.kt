package com.joancolmenerodev.kweather.feature.placesearcher.usecases

import com.joancolmenerodev.kweather.base.usecase.UseCase
import com.joancolmenerodev.kweather.feature.placesearcher.model.CitiesListViewModel
import com.joancolmenerodev.kweather.feature.placesearcher.model.cityListMapper
import com.joancolmenerodev.kweather.feature.placesearcher.repository.CitiesListRepositoryImpl

class GetCitiesListUseCase(private val citiesListRepositoryImpl: CitiesListRepositoryImpl) :
    UseCase<List<CitiesListViewModel>, String>() {
    override suspend fun run(params: String?) = cityListMapper(citiesListRepositoryImpl.getCities((params ?: "")))
}