package com.hakam.kasirapp.ui.penjualan

import com.hakam.kasirapp.model.ListPenjualanModel

interface ContractPenjualan {

    interface Presenter {
        fun getPenjualan()
    }

    interface View {
        fun initActivity()
        fun initListener()
        fun onLoadingPenjualan(loading: Boolean)
        fun onResultPenjualan(listPenjualanModel: List<ListPenjualanModel>)
        fun showMessage(message: String)
    }
}