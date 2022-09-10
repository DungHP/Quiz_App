package com.example.quiz_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.cardview.widget.CardView

class OptionActivity : AppCompatActivity() {
    private var user_name : String ? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_option)

        val cv_actor : CardView = findViewById(R.id.cv_actor)
        val cv_geography : CardView = findViewById(R.id.cv_geography)
        val cv_history : CardView= findViewById(R.id.cv_history)
        val cv_sport : CardView = findViewById(R.id.cv_sport)


        cv_actor.setOnClickListener{
            val intent = Intent(this, QuestionActivity::class.java)
            intent.putExtra(Constants.USER_NAME, user_name)
            intent.putExtra(Constants.CATEGORY, "1")
            startActivity(intent)
            finish()
        }
        cv_geography.setOnClickListener{
            val intent = Intent(this, QuestionActivity::class.java)
            intent.putExtra(Constants.USER_NAME, user_name)
            intent.putExtra(Constants.CATEGORY, "2")
            startActivity(intent)
            finish()
        }
        cv_history.setOnClickListener{
            val intent = Intent(this, QuestionActivity::class.java)
            intent.putExtra(Constants.USER_NAME, user_name)
            intent.putExtra(Constants.CATEGORY, "3")
            startActivity(intent)
            finish()
        }

        cv_sport.setOnClickListener{
            val intent = Intent(this, QuestionActivity::class.java)
            intent.putExtra(Constants.USER_NAME, user_name)
            intent.putExtra(Constants.CATEGORY, "4")
            startActivity(intent)
            finish()
        }





    }
}