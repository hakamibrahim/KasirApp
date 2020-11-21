package com.hakam.kasirapp.model

import com.google.gson.annotations.SerializedName

data class ListPenjualanModel (

    @SerializedName("id")
    val id : Int,

    @SerializedName("tanggal")
    val tanggal : String,

    @SerializedName("harga")
    val harga : Int,

    @SerializedName("created_at")
    val created_at : String,

    @SerializedName("created_by")
    val created_by : Int,

    @SerializedName("updated_at")
    val updated_at : String,

    @SerializedName("updated_by")
    val updated_by : String,

    @SerializedName("deleted_at")
    val deleted_at : String,

    @SerializedName("deleted_by")
    val deleted_by : String)