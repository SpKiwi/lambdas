package com.example.lambdas.presentation.filter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lambdas.R
import com.example.lambdas.extensions.setOnChangedListener
import com.example.lambdas.presentation.users.BaseUserActivity
import com.example.lambdas.presentation.users.adapter.UserItem
import kotlinx.android.synthetic.main.filter_activity.*

class FilterActivity : AppCompatActivity(), FilterView {

    private val presenter: FilterPresenter by lazy {
        FilterPresenter.newInstance(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.filter_activity)

        initViews()
    }

    private fun initViews() {
        presenter.changeMaxValue(maxAgeSeekbar.progress)
        presenter.changeMinValue(minAgeSeekbar.progress)
        minAgeSeekbar.setOnChangedListener {
            presenter.changeMinValue(it)
        }
        maxAgeSeekbar.setOnChangedListener {
            presenter.changeMaxValue(it)
        }
        applyFilterWithLambda.setOnClickListener {
            presenter.createPredicateWithLambda()
        }
        applyFilterWithReference.setOnClickListener {
            presenter.createPredicateWithReference()
        }
    }

    override fun showMinAge(text: String) {
        minAgeText.text = text
    }

    override fun showMaxAge(text: String) {
        maxAgeText.text = text
    }

    override fun startUserActivityWithLambda(predicate: ((UserItem) -> Boolean)?) {
        startActivity(BaseUserActivity.newInstanceLambda(this, predicate))
    }

    override fun startUserActivityWithReference(predicate: ((UserItem) -> Boolean)?) {
        startActivity(BaseUserActivity.newInstanceReference(this, predicate))
    }
}