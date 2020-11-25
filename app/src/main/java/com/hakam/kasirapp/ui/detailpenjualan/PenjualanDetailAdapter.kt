package com.hakam.kasirapp.ui.detailpenjualan

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hakam.kasirapp.model.DetailPenjualanModel

class PenjualanDetailAdapter(
    var detailPenjualan: ArrayList<DetailPenjualanModel>,
    var listener: OnAdapterListener
) :
    RecyclerView.Adapter<PenjualanDetailAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount() = detailPenjualan.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

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