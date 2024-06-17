package com.julian.custom.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.julian.custom.adapter.databinding.ItemEmptyViewBinding

class EmptyViewHolder(private val binding: ItemEmptyViewBinding) : RecyclerView.ViewHolder(binding.root) {

    fun setIcon(res: Int) {
        binding.ivNoData.setImageResource(res)
        binding.ivNoData.visibility = View.VISIBLE
    }

    fun setTitle(title: String) {
        binding.tvNoDataTitle.text = title
        binding.tvNoDataTitle.visibility = View.VISIBLE
    }

    fun setMessage(message: String) {
        binding.tvNoDataMsg.text = message
        binding.tvNoDataMsg.visibility = View.VISIBLE
    }

}