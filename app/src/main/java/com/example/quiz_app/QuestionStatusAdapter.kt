package com.example.quiz_app

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.quiz_app.databinding.QuestionStatusBinding

class QuestionStatusAdapter(val items: ArrayList<Question>):RecyclerView.Adapter<QuestionStatusAdapter.ViewHolder>(){
    private var category : String ? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            QuestionStatusBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }
    // Binds each item in the ArrayList to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model: Question = items[position]
        category
        holder.tvItem.text = model.questionId.toString()

        when {
            model.isSelected -> {
                holder.tvItem.background =
                    ContextCompat.getDrawable(
                        holder.itemView.context,
                        R.drawable.circular_purple_background
                    )
                holder.tvItem.setTextColor(Color.parseColor("#FFFFFF")) // Parse the color string, and return the corresponding color-int.
            }
            else -> {
                holder.tvItem.background =
                    ContextCompat.getDrawable(holder.itemView.context, R.drawable.circular_gray_background)
                holder.tvItem.setTextColor(Color.parseColor("#212121"))
            }
        }

    }
    override fun getItemCount(): Int {
        return items.size
    }
    class ViewHolder(binding: QuestionStatusBinding) : RecyclerView.ViewHolder(binding.root) {
        val tvItem = binding.tvItem
    }
}