package com.project.latitudetechnolabs.ui.auth

import com.project.latitudetechnolabs.data.network.responses.AuthResponse

interface AuthListener {

    fun onStarted()
    suspend fun onSuccess(user: AuthResponse)
    fun onFailure(message: String)

}