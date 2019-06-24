package com.joancolmenerodev.kweather.feature.placedetails.usecases

import com.joancolmenerodev.kweather.base.usecase.UseCase
import com.joancolmenerodev.kweather.feature.placedetails.model.mapper.currentConditionMapper
import com.joancolmenerodev.kweather.feature.placedetails.model.viewmodels.CurrentConditionViewModel
import com.joancolmenerodev.kweather.feature.placedetails.repository.currentconditions.CurrentConditionsRepositoryImpl

class GetCurrentConditionsUseCase(private val currentConditionsRepositoryImpl: CurrentConditionsRepositoryImpl) : UseCase<CurrentConditionViewModel,String>() {
    override suspend fun run(params: String?) = currentConditionMapper(currentConditionsRepositoryImpl.getCurrentConditions(params?: ""))
}