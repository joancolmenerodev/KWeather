package com.joancolmenerodev.kweather.feature.placesearcher.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.joancolmenerodev.kweather.R
import com.joancolmenerodev.kweather.feature.placesearcher.model.CitiesListViewModel

class CitiesListAdapter(private val citiesList: List<CitiesListViewModel>) : RecyclerView.Adapter<CitiesListViewHolder>(){

    lateinit var onItemClick: (cityId: String, cityAndRegionText: String) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): CitiesListViewHolder {
        return CitiesListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.cities_result_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return citiesList.size
    }

    override fun onBindViewHolder(holder: CitiesListViewHolder, position: Int) {
        holder.bind(citiesList[position], onItemClick)
    }


}