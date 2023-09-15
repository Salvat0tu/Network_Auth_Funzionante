package com.example.network_auth

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object QuizRepo {

    var endPoint: EndPoint? = null

    suspend fun getQuiz(): retrofit2.Response<QuizData>? {
        if (endPoint == null) {
            endPoint = createRetrofitInstance().create(EndPoint::class.java)
        }
        return endPoint?.getQuiz()
    }

    private fun createRetrofitInstance(): Retrofit {
        val baseUrl = "https://quiz26.p.rapidapi.com"
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        val authInterceptor = AutInterceptor()

        val httpClient = OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .addInterceptor(loggingInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    }
}
