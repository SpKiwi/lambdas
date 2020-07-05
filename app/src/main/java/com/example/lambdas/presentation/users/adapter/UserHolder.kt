package com.example.lambdas.presentation.users.adapter

import android.view.View
import com.example.lambdas.ui.adapter.SimpleHolder
import kotlinx.android.synthetic.main.user_item.view.*

class UserHolder(itemView: View) : SimpleHolder<UserItem>(itemView) {

    private val userName = itemView.userItemName

    override fun bind(model: UserItem) {
        userName.text = model.name
    }
}