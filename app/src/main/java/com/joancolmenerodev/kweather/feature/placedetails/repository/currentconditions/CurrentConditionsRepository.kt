package com.joancolmenerodev.kweather.feature.placedetails.repository.currentconditions

import com.joancolmenerodev.kweather.feature.placedetails.model.responses.currentInfo.CurrentConditionResponse

interface CurrentConditionsRepository {

    suspend fun getCurrentConditions(cityKey: String) : List<CurrentConditionResponse>
}