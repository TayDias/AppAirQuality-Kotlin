package com.example.trabalho3

import java.time.format.DateTimeFormatter

class AirQualityReport (
    val aqi: Float,
    val Location: Location,
    val lastUpdate: DateTimeFormatter,
    val score: AirQualityScore
)