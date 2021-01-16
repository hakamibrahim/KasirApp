package com.hakam.kasirapp.ui.konfirmasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.hakam.kasirapp.R

class KonfirmasiActivity : AppCompatActivity(), ContractKonfirmasi.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_konfirmasi)
        supportActionBar!!.title = "KONFIRMASI"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun initActivity() {
    }

    override fun initListener() {

    }

    override fun onLoadingDetailKonfirmasi(loading: Boolean) {

    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}