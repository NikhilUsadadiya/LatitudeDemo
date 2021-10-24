package com.project.latitudetechnolabs.ui.auth

import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel
import com.project.latitudetechnolabs.data.repositories.UserRepository
import com.project.latitudetechnolabs.utils.ApiException
import com.project.latitudetechnolabs.utils.Coroutines
import com.project.latitudetechnolabs.utils.NoIntenetConnection
import com.project.latitudetechnolabs.utils.Constants

class AuthViewModel(
    private val repository: UserRepository
) : ViewModel() {

    var name: String? = null
    var email: String? = "vidhi.m1@gmail.com"
    var password: String? = "123456"
    var device_type: String? = "android"
    var device_id: String? = "123456"
    var country: String? = "IN"
    var authListener: AuthListener? = null


    fun onLoginButtonClicked(view: View) {
        authListener?.onStarted()
        if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
            authListener?.onFailure("invalid or empty")

            return
        }

        Coroutines.main {
            try {
                Log.e("AuthViewModel", "::>>")
                val authResponse = repository.userLogin(
                    email!!,
                    password!!,
                    device_type!!,
                    device_id!!,
                    country!!
                )

                authResponse.let {
                    authListener?.onSuccess(authResponse)
                    return@main
                }

                authListener?.onFailure(Constants.NO_DATA_FOUND)
            } catch (e: ApiException) {
                authListener?.onFailure(e.message!!)
            } catch (e: NoIntenetConnection) {
                authListener?.onFailure(e.message!!)
            }
        }

    }


}