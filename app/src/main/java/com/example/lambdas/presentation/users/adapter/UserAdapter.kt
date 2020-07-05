package com.example.lambdas.presentation.users.adapter

import android.view.ViewGroup
import com.example.lambdas.R
import com.example.lambdas.extensions.setOnPositionClickListener
import com.example.lambdas.ui.adapter.SimpleAdapter
import com.example.lambdas.ui.adapter.SimpleHolder

class UserAdapter(
    private val onUserClickListener: (Int) -> Unit
) : SimpleAdapter<UserItem>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleHolder<UserItem> =
        UserHolder(createView(parent, R.layout.user_item))

    override fun onViewAttachedToWindow(holder: SimpleHolder<UserItem>) {
        super.onViewAttachedToWindow(holder)
        holder.setOnPositionClickListener { position ->
            onUserClickListener(position)
        }
    }

    override fun onViewDetachedFromWindow(holder: SimpleHolder<UserItem>) {
        super.onViewDetachedFromWindow(holder)
        holder.setOnPositionClickListener(null)
    }
}