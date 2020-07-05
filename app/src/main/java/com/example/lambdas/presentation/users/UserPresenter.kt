package com.example.lambdas.presentation.users

import com.example.lambdas.persistence.UserStorage
import com.example.lambdas.presentation.users.adapter.UserItem

class UserPresenter private constructor(
    private val view: UserView,
    private val predicate: ((UserItem) -> Boolean)?,
    private val userStorage: UserStorage
) {

    private var filteredUsers: List<UserItem> = emptyList()

    fun loadUsers() {
        filteredUsers = userStorage.getUsers(predicate)
        view.showUsers(filteredUsers)
    }

    fun greetUser(position: Int) {
        val user = filteredUsers[position]
        view.showMessage("Hello, ${user.name}")
    }

    companion object {
        fun newInstance(userView: UserView, predicate: ((UserItem) -> Boolean)?): UserPresenter =
            UserPresenter(
                view = userView,
                predicate = predicate,
                userStorage = UserStorage.newInstance()
            )
    }

}