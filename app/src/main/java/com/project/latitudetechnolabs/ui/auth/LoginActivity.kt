package com.project.latitudetechnolabs.ui.auth

import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.project.latitudetechnolabs.data.network.responses.AuthResponse
import com.project.latitudetechnolabs.ui.auth.AuthListener
import com.project.latitudetechnolabs.ui.auth.AuthViewModel
import com.project.latitudetechnolabs.ui.auth.AuthViewModelFactory
import com.project.latitudetechnolabs.ui.BaseNewActivity
import com.project.latitudetechnolabs.R
import com.project.latitudetechnolabs.data.AppDatabase
import com.project.latitudetechnolabs.data.db.entities.*
import com.project.latitudetechnolabs.databinding.ActivityLoginBinding
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance


class LoginActivity : BaseNewActivity(), AuthListener, KodeinAware {

    override val kodein by kodein()
    private val factory : AuthViewModelFactory by instance()
    private var db: AppDatabase? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        db = AppDatabase.invoke(this)
        val viewModel = ViewModelProvider(this, factory).get(AuthViewModel::class.java)
        binding.viewmodel = viewModel
        viewModel.authListener = this

    }

    override fun onStarted() {
        ShowProgressDialog(this, "Please Wait")
    }

    override suspend fun onSuccess(user: AuthResponse) {
        try {
            hideProgressDialog()
//            Log.e("TAG", "::>>>user: " + user.toString())
            movetoNextScreen(user)

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private suspend fun movetoNextScreen(user: AuthResponse) {
        /*Intent(this, OfferListActivity::class.java).also {
            it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(it)
        }*/
    }


    override fun onFailure(message: String) {
        hideProgressDialog()
    }
}
