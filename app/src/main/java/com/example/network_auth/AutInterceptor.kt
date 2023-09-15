package com.example.network_auth

import okhttp3.Interceptor
import okhttp3.Response

class AutInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val newRequest = originalRequest.newBuilder()
            .addHeader("X-RapidAPI-Key", "63e15c4651msh9b0287251901dd4p13f599jsn35d17ac0716d")
            .addHeader("X-RapidAPI-Host", "quiz26.p.rapidapi.com")
            .build()
        return chain.proceed(newRequest)
    }

}