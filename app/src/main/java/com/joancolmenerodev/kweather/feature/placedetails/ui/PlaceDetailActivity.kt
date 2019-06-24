package com.joancolmenerodev.kweather.feature.placedetails.ui

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.joancolmenerodev.kweather.R
import com.joancolmenerodev.kweather.feature.placedetails.model.viewmodels.Forecast5DaysViewModel
import com.joancolmenerodev.kweather.feature.placedetails.presenter.PlaceDetailsContract
import com.joancolmenerodev.kweather.feature.placedetails.ui.adapter.Forecast5DayAdapter
import kotlinx.android.synthetic.main.activity_place_detail.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class PlaceDetailActivity : AppCompatActivity(), PlaceDetailsContract.View, KodeinAware {
    override fun displayForecast5Days(forecast5DaysViewModel: Forecast5DaysViewModel) {
        adapter = Forecast5DayAdapter(forecast5DaysViewModel)
        rv_forecast.adapter = adapter
        rv_forecast.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    }

    override val kodein by kodein()
    private val presenter: PlaceDetailsContract.Presenter by instance()
    private lateinit var cityAndRegion: String
    private lateinit var cityKey: String
    private lateinit var adapter: Forecast5DayAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_place_detail)
        intent.let {
            cityKey = it?.extras?.getString("cityKey")!!
            cityAndRegion = it.extras?.getString("cityAndRegionText")!!

        }
        tv_cityAndRegion.text = cityAndRegion
    }

    override fun displayWeatherText(weatherText: String) {
        tv_weather.text = weatherText
    }

    override fun displayWeatherIcon(weatherIcon: Int) {
        iv_weather.background = ContextCompat.getDrawable(this, weatherIcon)
    }

    override fun displayDayBackground() {
        relative_layout_background.background = ContextCompat.getDrawable(this, R.drawable.bg_day)
    }

    override fun displayNightBackground() {
        relative_layout_background.background = ContextCompat.getDrawable(this, R.drawable.bg_night)
    }

    override fun displayTemperature(temperatureValue: String) {
        tv_current_temperature.text = temperatureValue
    }

    override fun displayMinTemp(minTemp: String) {
        tv_min_temp.text = String.format(resources.getString(R.string.temp_text), minTemp)
    }

    override fun displayMaxTemp(maxTemp: String) {
        tv_max_temp.text = String.format(resources.getString(R.string.temp_text), maxTemp)
    }

    override fun displayHumidity(relativeHumidity: Int) {
        tv_humidity.text = String.format(resources.getString(R.string.humidity_text), relativeHumidity.toString())
    }

    override fun displayWind(windSpeedValue: Double) {
        tv_wind.text = String.format(resources.getString(R.string.wind_text), windSpeedValue.toString())
    }

    override fun displayCloudCover(cloudCover: Int) {
        tv_cloud_cover.text = String.format(resources.getString(R.string.cloudcoverage_text), cloudCover.toString())
    }

    override fun showProgressBarForecast(show: Boolean) {
        pb_forecast.visibility = if (show) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }

    override fun showError(errorMessage: String) {
        Snackbar.make(relative_layout_background, errorMessage, Snackbar.LENGTH_LONG).show()
    }

    override fun showProgressBar(isVisible: Boolean) {
        pb_current.visibility = if (isVisible) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }

    override fun onResume() {
        presenter.attachView(this)
        presenter.loadCurrentData(cityKey)
        super.onResume()
        presenter.loadForecast5Days(cityKey)
    }

    override fun onBackPressed() {
        presenter.detachView()
        super.onBackPressed()

    }

    override fun onPause() {
        presenter.detachView()
        super.onPause()
    }
    override fun onDestroy() {
        presenter.detachView()
        super.onDestroy()
    }


}
