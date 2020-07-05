package com.example.lambdas.presentation.filter

import com.example.lambdas.presentation.users.adapter.UserItem

class FilterPresenter private constructor(
    private val view: FilterView
) {

    private var minValue: Int = 0
    private var maxValue: Int? = null

    fun changeMinValue(value: Int) {
        minValue = value
        view.showMinAge("Min age: $value")
    }

    fun changeMaxValue(value: Int) {
        maxValue = value
        view.showMaxAge("Max age: $value")
    }

    fun createPredicateWithLambda() {
        view.startUserActivityWithLambda(createPredicate())
    }

    fun createPredicateWithReference() {
        view.startUserActivityWithReference(createPredicate())
    }

    private fun createPredicate(): (UserItem) -> Boolean {
        val min = minValue
        val max = maxValue
        return { userItem ->
            userItem.age > min && max?.let {
                userItem.age < it
            } ?: true
        }
    }

    companion object {
        fun newInstance(view: FilterView): FilterPresenter = FilterPresenter(view)
    }

}