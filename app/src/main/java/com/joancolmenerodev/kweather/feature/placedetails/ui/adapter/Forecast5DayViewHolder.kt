package com.joancolmenerodev.kweather.feature.placedetails.ui.adapter

import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.joancolmenerodev.kweather.R
import com.joancolmenerodev.kweather.feature.placedetails.model.mapper.convertDateToWeekDay
import com.joancolmenerodev.kweather.feature.placedetails.model.mapper.getDrawableFromIconNumber
import com.joancolmenerodev.kweather.feature.placedetails.model.responses.forecasts.DailyForecast

class Forecast5DayViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val forecastDayText: TextView = itemView.findViewById(R.id.tv_forecast_day_text)
    private val forecastDayImage: ImageView = itemView.findViewById(R.id.iv_item_forecast)
    private val forecastDayTemperature: TextView = itemView.findViewById(R.id.tv_forecast_temperature_text)

    fun bind(dailyForecast: DailyForecast) {
        forecastDayImage.setImageDrawable(
            ContextCompat.getDrawable(
                itemView.context,
                getDrawableFromIconNumber(dailyForecast.day.icon)
            )
        )
        forecastDayText.text = convertDateToWeekDay(dailyForecast.date)
        forecastDayTemperature.text = String.format(
            itemView.resources.getString(R.string.temp_text), calculateMedian(
                dailyForecast.temperature.maximum.value,
                dailyForecast.temperature.minimum.value
            ).toString()
        )
    }

    private fun calculateMedian(value1: Int, value2: Int): Int {
        return (fahrenheitToCel(value1) + fahrenheitToCel(value2)) / 2
    }

    private fun fahrenheitToCel(value: Int): Int {
        return ((value - 32) * 5) / 9
    }
}