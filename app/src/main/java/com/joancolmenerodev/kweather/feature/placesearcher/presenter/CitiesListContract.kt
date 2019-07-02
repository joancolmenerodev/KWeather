package com.joancolmenerodev.kweather.feature.placesearcher.presenter

import com.joancolmenerodev.kweather.base.ui.BasePresenter
import com.joancolmenerodev.kweather.base.ui.BaseView
import com.joancolmenerodev.kweather.feature.placesearcher.model.CitiesListViewModel

interface CitiesListContract {

    interface View : BaseView {
        fun showCitiesList(citiesListViewModel: List<CitiesListViewModel>)
        fun showNoCityFound()
        fun navigateToCityWeather(cityKey: String, cityAndRegionText: String)
        fun hideKeyboard()
        fun showProgressBar(isVisible: Boolean)
        fun showError(errorMessage: String)
    }

    interface Presenter : BasePresenter<View> {
        fun findCity(city: String)
        fun onCityClicked(cityKey: String, cityAndRegionText: String)
    }
}