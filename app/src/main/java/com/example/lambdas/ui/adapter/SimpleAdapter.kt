package com.example.lambdas.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

abstract class SimpleAdapter<T : SimpleRecyclerModel> : RecyclerView.Adapter<SimpleHolder<T>>() {

    private var elements: List<T> = emptyList()

    protected fun createView(parent: ViewGroup, @LayoutRes layout: Int): View =
        LayoutInflater.from(parent.context).inflate(layout, parent, false)

    override fun getItemCount(): Int = elements.size

    override fun onBindViewHolder(viewHolder: SimpleHolder<T>, position: Int) =
        viewHolder.bind(elements[position])

    fun setItems(items: List<T>) {
        val diffResult: DiffUtil.DiffResult = DiffUtil.calculateDiff(DiffCallback(elements, items))

        elements = items
        diffResult.dispatchUpdatesTo(this)
    }

    class DiffCallback<T : SimpleRecyclerModel>(
        private val oldList: List<T>,
        private val newList: List<T>
    ) : DiffUtil.Callback() {

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldList[oldItemPosition].id == newList[newItemPosition].id

        override fun getOldListSize(): Int = oldList.size

        override fun getNewListSize(): Int = newList.size

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldList[oldItemPosition] == newList[newItemPosition]

    }

}
