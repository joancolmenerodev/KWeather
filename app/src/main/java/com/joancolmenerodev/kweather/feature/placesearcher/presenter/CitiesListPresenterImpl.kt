package com.joancolmenerodev.kweather.feature.placesearcher.presenter

import com.joancolmenerodev.kweather.feature.placesearcher.usecases.GetCitiesListUseCase

class CitiesListPresenterImpl(private val getCitiesListUseCase: GetCitiesListUseCase) : CitiesListContract.Presenter {

    private var mView: CitiesListContract.View? = null

    override fun findCity(city: String) {
        mView?.hideKeyboard()
        mView?.showProgressBar(true)
        getCitiesListUseCase.invoke(city,
            {
                mView?.showProgressBar(false)
                if(it.isNotEmpty()){
                    mView?.showCitiesList(it)
                }
                else{
                    mView?.showNoCityFound()
                }

            },
            {
                mView?.showProgressBar(false)
                mView?.showError(it.toString())
            })
    }

    override fun onCityClicked(cityKey: String, cityAndRegionText: String) {
        mView?.navigateToCityWeather(cityKey, cityAndRegionText)
    }

    override fun attachView(view: CitiesListContract.View) {
        mView = view
    }

    override fun detachView() {
        getCitiesListUseCase.dispose()
        mView = null
    }
}