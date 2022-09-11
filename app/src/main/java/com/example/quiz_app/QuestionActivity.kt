package com.example.quiz_app

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.quiz_app.databinding.ActivityQuestionBinding
import org.w3c.dom.Text

class QuestionActivity : AppCompatActivity(), View.OnClickListener {
    private var binding: ActivityQuestionBinding ? = null
    private var currentPostion = 1
    private var allQuestion :  ArrayList<Question>? = null
    private var category : String ? = null
    private var selectedOptionPosition = 0
    private var user_name : String ? = null
    private var correct_answers : Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        if(category == "1"){
            allQuestion = Constants.getAllActorQuestions()
        }
        else if(category == "2"){
            allQuestion = Constants.getAllGeographyQuestions()
        }
        else if(category == "3"){
            allQuestion = Constants.getAllHistoryQuestions()
        }
        else{
            allQuestion = Constants.getAllSportQuestions()
        }
        //Set All Question
        setQuestion()
        //Set Click for all options
        binding?.tvFirstOption?.setOnClickListener(this)
        binding?.tvSecondOption?.setOnClickListener(this)
        binding?.tvThirdOption?.setOnClickListener(this)
        binding?.tvFourthOption?.setOnClickListener(this)
        binding?.buttonSubmit?.setOnClickListener(this)

    }
    private fun setQuestion(){
        defaultOptionBorderView()
        val question:Question = allQuestion!![currentPostion - 1]
        binding?.tvQuestionDescription?.text = question.questionDescription
        binding?.ivQuestionImage?.setImageResource(question.image)
        binding?.tvFirstOption?.text = question.firstOption
        binding?.tvSecondOption?.text = question.secondOption
        binding?.tvThirdOption?.text = question.thirdOption
        binding?.tvFourthOption?.text = question.fourthOption

        if(currentPostion == allQuestion!!.size){
            binding?.buttonSubmit?.text = "DONE"
        }
        else{
            binding?.buttonSubmit?.text = "SUBMIT"
        }

    }
    private fun defaultOptionBorderView(){
        val options = ArrayList<TextView>()
        binding?.tvFirstOption?.let{
            options.add(0, it)
        }
        binding?.tvSecondOption?.let{
            options.add(1, it)
        }
        binding?.tvThirdOption?.let{
            options.add(2, it)
        }
        binding?.tvFourthOption?.let{
            options.add(3, it)
        }

        for (option in options){
            option.setTextColor(Color.parseColor("#757575"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this, R.drawable.default_border
            )
        }
    }
    private fun selectedOptionBorderView(textView: TextView, selectedOptionNum: Int){
        defaultOptionBorderView()
        selectedOptionPosition = selectedOptionNum

        textView.setTextColor(Color.parseColor("#363A43"))
        textView.setTypeface(textView.typeface, Typeface.BOLD)
        textView.background = ContextCompat.getDrawable(this,
        R.drawable.selected_border)
    }
    private fun answerOptionBorderView(answer: Int, View: Int) {
        when (answer) {
            1 -> {
                binding?.tvFirstOption?.background = ContextCompat.getDrawable(
                    this@QuestionActivity,
                    View
                )
            }
            2 -> {
                binding?.tvSecondOption?.background = ContextCompat.getDrawable(
                    this@QuestionActivity,
                    View
                )
            }
            3 -> {
                binding?.tvThirdOption?.background = ContextCompat.getDrawable(
                    this@QuestionActivity,
                    View
                )
            }
            4 -> {
                binding?.tvFourthOption?.background = ContextCompat.getDrawable(
                    this@QuestionActivity,
                    View
                )
            }
        }
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.tv_first_option -> {
                binding?.tvFirstOption?.let {
                    selectedOptionBorderView(it, 1)
                }
            }
            R.id.tv_second_option -> {
                binding?.tvSecondOption?.let {
                    selectedOptionBorderView(it, 2)
                }
            }
            R.id.tv_third_option -> {
                binding?.tvThirdOption?.let {
                    selectedOptionBorderView(it, 3)
                }
            }
            R.id.tv_fourth_option -> {
                binding?.tvFourthOption?.let {
                    selectedOptionBorderView(it, 4)
                }
            }
            R.id.button_submit -> {
                if(selectedOptionPosition ==0) {
                    //When there are still question
                    when {
                        currentPostion <= allQuestion!!.size -> {
                            setQuestion()
                        }
                        //when no question left
                        else -> {
                            val intent = Intent(this, FinalResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME,  user_name)
                            intent.putExtra(Constants.ALL_CORRECT_ANSWERS, correct_answers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, allQuestion?.size)
                            startActivity(intent)
                        }
                    }
                }
                else
                {
                    val question = allQuestion?.get(currentPostion-1)
                    if(question!!.correctAnswer == selectedOptionPosition){
                        correct_answers++
                        answerOptionBorderView(selectedOptionPosition, R.drawable.correct_border)
                        currentPostion++
                    }
                    else{
                        answerOptionBorderView(selectedOptionPosition, R.drawable.wrong_border)
                        currentPostion++
                    }
                    selectedOptionPosition = 0
                }

            }

        }




    }

}