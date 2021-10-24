package com.project.latitudetechnolabs.data.repositories

import android.util.Log
import com.project.latitudetechnolabs.data.network.MyApi
import com.project.latitudetechnolabs.data.network.SafeApiRequest
import com.project.latitudetechnolabs.data.network.responses.AuthResponse


class UserRepository (private val api: MyApi
/*private val db: AppDatabase*/
) : SafeApiRequest() {

    suspend fun userLogin(email: String,
                          password: String,
                          device_type: String,
                          device_id: String,
                          country: String) : AuthResponse {
        return apiRequest {
            Log.e("UserRepository", "::>>")
            api.userLogin(email, password, device_type, device_id, country)
        }
    }


}