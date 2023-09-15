package com.example.network_auth
import com.google.gson.annotations.SerializedName


data class QuizData(
    @SerializedName("A")
    val a: String?,
    @SerializedName("answer")
    val answer: String?,
    @SerializedName("B")
    val b: String?,
    @SerializedName("C")
    val c: String?,
    @SerializedName("D")
    val d: String?,
    @SerializedName("question")
    val question: String?
)