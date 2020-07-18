package com.example.lambdas.presentation.users

import com.example.lambdas.presentation.users.adapter.UserAdapter

class UserReferenceActivity : BaseUserActivity() {
    override val userAdapter: UserAdapter = UserAdapter(presenter::greetUser)
}