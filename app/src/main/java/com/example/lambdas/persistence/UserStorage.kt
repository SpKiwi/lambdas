package com.example.lambdas.persistence

import com.example.lambdas.presentation.users.adapter.UserItem

interface UserStorage {

    fun getUsers(predicate: ((UserItem) -> Boolean)? = null): List<UserItem>

    companion object {
        fun newInstance(): UserStorage = MockUserStorage()
    }

}