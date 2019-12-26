package com.joancolmenerodev.kweather.feature.placedetails.di

import com.joancolmenerodev.kweather.feature.placedetails.presenter.PlaceDetailPresenterImpl
import com.joancolmenerodev.kweather.feature.placedetails.presenter.PlaceDetailsContract
import com.joancolmenerodev.kweather.feature.placedetails.repository.currentconditions.CurrentConditionsRepositoryImpl
import com.joancolmenerodev.kweather.feature.placedetails.repository.forecast.ForecastRepositoryImpl
import com.joancolmenerodev.kweather.feature.placedetails.usecases.GetCurrentConditionsUseCase
import com.joancolmenerodev.kweather.feature.placedetails.usecases.GetForecasts5DaysUseCase
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton


val placeDetailsModule = Kodein.Module("PlaceDetailModules") {

    bind<ForecastRepositoryImpl>() with singleton { ForecastRepositoryImpl(instance()) }
    bind<CurrentConditionsRepositoryImpl>() with singleton { CurrentConditionsRepositoryImpl(instance()) }
    bind<GetForecasts5DaysUseCase>() with singleton { GetForecasts5DaysUseCase(instance()) }
    bind<GetCurrentConditionsUseCase>() with singleton { GetCurrentConditionsUseCase(instance()) }
    bind<PlaceDetailsContract.Presenter>() with provider { PlaceDetailPresenterImpl(instance(), instance()) }

}