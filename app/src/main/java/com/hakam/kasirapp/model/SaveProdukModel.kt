package com.hakam.kasirapp.model

import com.google.gson.annotations.SerializedName

data class SaveProdukModel(

    @SerializedName("code")
    val code: Int,

    @SerializedName("msg")
    val msg: String
)
