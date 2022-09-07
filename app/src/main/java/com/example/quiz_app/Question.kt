package com.example.quiz_app

data class Question(
    val questionId : Int,
    val questionDescription: String,
    val image: Int,
    val firstOption: String,
    val secondOption: String,
    val thirdOption : String,
    val fourthOption: String,
    val correctAnswer: Int
)
