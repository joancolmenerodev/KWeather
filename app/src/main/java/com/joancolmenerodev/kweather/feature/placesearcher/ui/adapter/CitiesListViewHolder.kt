package com.joancolmenerodev.kweather.feature.placesearcher.ui.adapter

import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.joancolmenerodev.kweather.R
import com.joancolmenerodev.kweather.feature.placesearcher.model.CitiesListViewModel

class CitiesListViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    private val cityAndRegion: TextView = itemView.findViewById(R.id.tv_cityRegion)
    private val cardCityAndRegion : ConstraintLayout = itemView.findViewById(R.id.contraint_parent_cities_list_item)

    fun bind(
        cityViewModel: CitiesListViewModel,
        onItemClick: (cityId: String, cityAndRegionText: String) -> Unit
    ){
        cityAndRegion.text = String.format(itemView.resources.getString(R.string.city_and_region_text,cityViewModel.cityName,cityViewModel.regionId))
        cardCityAndRegion.setOnClickListener {
            onItemClick.invoke(cityViewModel.cityKey,cityAndRegion.text.toString())
        }
    }

}