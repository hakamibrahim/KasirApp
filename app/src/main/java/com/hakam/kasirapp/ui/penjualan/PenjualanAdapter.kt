package com.hakam.kasirapp.ui.penjualan

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.hakam.kasirapp.R
import com.hakam.kasirapp.model.Constant
import com.hakam.kasirapp.model.DetailPenjualanModel
import com.hakam.kasirapp.model.ListPenjualanModel
import kotlin.coroutines.coroutineContext

class PenjualanAdapter(
    var dataPenjualan: ArrayList<ListPenjualanModel>,
    var listener: OnAdapterListener
) :
    RecyclerView.Adapter<PenjualanAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_penjualan, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = dataPenjualan[position]

        holder.tanggal.text = model.created_at
        holder.harga.text = model.harga.toString()

        holder.tanggal.setOnClickListener {
            Constant.RIWAYAT_ID = model.id
            listener.onClick(model)
        }
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

    interface OnAdapterListener {
        fun onClick(detailPenjualan: ListPenjualanModel)
    }
}