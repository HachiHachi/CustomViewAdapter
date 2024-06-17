package com.julian.custom.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.julian.custom.adapter.databinding.ItemReloadViewBinding

class ReloadViewHolder(private val binding: ItemReloadViewBinding): RecyclerView.ViewHolder(binding.root) {

    fun setIcon(res: Int) {
        binding.ivReload.setImageResource(res)
        binding.ivReload.visibility = View.VISIBLE
    }

    fun setTitle(title: String) {
        binding.tvErrorTitle.text = title
        binding.tvErrorTitle.visibility = View.VISIBLE
    }

    fun setMessage(message: String) {
        binding.tvErrorMsg.text = message
        binding.tvErrorMsg.visibility = View.VISIBLE
    }

    fun setBtnReloadClick(message: String, callback: () -> Unit) {
        binding.btnReload.text = message
        binding.btnReload.setOnClickListener {
            callback()
        }
    }

}