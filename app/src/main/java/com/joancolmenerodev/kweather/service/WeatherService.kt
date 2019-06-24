package com.joancolmenerodev.kweather.service

import com.joancolmenerodev.kweather.feature.placedetails.model.responses.currentInfo.CurrentConditionResponse
import com.joancolmenerodev.kweather.feature.placedetails.model.responses.forecasts.ForecastResponse
import com.joancolmenerodev.kweather.feature.placesearcher.model.CitiesResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherService {

    @GET("locations/v1/cities/autocomplete")
    suspend fun getGithubUser(
        @Query("apikey") apiKey: String,
        @Query("q") place: String
    ): List<CitiesResponse>

    @GET("locations/v1/cities/autocomplete")
    fun getCities(@Query("apikey") apiKey: String, @Query("q") value: String)

    @GET("currentconditions/v1/{cityKey}")
    suspend fun getCurrentConditions(@Path("cityKey") cityKey: String, @Query("apikey") apiKey: String, @Query("details") details: Boolean): List<CurrentConditionResponse>

    @GET("forecasts/v1/daily/5day/{cityKey}")
    suspend fun getForecastOf5Day(@Path("cityKey") cityKey: String, @Query("apikey") apiKey: String): ForecastResponse
}