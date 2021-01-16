package com.hakam.kasirapp.ui.konfirmasi

interface ContractKonfirmasi {

    interface Presenter {
        fun getKonfirmasi()
    }

    interface View {
        fun initActivity()
        fun initListener()
        fun onLoadingDetailKonfirmasi(loading: Boolean)
        fun showMessage(message: String)
    }
}