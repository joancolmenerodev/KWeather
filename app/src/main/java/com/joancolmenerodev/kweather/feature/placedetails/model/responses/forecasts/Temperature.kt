package com.joancolmenerodev.kweather.feature.placedetails.model.responses.forecasts


import com.google.gson.annotations.SerializedName

data class Temperature(
    @SerializedName("Maximum")
    val maximum: Maximum,
    @SerializedName("Minimum")
    val minimum: Minimum
)