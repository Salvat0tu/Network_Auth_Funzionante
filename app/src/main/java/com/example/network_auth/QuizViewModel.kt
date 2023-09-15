package com.example.network_auth

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class QuizViewModel : ViewModel() {

    val result = MutableLiveData<QuizData?>()

    fun getQuiz() {
        viewModelScope.launch(IO) {
            var response = QuizRepo.getQuiz()
            if (response?.isSuccessful == true) {

                result.postValue(response.body())
            } else {
                Log.e("NETWORK ERROR", "failed to connect")
            }
        }
    }
}