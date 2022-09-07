package com.example.quiz_app

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

    }
    private fun setQuestion(){
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
    private fun defaultOptionBorder(){
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
    private fun selectedOptionBorder(textView: TextView, selectedOptionNum: Int){
        defaultOptionBorder()
        selectedOptionPosition = selectedOptionNum

        textView.setTextColor(Color.parseColor("#363A43"))
        textView.setTypeface(textView.typeface, Typeface.BOLD)
        textView.background = ContextCompat.getDrawable(this,
        R.drawable.selected_border)
    }
    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.tv_first_option -> {
                tv_firstOption?.let {
                    selectedOptionBorder(it, 1)
                }
            }
            R.id.tv_second_option -> {
                tv_secondOption?.let {
                    selectedOptionBorder(it, 2)
                }
            }
            R.id.tv_third_option -> {
                tv_thirdOption?.let {
                    selectedOptionBorder(it, 3)
                }
            }
            R.id.tv_fourth_option -> {
                tv_fourthOption?.let {
                    selectedOptionBorder(it, 4)
                }
            }
        }


    }

}