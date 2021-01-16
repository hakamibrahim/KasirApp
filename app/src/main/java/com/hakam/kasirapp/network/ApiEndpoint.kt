package com.hakam.kasirapp.network

import com.hakam.kasirapp.model.DetailPenjualanModel
import com.hakam.kasirapp.model.ListPenjualanModel
import com.hakam.kasirapp.model.ListProdukModel
import com.hakam.kasirapp.model.SaveProdukModel
import retrofit2.Call
import retrofit2.http.*

interface ApiEndpoint {

    @GET("produk")
    fun getProduk(): Call<List<ListProdukModel>>

    @Headers("x-key: bd0b3ae6651538fac2515baafc9326c5")
    @GET("penjualan")
    fun getPenjualan(): Call<List<ListPenjualanModel>>

    @Headers("x-key: bd0b3ae6651538fac2515baafc9326c5")
    @GET("penjualan/detail/")
    fun getDetail(
        @Query("id") id: Int,
    ): Call<List<DetailPenjualanModel>>

    @Headers("x-key: bd0b3ae6651538fac2515baafc9326c5")
    @POST("save")
    fun saveProduk(
        @Field("id_produk") id_produk1: ArrayList<Int>,
        @Field("qty") qty1: ArrayList<String>,
        @Field("id_produk") id_produk2: ArrayList<Int>,
        @Field("qty") qty2: ArrayList<String>
    ): Call<SaveProdukModel>

}