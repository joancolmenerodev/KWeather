package com.joancolmenerodev.kweather.base.di

import com.joancolmenerodev.kweather.service.WeatherService
import okhttp3.OkHttpClient
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val retrofitModule = Kodein.Module("retrofitModule" ){

    bind<OkHttpClient>() with singleton {
        OkHttpClient().newBuilder().build()
    }
    bind<Retrofit>() with singleton {
        Retrofit.Builder()
            .baseUrl("https://dataservice.accuweather.com/")
            .client(instance())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    bind<WeatherService>() with singleton {
        instance<Retrofit>().create(WeatherService::class.java)
    }
}