package com.joancolmenerodev.kweather.feature.placesearcher.model

fun cityListMapper(citiesResponse: List<CitiesResponse>) = citiesResponse.map { CitiesListViewModel(it.key,it.localizedName,it.country.iD) }

