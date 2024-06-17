package com.julian.custom.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.julian.custom.adapter.databinding.ItemEmptyViewBinding
import com.julian.custom.adapter.databinding.ItemReloadViewBinding

abstract class CustomViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var state: State = State.Empty

    companion object {
        const val ITEM_TYPE_EMPTY = -1
        const val ITEM_TYPE_ERROR = -2
        const val ITEM_TYPE_LOADING = -3
        const val ITEM_TYPE_RELOAD = -4
        const val ITEM_TYPE_DATA = 100
    }

    abstract fun getDataCount(): Int

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            ITEM_TYPE_EMPTY -> EmptyViewHolder(getEmptyView(inflater, parent))
            ITEM_TYPE_RELOAD -> ReloadViewHolder(getReloadView(inflater, parent))
            else -> throw IllegalStateException("Invalid viewType")

        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }


    override fun getItemCount(): Int {
        return if (getDataCount() == 0) 1 else getDataCount()
    }

    override fun getItemViewType(position: Int): Int {
        return if (getDataCount() == 0) {
            when (state) {
                is State.Empty -> ITEM_TYPE_EMPTY
                is State.Error -> ITEM_TYPE_ERROR
                is State.Loading -> ITEM_TYPE_LOADING
                is State.Reload -> ITEM_TYPE_RELOAD
            }
        } else {
            ITEM_TYPE_DATA
        }
    }

    fun getEmptyView(inflater: LayoutInflater, parent: ViewGroup): ItemEmptyViewBinding {
        return ItemEmptyViewBinding.inflate(inflater, parent, false)
    }

    fun getReloadView(inflater: LayoutInflater, parent: ViewGroup): ItemReloadViewBinding {
        return ItemReloadViewBinding.inflate(inflater, parent, false)
    }


    sealed class State {
        data object Error : State()
        data object Loading : State()
        data object Empty : State()
        data object Reload : State()
    }
}