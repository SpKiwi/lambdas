package com.example.lambdas.persistence

import com.example.lambdas.presentation.users.adapter.UserItem

class MockUserStorage : UserStorage {

    override fun getUsers(predicate: ((UserItem) -> Boolean)?): List<UserItem> = listOf(
        UserItem(id = 1, name = "Steve", age = 32),
        UserItem(id = 2, name = "Veronica", age = 44),
        UserItem(id = 3, name = "Andy", age = 15),
        UserItem(id = 4, name = "Bill", age = 23),
        UserItem(id = 5, name = "Alice", age = 19),
        UserItem(id = 6, name = "Caitlyn", age = 56),
        UserItem(id = 7, name = "Nicole", age = 53),
        UserItem(id = 8, name = "Dustin", age = 9)
    ).run {
        if (predicate != null)
            filter(predicate)
        else
            this
    }

}