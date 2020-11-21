package com.hakam.kasirapp.ui.penjualan

import android.util.Log
import com.hakam.kasirapp.model.ListPenjualanModel
import com.hakam.kasirapp.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PresenterPenjualan (val view: ContractPenjualan.View) : ContractPenjualan.Presenter{

    init {
        view.initActivity()
        view.initListener()
    }

    override fun getPenjualan() {
        view.onLoadingPenjualan(true)
        ApiService.endpoint.getPenjualan().enqueue(object : Callback<ListPenjualanModel> {
            override fun onResponse(
                call: Call<ListPenjualanModel>,
                response: Response<ListPenjualanModel>
            ) {
                if (response.isSuccessful) {
                    val listPenjualanModel: ListPenjualanModel = response.body()!!
                    listPenjualanModel.harga
                }
            }

            override fun onFailure(call: Call<ListPenjualanModel>, t: Throwable) {
                view.onLoadingPenjualan(false)
            }

        })
    }
}