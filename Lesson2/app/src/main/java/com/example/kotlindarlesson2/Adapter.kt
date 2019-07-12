package com.example.kotlindarlesson2

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list_item.view.*

class Adapter(val list : List<Person>) : RecyclerView.Adapter<ViewHolder>() {
    override fun getItemCount(): Int {
        return list.size
    }

    // Inflates the item views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false))
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val person: Person = list[position]
        holder.title.text = person.title
        holder.description.text = person.description.toString()
        //holder.description.text = items.get(position)
    }

}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    // Holds the TextView that will add each animal to
    val title = view.list_title
    val description = view.list_description


}



data class Person(val title : String, val description: Int)