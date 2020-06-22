package com.example.trabalho3.classes.report

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.trabalho3.classes.AirQualityScore
import com.example.trabalho3.classes.location.Location
import java.time.format.DateTimeFormatter

@Entity
class AirQualityReport (
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val aqi: Float,
    val Location: Location,
    val lastUpdate: DateTimeFormatter,
    val score: AirQualityScore
)