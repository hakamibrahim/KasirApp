package com.hakam.kasirapp.network

import com.hakam.kasirapp.model.ListPenjualanModel
import com.hakam.kasirapp.model.ListProdukModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndpoint {

    @GET("produk")
    fun getProduk(): Call<List<ListProdukModel>>

    @GET("penjualan")
    fun getPenjualan(): Call<ListPenjualanModel>
}