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
import org.w3c.dom.Text

class QuestionActivity : AppCompatActivity(), View.OnClickListener {
    private var tv_question : TextView? = null
    private var iv_image : ImageView? = null
    private var tv_firstOption : TextView? = null
    private var tv_secondOption : TextView? = null
    private var tv_thirdOption : TextView? = null
    private var tv_fourthOption : TextView? = null
    private var currentPostion = 1
    private var allQuestion :  ArrayList<Question>? = null
    private var button_submit : Button? = null
    private var selectedOptionPosition = 0
    private var user_name : String ? = null
    private var correct_answers : Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)


        tv_question = findViewById(R.id.tv_questionDescription)
        iv_image = findViewById(R.id.iv_questionImage)
        tv_firstOption = findViewById(R.id.tv_first_option)
        tv_secondOption = findViewById(R.id.tv_second_option)
        tv_thirdOption = findViewById(R.id.tv_third_option)
        tv_fourthOption = findViewById(R.id.tv_fourth_option)
        button_submit = findViewById(R.id.button_submit)
        allQuestion = Constants.getAllQuestions()

        setQuestion()

        tv_firstOption?.setOnClickListener(this)
        tv_secondOption?.setOnClickListener(this)
        tv_thirdOption?.setOnClickListener(this)
        tv_fourthOption?.setOnClickListener(this)
        button_submit?.setOnClickListener (this)

    }
    private fun setQuestion(){
        defaultOptionBorderView()
        val question:Question = allQuestion!![currentPostion - 1]
        tv_question?.text = question.questionDescription
        iv_image?.setImageResource(question.image)
        tv_firstOption?.text = question.firstOption
        tv_secondOption?.text = question.secondOption
        tv_thirdOption?.text = question.thirdOption
        tv_fourthOption?.text = question.fourthOption

        if(currentPostion == allQuestion!!.size){
            button_submit?.text = "DONE"
        }
        else{
            button_submit?.text = "SUBMIT"
        }

    }
    private fun defaultOptionBorderView(){
        val options = ArrayList<TextView>()
        tv_firstOption?.let{
            options.add(0, it)
        }
        tv_secondOption?.let{
            options.add(1, it)
        }
        tv_thirdOption?.let{
            options.add(2, it)
        }
        tv_fourthOption?.let{
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
                tv_firstOption?.background = ContextCompat.getDrawable(
                    this@QuestionActivity,
                    View
                )
            }
            2 -> {
                tv_secondOption?.background = ContextCompat.getDrawable(
                    this@QuestionActivity,
                    View
                )
            }
            3 -> {
                tv_thirdOption?.background = ContextCompat.getDrawable(
                    this@QuestionActivity,
                    View
                )
            }
            4 -> {
                tv_fourthOption?.background = ContextCompat.getDrawable(
                    this@QuestionActivity,
                    View
                )
            }
        }
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.tv_first_option -> {
                tv_firstOption?.let {
                    selectedOptionBorderView(it, 1)
                }
            }
            R.id.tv_second_option -> {
                tv_secondOption?.let {
                    selectedOptionBorderView(it, 2)
                }
            }
            R.id.tv_third_option -> {
                tv_thirdOption?.let {
                    selectedOptionBorderView(it, 3)
                }
            }
            R.id.tv_fourth_option -> {
                tv_fourthOption?.let {
                    selectedOptionBorderView(it, 4)
                }
            }
            R.id.button_submit -> {
                if(selectedOptionPosition ==0) {
                    currentPostion++
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
                    }
                    else{
                        answerOptionBorderView(selectedOptionPosition, R.drawable.wrong_border)
                    }

                }
                selectedOptionPosition = 0
            }

        }




    }

}