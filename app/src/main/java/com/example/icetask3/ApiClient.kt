package com.example.icetask3

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiClient {
    private const val BASE_URL = "https://<your-api-url>/"
    private var retrofit: Retrofit? = null

    val retrofitInstance: Retrofit?
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }

    val apiService: ApiService
        get() = retrofitInstance!!.create(ApiService::class.java)
}
