package com.julian.custom.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class CustomViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    abstract fun getDataCount(): Int

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int, payloads: MutableList<Any>) {
        super.onBindViewHolder(holder, position, payloads)
    }
}