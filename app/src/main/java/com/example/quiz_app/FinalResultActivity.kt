package com.example.quiz_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.quiz_app.databinding.ActivityFinalResultBinding

class FinalResultActivity : AppCompatActivity() {
    private var binding: ActivityFinalResultBinding ? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFinalResultBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val finishButton : Button = findViewById(R.id.button_finish)
        finishButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        binding?.tvName?.text = intent.getStringExtra(Constants.USER_NAME)
        val correct_answers = intent.getIntExtra(Constants.ALL_CORRECT_ANSWERS, 0)
        val total_questions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        binding?.tvTotalScore?.text = "Your Final Score is $correct_answers / $total_questions"

    }
}