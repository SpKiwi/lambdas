package com.example.lambdas.presentation.users

import com.example.lambdas.presentation.users.adapter.UserItem

interface UserView {

    fun showUsers(users: List<UserItem>)

    fun showMessage(text: String)

}