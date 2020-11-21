package com.hakam.kasirapp.ui.produk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.hakam.kasirapp.R
import com.hakam.kasirapp.model.ListProdukModel
import kotlinx.android.synthetic.main.activity_produk.*

class ProdukActivity : AppCompatActivity(), ContractProduk.View {

    private lateinit var produkAdapter: ProdukAdapter
    lateinit var presenterProduk: PresenterProduk

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produk)
        presenterProduk = PresenterProduk(this)
    }

    override fun onStart() {
        super.onStart()
        presenterProduk.getProduk()
    }

    override fun initActivity() {

    }

    override fun initListener() {
        produkAdapter = ProdukAdapter(this, arrayListOf())

        recyclerProduk.apply {
            layoutManager = LinearLayoutManager(this@ProdukActivity)
            adapter = produkAdapter
        }
    }

    override fun onLoadingProduk(loading: Boolean) {

    }

    override fun onResultProduk(listProdukModel: ListProdukModel) {
        for (i in listProdukModel.nama){
            produkAdapter.setData(listOf(listProdukModel))
        }
    }

    override fun showMessage(message: String) {

    }
}