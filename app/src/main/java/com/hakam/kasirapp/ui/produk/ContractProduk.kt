package com.hakam.kasirapp.ui.produk

import com.hakam.kasirapp.model.ListProdukModel

interface ContractProduk {

    interface Presenter {
        fun getProduk()
    }

    interface View {
        fun initActivity()
        fun initListener()
        fun onLoadingProduk(loading: Boolean)
        fun onResultProduk(listProdukModel: ListProdukModel)
        fun showMessage(message: String)
    }
}