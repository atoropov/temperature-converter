package com.example.templibrary

enum class Temperature {
    Celcius, Reamur, Fahrenheit, Kelvin;

    fun convert(value: Double, to: Temperature): Double {
        when {
            this == Celcius -> {
                when (to) {
                    Reamur -> return 4.0 / 5.0 * value
                    Fahrenheit -> return 9.0 / 5.0 * value + 32
                    Kelvin -> return value + 273
                    else -> {
                    }
                }
            }
            to == Celcius -> {
                when (this) {
                    Reamur -> return 5.0 / 4.0 * value
                    Fahrenheit -> return (value - 32) * (5.0 / 9.0)
                    Kelvin -> return value - 273
                    else -> {
                    }
                }
            }
            else -> {
                val celcius = convert(value,
                    Celcius
                )
                return convert(celcius, to)
            }
        }
        return value
    }
}