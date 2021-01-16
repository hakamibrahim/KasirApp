package com.hakam.kasirapp.ui.produk

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hakam.kasirapp.R
import com.hakam.kasirapp.model.ListProdukModel

class ProdukAdapter(val context: Context, var dataProduk: ArrayList<ListProdukModel>) :
    RecyclerView.Adapter<ProdukAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_produk, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = dataProduk[position]

        holder.namaProduk.text = model.nama
        holder.harga.text = model.harga.toString()
    }

    override fun getItemCount() = dataProduk.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val namaProduk: TextView = itemView.findViewById(R.id.itemNamaProduk)
        val harga: TextView = itemView.findViewById(R.id.itemHargaProduk)
    }

    fun setData(newData: List<ListProdukModel>) {
        dataProduk.clear()
        dataProduk.addAll(newData)
        notifyDataSetChanged()
    }
}