package com.hakam.kasirapp.ui.detailpenjualan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.hakam.kasirapp.R
import com.hakam.kasirapp.model.DetailPenjualanModel

class DetailPenjualanActivity : AppCompatActivity(), ContractDetailPenjualan.View {

    private lateinit var detailPenjualanAdapter: PenjualanDetailAdapter
    private lateinit var presenterDetailPenjualan: PresenterDetailPenjualan

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_penjualan)
        presenterDetailPenjualan = PresenterDetailPenjualan(this)
    }

    override fun initActivity() {
        supportActionBar!!.title = "DETAIL TRANSAKSI"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onStart() {
        super.onStart()
        presenterDetailPenjualan.getDetailPenjualan()
    }

    override fun initListener() {

    }

    override fun onLoadingDetailPenjualan(loading: Boolean) {

    }

    override fun onResultDetailPenjualan(detailPenjualanModel: List<DetailPenjualanModel>) {
        Log.d("TAG", "onResultDetailPenjualan: $detailPenjualanModel")
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}