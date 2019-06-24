package com.joancolmenerodev.kweather.feature.placesearcher.model


import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("ID")
    val iD: String,
    @SerializedName("LocalizedName")
    val localizedName: String
)