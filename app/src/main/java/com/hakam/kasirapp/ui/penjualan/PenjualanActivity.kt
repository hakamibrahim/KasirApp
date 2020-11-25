package com.hakam.kasirapp.ui.penjualan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.hakam.kasirapp.R
import com.hakam.kasirapp.model.ListPenjualanModel
import kotlinx.android.synthetic.main.activity_penjualan.*

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
        penjualanAdapter = PenjualanAdapter(this, arrayListOf())

        recyclerPenjualan.apply {
            layoutManager = LinearLayoutManager(this@PenjualanActivity)
            adapter = penjualanAdapter
        }
    }

    override fun onLoadingPenjualan(loading: Boolean) {
        when (loading) {
            true -> {
                progressCircularPenjualan.visibility = View.VISIBLE
            }
            false -> {
                progressCircularPenjualan.visibility = View.GONE
            }
        }
    }

    override fun onResultPenjualan(listPenjualanModel: List<ListPenjualanModel>) {
        penjualanAdapter.setData(listPenjualanModel)
        Log.d("TAG", "onResultPenjualan: $listPenjualanModel")
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}