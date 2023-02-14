package com.example.proyectorestapi

import com.google.gson.annotations.SerializedName

data class Nutriments(
    @SerializedName("energy-kcal_100g") var kcal_100g: Double)
