package com.joancolmenerodev.kweather.feature.placesearcher.model


import com.google.gson.annotations.SerializedName

data class CitiesResponse(
    @SerializedName("AdministrativeArea")
    val administrativeArea: AdministrativeArea,
    @SerializedName("Country")
    val country: Country,
    @SerializedName("Key")
    val key: String,
    @SerializedName("LocalizedName")
    val localizedName: String,
    @SerializedName("Rank")
    val rank: Int,
    @SerializedName("Type")
    val type: String,
    @SerializedName("Version")
    val version: Int
)