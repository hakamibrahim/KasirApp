package com.hakam.kasirapp.ui.detailpenjualan

import com.hakam.kasirapp.model.Constant
import com.hakam.kasirapp.model.DetailPenjualanModel
import com.hakam.kasirapp.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PresenterDetailPenjualan(val view: ContractDetailPenjualan.View) :
    ContractDetailPenjualan.Presenter {

    init {
        view.initActivity()
        view.initListener()
    }

    override fun getDetailPenjualan() {
        view.onLoadingDetailPenjualan(true)
        ApiService.endpoint.getDetail(Constant.RIWAYAT_ID)
            .enqueue(object : Callback<List<DetailPenjualanModel>> {
                override fun onResponse(
                    call: Call<List<DetailPenjualanModel>>,
                    response: Response<List<DetailPenjualanModel>>
                ) {
                    view.onLoadingDetailPenjualan(false)
                    if (response.isSuccessful) {
                        val detailPenjualan = response.body()!!
                        view.onResultDetailPenjualan(detailPenjualan)
                    }
                }

                override fun onFailure(call: Call<List<DetailPenjualanModel>>, t: Throwable) {
                    view.onLoadingDetailPenjualan(false)
                }
            })
    }
}