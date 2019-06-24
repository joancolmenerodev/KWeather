package com.joancolmenerodev.kweather.feature.placedetails.model.mapper

import android.annotation.SuppressLint
import java.text.SimpleDateFormat

@SuppressLint("SimpleDateFormat")
fun convertDateToWeekDay(date: String) : String{
    //date example --> 2019-06-24T07:00:00+08:00
    val sd = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX")
    val currentDate = sd.parse(date)
    val format = SimpleDateFormat("EEE")
    return format.format(currentDate)
}