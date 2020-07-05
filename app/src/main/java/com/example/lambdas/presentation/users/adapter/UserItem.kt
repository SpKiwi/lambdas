package com.example.lambdas.presentation.users.adapter

import com.example.lambdas.ui.adapter.SimpleRecyclerModel

data class UserItem(
    override val id: Long,
    val name: String,
    val age: Int
) : SimpleRecyclerModel