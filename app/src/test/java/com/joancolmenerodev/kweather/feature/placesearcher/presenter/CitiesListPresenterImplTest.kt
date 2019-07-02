package com.joancolmenerodev.kweather.feature.placesearcher.presenter

import com.joancolmenerodev.kweather.feature.placesearcher.model.CitiesListViewModel
import com.joancolmenerodev.kweather.feature.placesearcher.usecases.GetCitiesListUseCase
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class CitiesListPresenterImplTest {

    @Mock
    private lateinit var view : CitiesListContract.View
    @Mock
    private lateinit var getCitiesListUseCase: GetCitiesListUseCase

    private lateinit var presenter : CitiesListPresenterImpl

    @Before
    fun setUp(){
        MockitoAnnotations.initMocks(this)
        presenter = CitiesListPresenterImpl(getCitiesListUseCase)
    }


    @Test
    fun findCity() = runBlocking{

        //Assign
        presenter.attachView(view)
        Mockito.`when`(getCitiesListUseCase.run(HONOLULU_CITY)).thenReturn(citiesResult)

        //Act
        presenter.findCity(HONOLULU_CITY)

        //Assert
        Mockito.verify(view).showCitiesList(citiesResult)
    }

    @Test
    fun onCityClicked() {
    }

    @Test
    fun attachView() {
    }

    @Test
    fun detachView() {
    }

    companion object {
        private const val HONOLULU_CITY = "Honolulu"
        private const val EMPTY_CITY = ""

        private val citiesResult = arrayListOf(
            CitiesListViewModel("1234","Honolulu","Ho")
        )
    }
}