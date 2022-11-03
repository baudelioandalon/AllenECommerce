package com.boreal.allen.domain.model

data class QuestionModel(
    val question: String,
    val imageUser: String,
    val likesList: List<String> = emptyList(),
    val answerList: List<String>
)