package com.joancolmenerodev.kweather.feature.placedetails.model.responses.currentInfo

import com.google.gson.annotations.SerializedName

data class Temperature(@SerializedName("Metric") val metric: Metric, @SerializedName("Imperial") val imperial: Imperial)
data class RealFeelTemperature(@SerializedName("Metric") val metric: Metric, @SerializedName("Imperial") val imperial: Imperial)
data class RealFeelTemperatureShade(@SerializedName("Metric") val metric: Metric, @SerializedName("Imperial") val imperial: Imperial)
data class DewPoint(@SerializedName("Metric") val metric: Metric, @SerializedName("Imperial") val imperial: Imperial)
data class Speed(@SerializedName("Metric") val metric: Metric, @SerializedName("Imperial") val imperial: Imperial)
data class Wind(@SerializedName("Direction")val direction: Direction,@SerializedName("Speed") val speed: Speed)
data class WindGust(@SerializedName("Speed")val speed: Speed)
data class Visibility(@SerializedName("Metric") val metric: Metric, @SerializedName("Imperial") val imperial: Imperial)
data class Celling(@SerializedName("Metric") val metric: Metric, @SerializedName("Imperial") val imperial: Imperial)
data class Pressure(@SerializedName("Metric") val metric: Metric, @SerializedName("Imperial") val imperial: Imperial)
data class PressureTendency(@SerializedName("LocalizedText") val localizedText: String, @SerializedName("Code") val code: String)
data class Past24HourTemperatureDeparture(@SerializedName("Metric") val metric: Metric, @SerializedName("Imperial") val imperial: Imperial)
data class ApparentTemperature(@SerializedName("Metric") val metric: Metric, @SerializedName("Imperial") val imperial: Imperial)
data class WindChillTemperature(@SerializedName("Metric") val metric: Metric, @SerializedName("Imperial") val imperial: Imperial)
data class WetBulbTemperature(@SerializedName("Metric") val metric: Metric, @SerializedName("Imperial") val imperial: Imperial)
data class Precip1hr(@SerializedName("Metric") val metric: Metric, @SerializedName("Imperial") val imperial: Imperial)
data class Precipitation(@SerializedName("Metric") val metric: Metric, @SerializedName("Imperial") val imperial: Imperial)
data class PastHour(@SerializedName("Metric") val metric: Metric, @SerializedName("Imperial") val imperial: Imperial)
data class Past3Hours(@SerializedName("Metric") val metric: Metric, @SerializedName("Imperial") val imperial: Imperial)
data class Past6Hours(@SerializedName("Metric") val metric: Metric, @SerializedName("Imperial") val imperial: Imperial)
data class Past9Hours(@SerializedName("Metric") val metric: Metric, @SerializedName("Imperial") val imperial: Imperial)
data class Past12Hours(@SerializedName("Metric") val metric: Metric, @SerializedName("Imperial") val imperial: Imperial)
data class Past18Hours(@SerializedName("Metric") val metric: Metric, @SerializedName("Imperial") val imperial: Imperial)
data class Past24Hours(@SerializedName("Metric") val metric: Metric, @SerializedName("Imperial") val imperial: Imperial)
data class PrecipitationSummary(
    @SerializedName("Precipitation")
    val precipitation: Precipitation,
    @SerializedName("PastHour")
    val pastHour: PastHour,
    @SerializedName("Past3Hours")
    val past3Hours: Past3Hours,
    @SerializedName("Past6Hours")
    val past6Hours: Past6Hours,
    @SerializedName("Past9Hours")
    val past9Hours: Past9Hours,
    @SerializedName("Past12Hours")
    val past12Hours: Past12Hours,
    @SerializedName("Past18Hours")
    val past18Hours: Past18Hours,
    @SerializedName("Past24Hours")
    val past24Hours: Past24Hours
)

data class TemperatureSummary(
    @SerializedName("Past6HourRange")
    val past6HourRange: Past6HourRange,
    @SerializedName("Past12HourRange")
    val past12HourRange: Past12HourRange,
    @SerializedName("Past24HourRange")
    val past24HourRange: Past24HourRange
)

data class Past6HourRange(@SerializedName("Minimum") val minimum: Minimum, @SerializedName("Maximum") val maximum: Maximum)
data class Past12HourRange(@SerializedName("Minimum") val minimum: Minimum, @SerializedName("Maximum") val maximum: Maximum)
data class Past24HourRange(@SerializedName("Minimum") val minimum: Minimum, @SerializedName("Maximum") val maximum: Maximum)
data class Minimum(@SerializedName("Metric") val metric: Metric, @SerializedName("Imperial") val imperial: Imperial)
data class Maximum(@SerializedName("Metric") val metric: Metric, @SerializedName("Imperial") val imperial: Imperial)


data class Metric(
    @SerializedName("Value") val value: Double,
    @SerializedName("Unit") val unit: String,
    @SerializedName("UnitType") val unitType: Int
)

data class Imperial(
    @SerializedName("Value") val value: Double,
    @SerializedName("Unit") val unit: String,
    @SerializedName("UnitType") val unitType: Int
)

data class Direction(
    @SerializedName("Degrees") val degrees: Int,
    @SerializedName("Localized") val localized: String,
    @SerializedName("English") val english: String
)

