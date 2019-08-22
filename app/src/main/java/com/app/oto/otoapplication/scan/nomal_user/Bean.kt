package com.app.oto.otoapplication.scan.nomal_user

data class ProvinceEntity (
    val text : String,
    val id :String
)

data class CityEntity (
    val text : String,
    val id :String
)

data class DistrictEntity (
    val text : String,
    val id :String,
    val zipcode :String
)
