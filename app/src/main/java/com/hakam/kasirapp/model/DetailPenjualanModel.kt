package com.hakam.kasirapp.model

import com.google.gson.annotations.SerializedName

data class DetailPenjualanModel(

    @SerializedName("id")
    val id : Int,

    @SerializedName("nama")
    val nama : String,

    @SerializedName("harga")
    val harga : Int,

    @SerializedName("qty")
    val qty : Int
)
