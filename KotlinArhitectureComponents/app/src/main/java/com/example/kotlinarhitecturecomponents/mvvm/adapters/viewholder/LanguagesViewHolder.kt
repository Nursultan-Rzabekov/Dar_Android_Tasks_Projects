package com.example.kotlinarhitecturecomponents.mvvm.adapters.viewholder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinarhitecturecomponents.R
import com.example.kotlinarhitecturecomponents.domain.model.Language
import kotlinx.android.synthetic.main.row_layout.view.*

class LanguagesViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(language: Language?) {
        if (language != null) {
            itemView.language_id.text = language.id.toString()
            itemView.language_name.text = language.languageName
        }
    }

    companion object {
        fun create(parent: ViewGroup): LanguagesViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false)
            return LanguagesViewHolder(view)
        }
    }
}