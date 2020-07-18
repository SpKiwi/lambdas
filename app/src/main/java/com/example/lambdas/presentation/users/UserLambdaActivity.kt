package com.example.lambdas.presentation.users

import com.example.lambdas.Consumer
import com.example.lambdas.presentation.users.adapter.UserAdapter

class UserLambdaActivity : BaseUserActivity() {
    override val userAdapter: UserAdapter = UserAdapter(Consumer { presenter.greetUser(it) })
}