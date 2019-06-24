package com.joancolmenerodev.kweather.feature.placedetails.model

import com.joancolmenerodev.kweather.R

enum class WeatherIcons(val iconId: Int) {
    SUNNY(R.drawable.sunny),
    MOSTLY_SUNNY(R.drawable.mostly_sunny),
    FOG(R.drawable.fog),
    CLOUD(R.drawable.cloud),
    SHOWER(R.drawable.cloud_shower),
    MOSTLY_CLOUD_SHOWER(R.drawable.day_cloud_shower),
    T_STORM(R.drawable.cloud_shower_rain),
    MOSTLY_CLOUD_STORM(R.drawable.day_cloud_rain),
    RAIN(R.drawable.cloud_rain),
    ICE(R.drawable.snow),
    HOT(R.drawable.hot),
    COLD(R.drawable.cold),
    WINDY(R.drawable.windy),
    CLEAR(R.drawable.clear),
    MOSTLY_CLEAR(R.drawable.mostly_clear),
    HAZY_MOON(R.drawable.night_cloud_fog),
    HAZY_SUN(R.drawable.day_cloud_fog),
    FLURRIES(R.drawable.cloud_snow),
    DAY_FLURRIES(R.drawable.day_cloud_snow),
    NIGHT_FLURRIES(R.drawable.night_cloud_snow),
    SNOW(R.drawable.cloud_snow),
    NIGHT_MOSTLY_CLOUD_SHOWER(R.drawable.night_cloud_shower),
    NIGHT_CLOUD_STORM(R.drawable.night_shower_rain),
    DANGER(R.drawable.danger)
}