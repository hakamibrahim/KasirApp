package com.hakam.kasirapp.ui.detailpenjualan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.hakam.kasirapp.R
import com.hakam.kasirapp.model.DetailPenjualanModel
import kotlinx.android.synthetic.main.activity_detail_penjualan.*

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
        detailPenjualanAdapter = PenjualanDetailAdapter(
            arrayListOf(),
            object : PenjualanDetailAdapter.OnAdapterListener {
                override fun onClick(detailPenjualan: List<DetailPenjualanModel>) {

                }
            })

        recyclerDetailPenjualan.apply {
            layoutManager = LinearLayoutManager(this@DetailPenjualanActivity)
            adapter = detailPenjualanAdapter
        }
    }

    override fun onLoadingDetailPenjualan(loading: Boolean) {
        when (loading) {
            true -> {
                progressCircularDetail.visibility = View.VISIBLE
            }
            false -> {
                progressCircularDetail.visibility = View.GONE
            }
        }
    }

    override fun onResultDetailPenjualan(detailPenjualanModel: List<DetailPenjualanModel>) {
        detailPenjualanAdapter.setData(detailPenjualanModel)
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}