package com.example.quiz_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonSwitchScreen : Button = findViewById(R.id.button_switch_screen)
        val editTextName : EditText = findViewById(R.id.edit_text_name)

        buttonSwitchScreen.setOnClickListener{
            if(editTextName.text.isEmpty()){
                Toast.makeText(this, "Please Enter Your name before submit", Toast.LENGTH_LONG).show()
            }
            else{
                val intent = Intent(this, QuestionActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}