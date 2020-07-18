package com.example.lambdas.presentation.users

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lambdas.R
import com.example.lambdas.presentation.users.adapter.UserAdapter
import com.example.lambdas.presentation.users.adapter.UserItem
import kotlinx.android.synthetic.main.user_activity.*
import java.io.Serializable

abstract class BaseUserActivity : AppCompatActivity(), UserView {

    abstract val userAdapter: UserAdapter

    /**
     * We need to create the presenter lazily as it should use the intent which'll be available after the activity .onCreate
     **/
    @Suppress("UNCHECKED_CAST")
    protected val presenter: UserPresenter by lazy {
        UserPresenter.newInstance(
            userView = this,
            predicate = intent.getSerializableExtra(KEY_USER_PREDICATE) as ((UserItem) -> Boolean)?
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_activity)

        initViews()
        presenter.loadUsers()
    }

    private fun initViews() {
        userList.apply {
            adapter = userAdapter
            layoutManager = LinearLayoutManager(this@BaseUserActivity)
        }
    }

    override fun showUsers(users: List<UserItem>) {
        userAdapter.setItems(users)
    }

    override fun showMessage(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    companion object {
        private const val KEY_USER_PREDICATE = "KEY_USER_PREDICATE"

        fun newInstanceLambda(context: Context, predicate: ((UserItem) -> Boolean)? = null): Intent =
            Intent(context, UserLambdaActivity::class.java).apply {
                putExtra(KEY_USER_PREDICATE, predicate as Serializable?)
            }

        fun newInstanceReference(context: Context, predicate: ((UserItem) -> Boolean)? = null): Intent =
            Intent(context, UserReferenceActivity::class.java).apply {
                putExtra(KEY_USER_PREDICATE, predicate as Serializable?)
            }
    }
}