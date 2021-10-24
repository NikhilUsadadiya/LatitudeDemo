package com.project.latitudetechnolabs.data.network.responses

import androidx.lifecycle.ViewModel
import com.google.gson.annotations.SerializedName
import com.project.latitudetechnolabs.data.db.entities.*
import java.util.ArrayList


class OfferListResponse : ViewModel() {

    @SerializedName("message")
    var message: String? = null

    @SerializedName("data")
    var data: Data? = null

    class Data {
        @SerializedName("id")
        var id: String? = null

        @SerializedName("title")
        var title: String? = null

        @SerializedName("offer_media")
        var offer_media: List<OfferMedia>? = null
    }

    class OfferMedia {
        @SerializedName("storage_name")
        var storage_name: String? = null
    }

}