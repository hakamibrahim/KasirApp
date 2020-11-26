package com.hakam.kasirapp.ui.detailpenjualan

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hakam.kasirapp.R
import com.hakam.kasirapp.model.DetailPenjualanModel
import com.hakam.kasirapp.ui.penjualan.PenjualanAdapter

class PenjualanDetailAdapter(
    var detailPenjualan: ArrayList<DetailPenjualanModel>,
    var listener: OnAdapterListener
) :
    RecyclerView.Adapter<PenjualanDetailAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.item_detail_transaksi, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = detailPenjualan[position]

        holder.detailNama.text = model.nama
        holder.detailHarga.text = model.harga.toString()
    }

    override fun getItemCount() = detailPenjualan.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val detailNama: TextView = itemView.findViewById(R.id.detailNamaProduk)
        val detailHarga: TextView = itemView.findViewById(R.id.detailHargaProduk)
    }

    fun setData(newData: List<DetailPenjualanModel>) {
        detailPenjualan.clear()
        detailPenjualan.addAll(newData)
        notifyDataSetChanged()
    }

    interface OnAdapterListener {
        fun onClick(detailPenjualan: List<DetailPenjualanModel>)
    }
}