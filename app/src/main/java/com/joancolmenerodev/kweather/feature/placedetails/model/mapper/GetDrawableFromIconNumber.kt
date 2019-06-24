package com.joancolmenerodev.kweather.feature.placedetails.model.mapper

import com.joancolmenerodev.kweather.feature.placedetails.model.WeatherIcons

fun getDrawableFromIconNumber(weatherIcon: Int): Int {
    return when (weatherIcon) {
        in 1..4 -> WeatherIcons.SUNNY.iconId
        5 -> WeatherIcons.HAZY_SUN.iconId
        6 -> WeatherIcons.MOSTLY_SUNNY.iconId
        in 7..8 -> WeatherIcons.CLOUD.iconId
        9 -> WeatherIcons.FOG.iconId
        12 -> WeatherIcons.SHOWER.iconId
        in 13..14 -> WeatherIcons.MOSTLY_CLOUD_SHOWER.iconId
        15 -> WeatherIcons.T_STORM.iconId
        in 16..17 -> WeatherIcons.MOSTLY_CLOUD_STORM.iconId
        18 -> WeatherIcons.RAIN.iconId
        19 -> WeatherIcons.FLURRIES.iconId
        in 20..21 -> WeatherIcons.DAY_FLURRIES.iconId
        22 -> WeatherIcons.SNOW.iconId
        23 -> WeatherIcons.DAY_FLURRIES.iconId
        24 -> WeatherIcons.ICE.iconId
        in 25..29 -> WeatherIcons.RAIN.iconId
        30 -> WeatherIcons.HOT.iconId
        31 -> WeatherIcons.COLD.iconId
        32 -> WeatherIcons.WINDY.iconId
        33 -> WeatherIcons.CLEAR.iconId
        in 34..36 -> WeatherIcons.MOSTLY_CLEAR.iconId
        37 -> WeatherIcons.HAZY_MOON.iconId
        38 -> WeatherIcons.MOSTLY_CLEAR.iconId
        in 39..40 -> WeatherIcons.NIGHT_MOSTLY_CLOUD_SHOWER.iconId
        in 41..42 -> WeatherIcons.NIGHT_CLOUD_STORM.iconId
        in 43..44 -> WeatherIcons.NIGHT_FLURRIES.iconId
        else -> WeatherIcons.DANGER.iconId
    }
}