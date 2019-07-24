package com.example.retrofitkotlin.uidesign.languages

import android.app.Dialog
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import com.example.retrofitkotlin.R
import com.example.retrofitkotlin.data.LanguageModel
import com.example.retrofitkotlin.uidesign.BaseActivity
import com.example.retrofitkotlin.uidesign.adapters.MyRecyclerViewAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_store.*
import kotlinx.android.synthetic.main.language_detail.*

class LanguagesActivity : BaseActivity(), LanguagesView, MyRecyclerViewAdapter.Listener{


    var postPresenter: LanguagesPresenterImpl?=null
    var myLanguageArrayList: ArrayList<LanguageModel>? = null

    override fun setLayout(): Int {
        return R.layout.activity_main;
    }

    override fun init(savedInstanceState: Bundle?) {
        getPresenter()?.let {
            it.getAllPosts()
        }


        fab.setOnClickListener{
                        Toast.makeText(this, "YEEESS", Toast.LENGTH_LONG).show()
            newDialog()
        }
    }


    private fun newDialog(){
        var dialog = Dialog(this@LanguagesActivity)
        dialog.setContentView(R.layout.dialog_store)

        dialog.push_language.setOnClickListener {
            if (!dialog.edit_language.text.toString().isEmpty()) {
                Toast.makeText(this, "!!!!!", Toast.LENGTH_LONG).show()

                getPresenter()?.let {
                    it.StoreLanguage(this, dialog.edit_language.text.toString()).execute()
                }
            }
        }

        dialog.show()
    }


    fun getPresenter(): LanguagesPresenterImpl?{
        postPresenter = LanguagesPresenterImpl(this, application)
        return postPresenter
    }



    override fun onStartScreen() {

    }

    override fun stopScreen() {
        postPresenter?.let {
            postPresenter!!.unbindView()
            postPresenter = null
        }

    }

    override fun showAllPosts(languagesList: List<LanguageModel>) {
        Log.d("Response", "" + languagesList)
        myLanguageArrayList = ArrayList(languagesList)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = MyRecyclerViewAdapter(myLanguageArrayList!!, this)
    }


    override fun onItemClick(language: LanguageModel, position: Int) {

        var dialog = Dialog(this@LanguagesActivity)
        dialog.setContentView(R.layout.language_detail)

        dialog.textView.text = language.id.toString()
        dialog.textView2.text = language.name
        dialog.textView3.text = language.created_at
        dialog.textView4.text = language.updated_at

        dialog.cancel.setOnClickListener {
            dialog.dismiss()
        }

        dialog.update.setOnClickListener {

            val view = layoutInflater.inflate(R.layout.edit_text, null)
            val editText = view.findViewById(R.id.edit) as EditText
            val builder = AlertDialog.Builder(this)

            builder.setTitle(language.id.toString())
            builder.setMessage(language.name)
            builder.setView(view)

            builder.setPositiveButton(android.R.string.yes) { dialog, which ->
                Toast.makeText(applicationContext, android.R.string.yes, Toast.LENGTH_SHORT).show()

                getPresenter()?.let {
                    it.UpdateLanguage(this, position, editText.text.toString(), language.id).execute()
                }


            }

            builder.setNegativeButton(android.R.string.no) { dialog, which ->
                Toast.makeText(applicationContext, android.R.string.no, Toast.LENGTH_SHORT).show()
            }

            builder.show()
        }

        dialog.delete.setOnClickListener {
            getPresenter()?.let {
                it.DeleteLanguage(this, position).execute()
            }
        }

        dialog.show()
    }


}
