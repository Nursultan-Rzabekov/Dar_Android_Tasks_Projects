package com.example.kotlindarlesson2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //val animals: ArrayList<String> = ArrayList()

    private val listperson = listOf(
        Person("Nurs", 1987),
        Person("Tair", 1988),
        Person("Amantay", 1997),
        Person("Adilbek", 1997),
        Person("Yernur", 2004),
        Person("Madi", 2006),
        Person("Farukh", 2007),
        Person("Nurbek", 2009)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_animal_list.layoutManager = LinearLayoutManager(this)
        rv_animal_list.adapter = Adapter(listperson)
    }

    fun just(a:Int,b:Int):Double {
        return 5.0
    }


}



