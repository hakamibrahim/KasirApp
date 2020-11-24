package com.hakam.kasirapp.ui.penjualan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.hakam.kasirapp.R
import com.hakam.kasirapp.model.ListPenjualanModel

class PenjualanActivity : AppCompatActivity(), ContractPenjualan.View {

    private lateinit var penjualanAdapter: PenjualanAdapter
    private lateinit var presenterPenjualan: PresenterPenjualan

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_penjualan)
        presenterPenjualan = PresenterPenjualan(this)
    }

    override fun onStart() {
        super.onStart()
        presenterPenjualan.getPenjualan()
    }

    override fun initActivity() {
    }

    override fun initListener() {
    }

    override fun onLoadingPenjualan(loading: Boolean) {
    }

    override fun onResultPenjualan(listPenjualanModel: List<ListPenjualanModel>) {
        val response = listPenjualanModel[3]
        Log.d("TAG", "onResultPenjualan: $response")
    }

    override fun showMessage(message: String) {
    }
}