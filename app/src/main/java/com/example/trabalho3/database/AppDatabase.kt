package com.example.trabalho3.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.trabalho3.classes.location.Location
import com.example.trabalho3.classes.location.LocationDao

@Database(entities = [Location::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun locationDao(): LocationDao
}