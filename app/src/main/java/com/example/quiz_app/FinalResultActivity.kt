package com.example.quiz_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class FinalResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final_result)

        val userName: TextView = findViewById(R.id.tv_name)
        val score : TextView = findViewById(R.id.tv_total_score)

        val finishButton : Button = findViewById(R.id.button_finish)
        finishButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        userName.text = intent.getStringExtra(Constants.USER_NAME)
        val correct_answers = intent.getIntExtra(Constants.ALL_CORRECT_ANSWERS, 0)
        val total_questions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        score.text = "Your Final Score is $correct_answers / $total_questions"

    }
}