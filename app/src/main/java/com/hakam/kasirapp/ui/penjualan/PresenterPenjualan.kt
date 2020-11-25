package com.hakam.kasirapp.ui.penjualan

import android.util.Log
import android.widget.Toast
import com.hakam.kasirapp.model.ListPenjualanModel
import com.hakam.kasirapp.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PresenterPenjualan(val view: ContractPenjualan.View) : ContractPenjualan.Presenter {

    init {
        view.initActivity()
        view.initListener()
    }

    override fun getPenjualan() {
        view.onLoadingPenjualan(true)
        ApiService.endpoint.getPenjualan().enqueue(object : Callback<List<ListPenjualanModel>> {
            override fun onResponse(
                call: Call<List<ListPenjualanModel>>,
                response: Response<List<ListPenjualanModel>>
            ) {
                view.onLoadingPenjualan(false)
                if (response.isSuccessful) {
                    val dataPenjualan = response.body()!!
                    view.onResultPenjualan(dataPenjualan)
                }
            }

            override fun onFailure(call: Call<List<ListPenjualanModel>>, t: Throwable) {
                view.onLoadingPenjualan(false)
            }

        })
    }
}