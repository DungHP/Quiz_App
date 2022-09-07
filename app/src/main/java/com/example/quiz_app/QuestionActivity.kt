package com.example.quiz_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class QuestionActivity : AppCompatActivity() {
    private var tv_question : TextView? = null
    private var iv_image : ImageView? = null
    private var tv_firstOption : TextView? = null
    private var tv_secondOption : TextView? = null
    private var tv_thirdOption : TextView? = null
    private var tv_fourthOption : TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        tv_question = findViewById(R.id.tv_questionDescription)
        iv_image = findViewById(R.id.iv_questionImage)
        tv_firstOption = findViewById(R.id.tv_first_option)
        tv_secondOption = findViewById(R.id.tv_second_option)
        tv_thirdOption = findViewById(R.id.tv_third_option)
        tv_fourthOption = findViewById(R.id.tv_fourth_option)
        var currentPostion = 1
        val allQuestion = Constants.getAllQuestions()


        val question:Question = allQuestion[currentPostion - 1]
        tv_question?.text = question.questionDescription
        iv_image?.setImageResource(question.image)
        tv_firstOption?.text = question.firstOption
        tv_secondOption?.text = question.secondOption
        tv_thirdOption?.text = question.thirdOption
        tv_fourthOption?.text = question.fourthOption


    }
}