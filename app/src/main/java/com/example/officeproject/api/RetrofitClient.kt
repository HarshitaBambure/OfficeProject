package com.example.officeproject.api

import android.content.Context
import com.example.officeproject.UserRepository
import com.example.officeproject.api.apis.UserApi
import com.example.officeproject.helpers.Constant
import com.example.officeproject.helpers.getPreferances
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    var mHttpLoggingInterceptor = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)

    var authInterceptor=AuthInterceptor(Constant.token)

     var mOkHttpClient = OkHttpClient
        .Builder()
        .addInterceptor(mHttpLoggingInterceptor)
        .addInterceptor(authInterceptor)
        .build()

    var mRetrofit: Retrofit? = null


    val client: Retrofit?
        get() {
            if (mRetrofit == null) {
                mRetrofit = Retrofit.Builder()
                    .baseUrl(Constant.BASE_URL)
                    .client(mOkHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return mRetrofit
        }

    fun getUserRepo(): UserApi {
        return client?.create(UserApi::class.java)!!
    }

}

    class AuthInterceptor(var token: String) : Interceptor {

        override fun intercept(chain: Interceptor.Chain): Response {
            val requestBuilder = chain.request().newBuilder()

            // If token has been saved, add it to the request
            requestBuilder.addHeader("Authorization", token)

            return chain.proceed(requestBuilder.build())
        }
    }