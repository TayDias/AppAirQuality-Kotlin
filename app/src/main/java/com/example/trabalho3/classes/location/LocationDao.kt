package com.example.trabalho3.classes.location

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface LocationDao {

    @Query("SELECT * FROM location")
    fun all(): List<Location>

    @Insert
    fun insert(location: Location): Long

    @Delete
    fun delete(location: Location)

    @Query("SELECT * FROM location WHERE id = :id LIMIT 1")
    fun exists(id: Long): Location
}