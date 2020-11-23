package com.hakam.kasirapp.ui.produk

import android.util.Log
import com.hakam.kasirapp.model.ListProdukModel
import com.hakam.kasirapp.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PresenterProduk(val view: ContractProduk.View) : ContractProduk.Presenter {

    init {
        view.initActivity()
        view.initListener()
    }

    override fun getProduk() {
        view.onLoadingProduk(true)
        ApiService.endpoint.getProduk().enqueue(object : Callback<ListProdukModel> {
            override fun onResponse(
                call: Call<ListProdukModel>,
                response: Response<ListProdukModel>
            ) {
                if (response.isSuccessful) {
                    val listProduk: ListProdukModel? = response.body()!!
                    view.onResultProduk(listProduk!!)
                }
            }

            override fun onFailure(call: Call<ListProdukModel>, t: Throwable) {
                view.onLoadingProduk(false)
            }

        })
    }
}