package com.example.trabalho3

class Service (val apiRepository: ApiRepository){

    fun saveLocation (id: String, name: String) {}

    fun listLocations () {}

    fun deleteLocation (id: String) {}

    fun generateReportByLocationName(name: String){}

    fun generateReportByLocationId(Id: String) {}
}