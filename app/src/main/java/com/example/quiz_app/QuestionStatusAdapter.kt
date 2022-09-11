package com.example.quiz_app

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quiz_app.databinding.ActivityQuestionBinding
import com.example.quiz_app.databinding.QuestionStatusBinding

class QuestionStatusAdapter (val items: ArrayList<Question>):RecyclerView.Adapter<QuestionStatusAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            QuestionStatusBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }
    // Binds each item in the ArrayList to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }
    override fun getItemCount(): Int {
        return items.size
    }
    class ViewHolder(binding: QuestionStatusBinding) : RecyclerView.ViewHolder(binding.root) {
        val tvItem = binding.tvItem
    }
}