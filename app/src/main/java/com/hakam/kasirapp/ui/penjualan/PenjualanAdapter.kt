package com.hakam.kasirapp.ui.penjualan

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hakam.kasirapp.R
import com.hakam.kasirapp.model.ListPenjualanModel
import com.hakam.kasirapp.model.ListProdukModel

class PenjualanAdapter(val context: Context, var dataPenjualan: ArrayList<ListPenjualanModel>) :
    RecyclerView.Adapter<PenjualanAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_penjualan, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = dataPenjualan[position]

        holder.tanggal.text = model.created_at
        holder.harga.text = model.harga.toString()
    }

    override fun getItemCount() = dataPenjualan.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tanggal: TextView = itemView.findViewById(R.id.itemPenjualanTanggal)
        val harga: TextView = itemView.findViewById(R.id.itemPenjualanHarga)
    }

    fun setData(newData: List<ListPenjualanModel>) {
        dataPenjualan.clear()
        dataPenjualan.addAll(newData)
        notifyDataSetChanged()
    }
}