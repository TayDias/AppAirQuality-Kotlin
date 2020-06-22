package com.example.trabalho3.classes.location

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
class Location (
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val locationId: String,
    val locationName: String
) : Parcelable