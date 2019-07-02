package com.joancolmenerodev.kweather.feature.placesearcher.presenter

import com.joancolmenerodev.kweather.base.ui.AbstractPresenter
import com.joancolmenerodev.kweather.feature.placesearcher.usecases.GetCitiesListUseCase

class CitiesListPresenterImpl(private val getCitiesListUseCase: GetCitiesListUseCase) :
    AbstractPresenter<CitiesListContract.View>(),CitiesListContract.Presenter {

    override fun findCity(city: String) {
        view?.hideKeyboard()
        view?.showProgressBar(true)
        getCitiesListUseCase.invoke(city,
            {
                view?.showProgressBar(false)
                if(it.isNotEmpty()){
                    view?.showCitiesList(it)
                }
                else{
                    view?.showNoCityFound()
                }

            },
            {
                view?.showProgressBar(false)
                view?.showError(it.toString())
            })
    }

    override fun onCityClicked(cityKey: String, cityAndRegionText: String) {
        view?.navigateToCityWeather(cityKey, cityAndRegionText)
    }

    override fun onViewDetached() {
        super.onViewDetached()
        getCitiesListUseCase.dispose()
    }

}