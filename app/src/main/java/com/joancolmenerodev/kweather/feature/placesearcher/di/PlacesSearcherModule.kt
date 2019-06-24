package com.joancolmenerodev.kweather.feature.placesearcher.di

import com.joancolmenerodev.kweather.feature.placesearcher.presenter.CitiesListContract
import com.joancolmenerodev.kweather.feature.placesearcher.presenter.CitiesListPresenterImpl
import com.joancolmenerodev.kweather.feature.placesearcher.repository.CitiesListRepositoryImpl
import com.joancolmenerodev.kweather.feature.placesearcher.usecases.GetCitiesListUseCase
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

val placesSearcherModule = Kodein.Module("PlacesSearcherModule"){

    bind<CitiesListRepositoryImpl>() with singleton { CitiesListRepositoryImpl(instance()) }
    bind<CitiesListContract.Presenter>() with singleton { CitiesListPresenterImpl(instance()) }
    bind<GetCitiesListUseCase>() with singleton { GetCitiesListUseCase(instance()) }
}