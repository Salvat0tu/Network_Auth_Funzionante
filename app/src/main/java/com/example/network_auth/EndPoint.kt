package com.example.network_auth

import okhttp3.Response
import retrofit2.http.GET

interface EndPoint {
    @GET("/questions")
    suspend fun getQuiz(): retrofit2.Response<QuizData>
}