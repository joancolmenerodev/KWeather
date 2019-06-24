package com.joancolmenerodev.kweather.feature.placedetails.model.mapper

import com.joancolmenerodev.kweather.feature.placedetails.model.responses.currentInfo.CurrentConditionResponse
import com.joancolmenerodev.kweather.feature.placedetails.model.viewmodels.CurrentConditionViewModel

fun currentConditionMapper(currentConditionResponse: List<CurrentConditionResponse>) = run {
    CurrentConditionViewModel(
        currentConditionResponse[0].weatherText,
        currentConditionResponse[0].weatherIcon,
        currentConditionResponse[0].isDayTime,
        currentConditionResponse[0].temperature,
        currentConditionResponse[0].temperatureSummary,
        currentConditionResponse[0].temperatureSummary,
        currentConditionResponse[0].relativeHumidity,
        currentConditionResponse[0].wind,
        currentConditionResponse[0].cloudCover
    )

}