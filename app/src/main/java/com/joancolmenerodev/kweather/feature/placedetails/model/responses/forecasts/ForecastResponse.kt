package com.joancolmenerodev.kweather.feature.placedetails.model.responses.forecasts


import com.google.gson.annotations.SerializedName

data class ForecastResponse(
    @SerializedName("DailyForecasts")
    val dailyForecasts: List<DailyForecast>,
    @SerializedName("Headline")
    val headline: Headline
)