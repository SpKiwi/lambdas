package com.example.lambdas.extensions

import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.ViewHolder.setOnPositionClickListener(onPositionClickListener: ((Int) -> Unit)?) {
    if (onPositionClickListener == null) {
        itemView.setOnClickListener(null)
    } else {
        itemView.setOnClickListener {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                onPositionClickListener(position)
            }
        }
    }
}