package com.example.lambdas.presentation.filter

import com.example.lambdas.presentation.users.adapter.UserItem

interface FilterView {

    fun showMinAge(text: String)

    fun showMaxAge(text: String)

    fun startUserActivityWithLambda(predicate: ((UserItem) -> Boolean)?)

    fun startUserActivityWithReference(predicate: ((UserItem) -> Boolean)?)

}