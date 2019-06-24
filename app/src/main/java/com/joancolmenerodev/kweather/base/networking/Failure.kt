package com.joancolmenerodev.kweather.base.networking

sealed class Failure {
    data class Error(val errorMessage: String) : Failure()
}