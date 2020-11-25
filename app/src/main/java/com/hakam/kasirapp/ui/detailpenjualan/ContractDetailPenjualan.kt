package com.hakam.kasirapp.ui.detailpenjualan

import com.hakam.kasirapp.model.DetailPenjualanModel

interface ContractDetailPenjualan {

    interface Presenter {
        fun getDetailPenjualan()
    }

    interface View {
        fun initActivity()
        fun initListener()
        fun onLoadingDetailPenjualan(loading: Boolean)
        fun onResultDetailPenjualan(detailPenjualanModel: List<DetailPenjualanModel>)
        fun showMessage(message: String)
    }
}