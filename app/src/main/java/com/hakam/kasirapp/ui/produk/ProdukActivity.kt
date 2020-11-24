package com.hakam.kasirapp.ui.produk

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.hakam.kasirapp.R
import com.hakam.kasirapp.model.ListProdukModel
import com.hakam.kasirapp.ui.penjualan.PenjualanActivity
import kotlinx.android.synthetic.main.activity_produk.*
import kotlinx.android.synthetic.main.item_produk.*


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

    override fun onResultProduk(listProdukModel: List<ListProdukModel>) {
        produkAdapter.setData(listProdukModel)
    }

    override fun showMessage(message: String) {

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_history, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.action_transaksi_detail) {
            startActivity(Intent(applicationContext, PenjualanActivity::class.java))
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}