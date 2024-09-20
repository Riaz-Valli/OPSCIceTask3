package com.example.icetask3

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("/api/data")
    fun getData(): Call<List<DataModel>>

    @POST("/api/data")
    fun postData(@Body dataModel: DataModel): Call<DataModel>
}
