package com.joancolmenerodev.kweather.feature.placedetails.presenter

import com.joancolmenerodev.kweather.feature.placedetails.model.mapper.getDrawableFromIconNumber
import com.joancolmenerodev.kweather.feature.placedetails.usecases.GetCurrentConditionsUseCase
import com.joancolmenerodev.kweather.feature.placedetails.usecases.GetForecasts5DaysUseCase
import kotlin.math.roundToInt

class PlaceDetailPresenterImpl(
    private val getCurrentConditionsUseCase: GetCurrentConditionsUseCase,
    private val getForecasts5DaysUseCase: GetForecasts5DaysUseCase
) : PlaceDetailsContract.Presenter {

    private var mView: PlaceDetailsContract.View? = null

    override fun loadCurrentData(cityKey: String) {
        mView?.showProgressBar(true)
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
        mView?.displayMinTemp(minTemp.roundToInt().toString())
    }
    private fun displayMaxTemp(maxTemp: Double) {
        mView?.displayMaxTemp(maxTemp.roundToInt().toString())
    }

    private fun displayErrorMessage(errorMessage: String) {
        mView?.showError(errorMessage)

    }

    private fun stopCurrentDataProgressBar() {
        mView?.showProgressBar(false)
    }

    private fun displayCloudCover(cloudCover: Int) {
        mView?.displayCloudCover(cloudCover)

    }

    private fun displayTemperature(temperatureValue: Double) {
        mView?.displayTemperature(temperatureValue.roundToInt().toString())
    }

    private fun displayWindText(windSpeedValue: Double) {
        mView?.displayWind(windSpeedValue)

    }

    private fun displayWeatherIcon(weatherIcon: Int) {
        mView?.displayWeatherIcon(getDrawableFromIconNumber(weatherIcon))
    }

    private fun displayWeatherText(weatherText: String) {
        mView?.displayWeatherText(weatherText)

    }

    private fun displayHumidity(relativeHumidity: Int) {
        mView?.displayHumidity(relativeHumidity)
    }

    override fun loadForecast5Days(cityKey: String) {
        mView?.showProgressBarForecast(true)
        getForecasts5DaysUseCase.invoke(
            cityKey,
            {
                mView?.displayForecast5Days(it)
                mView?.showProgressBarForecast(false)

            },
            {
                mView?.showError(it.toString())
                mView?.showProgressBarForecast(false)
            })
    }

    override fun attachView(view: PlaceDetailsContract.View) {
        mView = view
    }

    override fun detachView() {
        mView = null
        getCurrentConditionsUseCase.dispose()
        getForecasts5DaysUseCase.dispose()

    }


    private fun displayDayOrNight(dayTime: Boolean) {
        if (dayTime) mView?.displayDayBackground()
        else mView?.displayNightBackground()
    }

}