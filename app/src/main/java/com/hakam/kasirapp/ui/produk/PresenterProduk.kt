package com.hakam.kasirapp.ui.produk

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
        ApiService.endpoint.getProduk().enqueue(object : Callback<List<ListProdukModel>> {
            override fun onResponse(
                call: Call<List<ListProdukModel>>,
                response: Response<List<ListProdukModel>>
            ) {
                view.onLoadingProduk(false)
                if (response.isSuccessful){
                    val listProduk = response.body()!!
                    view.onResultProduk(listProduk)
                }
            }

            override fun onFailure(call: Call<List<ListProdukModel>>, t: Throwable) {
                view.onLoadingProduk(false)
            }
        })
    }
}