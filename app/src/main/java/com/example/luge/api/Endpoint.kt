package com.example.luge.api

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface Endpoint {

    @POST("user/login")
    fun login(@Body body: Map<String, Any>): Call<ResponseBody>
}