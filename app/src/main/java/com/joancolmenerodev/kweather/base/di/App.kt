package com.joancolmenerodev.kweather.base.di

import android.app.Application
import com.joancolmenerodev.kweather.feature.placedetails.di.placeDetailsModule
import com.joancolmenerodev.kweather.feature.placesearcher.di.placesSearcherModule
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware

class App : Application(), KodeinAware {

    override val kodein by Kodein.lazy {
        import(retrofitModule)
        import(placesSearcherModule)
        import(placeDetailsModule)
    }
}