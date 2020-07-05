package com.example.lambdas.ui.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class SimpleHolder<T : SimpleRecyclerModel>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    abstract fun bind(model: T)

}
