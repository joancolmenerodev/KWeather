package com.joancolmenerodev.kweather.feature.placedetails.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.joancolmenerodev.kweather.R
import com.joancolmenerodev.kweather.feature.placedetails.model.viewmodels.Forecast5DaysViewModel

class Forecast5DayAdapter(private val forecast5DaysViewModel: Forecast5DaysViewModel) :
    RecyclerView.Adapter<Forecast5DayViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): Forecast5DayViewHolder {
        return Forecast5DayViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.next_five_days_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return forecast5DaysViewModel.dailyForecasts.size
    }

    override fun onBindViewHolder(holder: Forecast5DayViewHolder, position: Int) {
        holder.bind(forecast5DaysViewModel.dailyForecasts[position])

    }

}