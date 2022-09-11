package com.example.quiz_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.cardview.widget.CardView
import com.example.quiz_app.databinding.ActivityOptionBinding

class OptionActivity : AppCompatActivity() {
    private var user_name : String ? = null
    private var binding: ActivityOptionBinding ? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOptionBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.cvActor?.setOnClickListener{
            val intent = Intent(this, QuestionActivity::class.java)
            intent.putExtra(Constants.USER_NAME, user_name)
            intent.putExtra(Constants.CATEGORY, "1")
            startActivity(intent)
            finish()
        }
        binding?.cvGeography?.setOnClickListener{
            val intent = Intent(this, QuestionActivity::class.java)
            intent.putExtra(Constants.USER_NAME, user_name)
            intent.putExtra(Constants.CATEGORY, "2")
            startActivity(intent)
            finish()
        }
        binding?.cvHistory?.setOnClickListener{
            val intent = Intent(this, QuestionActivity::class.java)
            intent.putExtra(Constants.USER_NAME, user_name)
            intent.putExtra(Constants.CATEGORY, "3")
            startActivity(intent)
            finish()
        }

        binding?.cvSport?.setOnClickListener{
            val intent = Intent(this, QuestionActivity::class.java)
            intent.putExtra(Constants.USER_NAME, user_name)
            intent.putExtra(Constants.CATEGORY, "4")
            startActivity(intent)
            finish()
        }





    }
}