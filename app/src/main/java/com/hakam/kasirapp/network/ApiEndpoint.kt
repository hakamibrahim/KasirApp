package com.hakam.kasirapp.network

import com.hakam.kasirapp.model.DetailPenjualanModel
import com.hakam.kasirapp.model.ListPenjualanModel
import com.hakam.kasirapp.model.ListProdukModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Path

interface ApiEndpoint {

    @GET("produk")
    fun getProduk(): Call<List<ListProdukModel>>

    @Headers("x-key: bd0b3ae6651538fac2515baafc9326c5")
    @GET("penjualan")
    fun getPenjualan(): Call<List<ListPenjualanModel>>

    @Headers("x-key: bd0b3ae6651538fac2515baafc9326c5")
    @GET("penjualan/detail/{id}")
    fun getDetail(
        @Path("id") id: Int,
    ): Call<List<DetailPenjualanModel>>

}