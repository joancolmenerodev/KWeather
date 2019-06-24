package com.joancolmenerodev.kweather.feature.placesearcher.ui

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.joancolmenerodev.kweather.R
import com.joancolmenerodev.kweather.feature.placedetails.ui.PlaceDetailActivity
import com.joancolmenerodev.kweather.feature.placesearcher.model.CitiesListViewModel
import com.joancolmenerodev.kweather.feature.placesearcher.presenter.CitiesListContract
import com.joancolmenerodev.kweather.feature.placesearcher.ui.adapter.CitiesListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class MainActivity : AppCompatActivity(), CitiesListContract.View, KodeinAware {

    override val kodein by kodein()
    private val presenter: CitiesListContract.Presenter by instance()
    private lateinit var citiesAdapter: CitiesListAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        iv_search.setOnClickListener { presenter.findCity(et_place.text.toString()) }
    }

    override fun showCitiesList(citiesListViewModel: List<CitiesListViewModel>) {
        linear_error_search.visibility = View.GONE
        rv_citiesList.visibility = View.VISIBLE
        citiesAdapter = CitiesListAdapter(citiesList = citiesListViewModel)
        rv_citiesList.adapter = citiesAdapter
        rv_citiesList.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        citiesAdapter.let {
            it.onItemClick = { cityKey, cityAndRegionText -> presenter.onCityClicked(cityKey, cityAndRegionText)}
        }
    }

    override fun showNoCityFound() {
        linear_error_search.visibility = View.VISIBLE
        rv_citiesList.visibility = View.GONE
    }


    override fun navigateToCityWeather(cityKey: String, cityAndRegionText: String) {
        val intent = Intent(
            this@MainActivity,
            PlaceDetailActivity::class.java
        )
        val bundle = Bundle().also {
            it.putString("cityKey", cityKey)
            it.putString("cityAndRegionText",cityAndRegionText)
        }
        intent.putExtras(bundle)
        startActivity(intent)
    }

    override fun showError(errorMessage: String) {
        linear_error_search.visibility = View.VISIBLE
        Snackbar.make(contraint_parent_main_activity, errorMessage, Snackbar.LENGTH_SHORT).show()
    }

    override fun showProgressBar(isVisible: Boolean) {
        pb_cities.visibility = if (isVisible) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }

    override fun hideKeyboard() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
        imm?.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
    }

    override fun onResume() {
        super.onResume()
        presenter.attachView(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }

}
