package com.example.quiz_app

object Constants {
    const val USER_NAME: String = "user_name"
    const val ALL_CORRECT_ANSWERS: String = "all_correct_answer"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CATEGORY : String = "category"
    fun getAllActorQuestions():ArrayList<Question>{
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
    fun getAllGeographyQuestions():ArrayList<Question>{
        val questionList = ArrayList<Question>()

        val question1 = Question(1, "In which continent is Czech republic", R.drawable.world_map_continent,
            "Europe", "Asia", "Oceania", "North America", 1)
        questionList.add(question1)
        val question2 = Question(2, "What is this tower", R.drawable.eiffel_tower,
            "Tokyo Tower", "Paris Tower", "Eiffel Tower", "Twin Tower", 3)
        questionList.add(question2)
        val question3 = Question(3, "Which country have the most population?", R.drawable.population,
            "China", "India", "United States", "Russia",  1)
        questionList.add(question3)
        val question4 = Question(4, "This is flag is belong to which country?", R.drawable.australian_flag,
            "New Zealand", "Australia", "Argentina", "Portugal",  2)
        questionList.add(question4)

        return questionList
    }
    fun getAllHistoryQuestions():ArrayList<Question>{
        val questionList = ArrayList<Question>()

        val question1 = Question(1, "Who was the first black president?", R.drawable.white_house,
            "Micheal Jordan", "Morgan Freeman", "Barack Obama", "Michelle Obama", 3)
        questionList.add(question1)
        val question2 = Question(2, "When did World War II ended?", R.drawable.world_war_ii,
            "1945", "1944", "1950", "1941", 1)
        questionList.add(question2)
        val question3 = Question(3, "Who was the first person in the world to land on the moon?", R.drawable.moon_landing,
            "Charles Duke", "Edwin 'Buzz' Aldrin", "Michael Collins", "Neil Armstrong",  4)
        questionList.add(question3)
        val question4 = Question(4, "Who was the first Emperor of Rome?", R.drawable.rome_emperors,
            "Augustus", "Tiberius", "Caligula", "Claudius",  1)
        questionList.add(question4)

        return questionList
    }
    fun getAllSportQuestions():ArrayList<Question>{
        val questionList = ArrayList<Question>()

        val question1 = Question(1, "Who score the most point in the NBA currently (2022)", R.drawable.score,
            "Micheal Jordan", "Karl Malone", "Kareem Abdul-Jabbar", "Lebron James", 3)
        questionList.add(question1)
        val question2 = Question(2, "Who had won the most Grand Slam? (2022)", R.drawable.grand_slam,
            "Pete Sampras", "Roger Federer", "Rafael Nadal", "Novak Djokovic", 3)
        questionList.add(question2)
        val question3 = Question(3, "How many player is in each team in Football/Soccer?", R.drawable.football,
            "11", "9", "12", "10",  1)
        questionList.add(question3)
        val question4 = Question(4, "Who hold the record for the fastest 100meter dash?", R.drawable.dash,
            "Asafa POWELL", "Yohan Blake", "Tyson Gay", "Usain Bolt",  4)
        questionList.add(question4)

        return questionList
    }
}