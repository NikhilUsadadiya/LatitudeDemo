package com.project.latitudetechnolabs.data.network

import com.project.latitudetechnolabs.data.network.responses.AuthResponse
import com.project.latitudetechnolabs.data.network.responses.OfferListResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Headers
import retrofit2.http.POST
import java.util.concurrent.TimeUnit


interface MyApi {

    @FormUrlEncoded
    @POST ("login")
//    @Headers("Version:1.0")
    suspend fun userLogin (
        @Field ("email") email: String,
        @Field ("password") password: String,
        @Field ("device_type") device_type: String,
        @Field ("device_id") device_id: String,
        @Field ("country") country: String
    ) : Response<AuthResponse>


    @FormUrlEncoded
    @POST ("offer/search?start=0&count=10")
//    @Headers("Version:1.0")
    suspend fun getOfferListData (
        @Field ("image") image: String,
        @Field ("title") title: String,
        @Field ("estimated_price") estimated_price: String
    ) : Response<OfferListResponse>


    companion object {
        operator fun invoke(
            networkConnectionInterceptor: NetworkConnectionInterceptor
        ) : MyApi {

            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build()
          /*  val okkHttpclient = OkHttpClient.Builder()
                .addInterceptor(networkConnectionInterceptor)
                .build()*/

            return Retrofit.Builder()
                .baseUrl("https://refreeapp.com/dev/api/")
//                .baseUrl("https://staging.grubbrr.com/api/")
//                .baseUrl("https://api.simplifiedcoding.in/course-apis/recyclerview/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
                .create(MyApi::class.java)
        }
    }


}