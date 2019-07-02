package com.joancolmenerodev.kweather.feature.placedetails.presenter

import com.joancolmenerodev.kweather.base.ui.AbstractPresenter
import com.joancolmenerodev.kweather.feature.placedetails.model.mapper.getDrawableFromIconNumber
import com.joancolmenerodev.kweather.feature.placedetails.usecases.GetCurrentConditionsUseCase
import com.joancolmenerodev.kweather.feature.placedetails.usecases.GetForecasts5DaysUseCase
import kotlin.math.roundToInt

class PlaceDetailPresenterImpl(
    private val getCurrentConditionsUseCase: GetCurrentConditionsUseCase,
    private val getForecasts5DaysUseCase: GetForecasts5DaysUseCase
) : AbstractPresenter<PlaceDetailsContract.View>(),PlaceDetailsContract.Presenter {


    override fun loadCurrentData(cityKey: String) {
        view?.showProgressBar(true)
        getCurrentConditionsUseCase.invoke(
            cityKey,
            {
                displayDayOrNight(it.dayTime)
                displayHumidity(it.relativeHumidity)
                displayWeatherText(it.weatherText)
                displayWeatherIcon(it.weatherIcon)
                displayWindText(it.wind.speed.metric.value)
                displayTemperature(it.temperature.metric.value)
                displayCloudCover(it.cloudCover)
                displayMaxTemp(it.maxTemp.past12HourRange.maximum.metric.value)
                displayMinTemp(it.maxTemp.past12HourRange.minimum.metric.value)
                stopCurrentDataProgressBar()
            },
            {
                stopCurrentDataProgressBar()
                displayErrorMessage(it.toString())
                //TODO: Create a new method for error handling
            }
        )
    }

    private fun displayMinTemp(minTemp: Double) {
        view?.displayMinTemp(minTemp.roundToInt().toString())
    }
    private fun displayMaxTemp(maxTemp: Double) {
        view?.displayMaxTemp(maxTemp.roundToInt().toString())
    }

    private fun displayErrorMessage(errorMessage: String) {
        view?.showError(errorMessage)

    }

    private fun stopCurrentDataProgressBar() {
        view?.showProgressBar(false)
    }

    private fun displayCloudCover(cloudCover: Int) {
        view?.displayCloudCover(cloudCover)

    }

    private fun displayTemperature(temperatureValue: Double) {
        view?.displayTemperature(temperatureValue.roundToInt().toString())
    }

    private fun displayWindText(windSpeedValue: Double) {
        view?.displayWind(windSpeedValue)

    }

    private fun displayWeatherIcon(weatherIcon: Int) {
        view?.displayWeatherIcon(getDrawableFromIconNumber(weatherIcon))
    }

    private fun displayWeatherText(weatherText: String) {
        view?.displayWeatherText(weatherText)

    }

    private fun displayHumidity(relativeHumidity: Int) {
        view?.displayHumidity(relativeHumidity)
    }

    override fun loadForecast5Days(cityKey: String) {
        view?.showProgressBarForecast(true)
        getForecasts5DaysUseCase.invoke(
            cityKey,
            {
                view?.displayForecast5Days(it)
                view?.showProgressBarForecast(false)

            },
            {
                view?.showError(it.toString())
                view?.showProgressBarForecast(false)
            })
    }

    override fun onViewDetached() {
        super.onViewDetached()
        getCurrentConditionsUseCase.dispose()
        getForecasts5DaysUseCase.dispose()
    }


    private fun displayDayOrNight(dayTime: Boolean) {
        if (dayTime) view?.displayDayBackground()
        else view?.displayNightBackground()
    }

}