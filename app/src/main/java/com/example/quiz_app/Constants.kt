package com.example.quiz_app

object Constants {
    const val USER_NAME: String = "user_name"
    const val ALL_CORRECT_ANSWERS: String = "all_correct_answer"
    const val TOTAL_QUESTIONS: String = "total_questions"
    fun getAllQuestions():ArrayList<Question>{
        val questionList = ArrayList<Question>()

        val question1 = Question(1, "What is the name of this actor?", R.drawable.tom_cruise,
        "Tom Holland", "Tom Cruise", "Chris Hemsworth", "Chris Evans", 2)
        questionList.add(question1)
        val question2 = Question(2, "What is the name of this actor?", R.drawable.daniel_craig,
            "Timothy Dalton", "Sean Connery", "Barry Nelson", "Daniel Craig", 4)
        questionList.add(question2)
        val question3 = Question(3, "How old is Jackie Chan currently (2022)?", R.drawable.jackie_chan,
            "61", "62", "68", "65",  3)
        questionList.add(question3)
        val question4 = Question(4, "How many oscar had Leonardo Dicaprio won?", R.drawable.leonardo_dicaprio,
            "1", "0", "2", "3",  1)
        questionList.add(question4)

        return questionList
    }
}