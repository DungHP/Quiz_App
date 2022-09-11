package com.example.quiz_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.quiz_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.buttonSwitchScreen?.setOnClickListener{
            if(binding?.editTextName?.text!!.isEmpty()){
                Toast.makeText(this, "Please Enter Your name before submit", Toast.LENGTH_LONG).show()
            }
            else{
                val intent = Intent(this, OptionActivity::class.java)
                intent.putExtra(Constants.USER_NAME, binding?.editTextName?.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}