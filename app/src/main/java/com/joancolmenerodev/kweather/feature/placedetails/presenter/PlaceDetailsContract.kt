package com.joancolmenerodev.kweather.feature.placedetails.presenter

import com.joancolmenerodev.kweather.base.ui.BasePresenter
import com.joancolmenerodev.kweather.base.ui.BaseView
import com.joancolmenerodev.kweather.feature.placedetails.model.viewmodels.Forecast5DaysViewModel

interface PlaceDetailsContract {

    interface View : BaseView {
        fun displayWeatherText(weatherText: String)
        fun displayWeatherIcon(weatherIcon: Int)
        fun displayDayBackground()
        fun displayNightBackground()
        fun displayTemperature(temperatureValue: String)
        fun displayMinTemp(minTemp: String)
        fun displayMaxTemp(maxTemp: String)
        fun displayHumidity(relativeHumidity: Int)
        fun displayWind(windSpeedValue: Double)
        fun displayCloudCover(cloudCover: Int)
        fun showProgressBarForecast(show: Boolean)
        fun displayForecast5Days(forecast5DaysViewModel: Forecast5DaysViewModel)
        fun showProgressBar(isVisible: Boolean)
        fun showError(errorMessage: String)

    }

    interface Presenter : BasePresenter<View> {
        fun loadCurrentData(cityKey: String)
        fun loadForecast5Days(cityKey: String)

    }
}