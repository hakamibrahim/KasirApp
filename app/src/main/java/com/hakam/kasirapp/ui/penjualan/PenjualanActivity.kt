package com.hakam.kasirapp.ui.penjualan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.hakam.kasirapp.R
import com.hakam.kasirapp.model.ListPenjualanModel
import com.hakam.kasirapp.ui.produk.ProdukAdapter
import kotlinx.android.synthetic.main.activity_produk.*

class PenjualanActivity : AppCompatActivity(), ContractPenjualan.View {

    private lateinit var produkAdapter: ProdukAdapter
    private lateinit var presenterPenjualan: PresenterPenjualan

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_penjualan)
        presenterPenjualan = PresenterPenjualan(this)
    }

    override fun onStart() {
        super.onStart()
    }

    override fun initActivity() {
    }

    override fun initListener() {
    }

    override fun onLoadingPenjualan(loading: Boolean) {
    }

    override fun onResultPenjualan(listPenjualanModel: ListPenjualanModel) {
    }

    override fun showMessage(message: String) {
    }
}