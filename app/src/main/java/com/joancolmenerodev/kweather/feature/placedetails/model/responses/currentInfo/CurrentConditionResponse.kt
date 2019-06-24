package com.joancolmenerodev.kweather.feature.placedetails.model.responses.currentInfo

import com.google.gson.annotations.SerializedName

data class CurrentConditionResponse(
    @SerializedName("LocalObservationDateTime") val localObservationDateTime: String,
    @SerializedName("EpochTime") val epochTime: String,
    @SerializedName("WeatherText") val weatherText: String,
    @SerializedName("WeatherIcon") val weatherIcon: Int,
    @SerializedName("HasPrecipitation") val hasPrecipitation: Boolean,
    @SerializedName("PrecipitationType") val precipitationType: String?,
    @SerializedName("IsDayTime") val isDayTime: Boolean,
    @SerializedName("Temperature") val temperature: Temperature,
    @SerializedName("RelativeHumidity") val relativeHumidity: Int,
    @SerializedName("RealFeelTemperatureShade") val realFeelTemperatureShade: RealFeelTemperatureShade,
    @SerializedName("RealFeelTemperature") val realFeelTemperature: RealFeelTemperature,
    @SerializedName("DewPoint") val dewPoint: DewPoint,
    @SerializedName("ObstructionsToVisibility") val obstructionsToVisibility: String,
    @SerializedName("Visibility") val visibility: Visibility,
    @SerializedName("UVIndex") val uVIndex: Int,
    @SerializedName("UVIndexText") val uVIndexText: String,
    @SerializedName("CloudCover") val cloudCover: Int,
    @SerializedName("WindGust") val windGust: WindGust,
    @SerializedName("Wind") val wind: Wind,
    @SerializedName("MobileLink") val mobileLink: String,
    @SerializedName("Link") val link: String,
    @SerializedName("TemperatureSummary") val temperatureSummary: TemperatureSummary,
    @SerializedName("PrecipitationSummary") val precipitationSummary: PrecipitationSummary,
    @SerializedName("Ceiling") val celling: Celling,
    @SerializedName("Pressure") val pressure: Pressure,
    @SerializedName("PressureTendency") val pressureTendency: PressureTendency,
    @SerializedName("Past24HourTemperatureDeparture") val past24HourTemperatureDeparture: Past24HourTemperatureDeparture,
    @SerializedName("ApparentTemperature") val apparentTemperature: ApparentTemperature,
    @SerializedName("WindChillTemperature") val windChillTemperature: WindChillTemperature,
    @SerializedName("WetBulbTemperature") val wetBulbTemperature: WetBulbTemperature,
    @SerializedName("Precip1hr") val precip1hr: Precip1hr


)