package com.project.latitudetechnolabs.data.network.responses

import androidx.lifecycle.ViewModel
import com.google.gson.annotations.SerializedName
import com.project.latitudetechnolabs.data.db.entities.*
import java.util.ArrayList


class AuthResponse : ViewModel() {

    @SerializedName("message")
    var message: String? = null

    @SerializedName("data")
    var data: Data? = null

    class Data {

        @SerializedName("token")
        var token: String? = null

        @SerializedName("profile_id")
        var profile_id: String? = null


        @SerializedName("prime_user")
        var prime_user: String? = null

    }

}