package com.example.trabalho3.classes.location

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Location (
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val locationId: String,
    val locationName: String
)