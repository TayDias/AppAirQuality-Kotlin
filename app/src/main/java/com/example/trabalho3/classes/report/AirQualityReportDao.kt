package com.example.trabalho3.classes.report

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AirQualityReportDao {

    @Insert
    fun insert(airQualityReport: AirQualityReport): Long

    @Query("SELECT * FROM airqualityreport WHERE id = :id LIMIT 1")
    fun exists(id: Long): AirQualityReport
}