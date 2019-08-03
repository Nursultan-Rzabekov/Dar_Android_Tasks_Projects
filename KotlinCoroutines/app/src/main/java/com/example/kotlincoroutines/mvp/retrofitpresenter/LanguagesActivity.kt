package com.example.kotlincoroutines.mvp.retrofitpresenter

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle

import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlincoroutines.R
import com.example.kotlincoroutines.data.LanguageRoomDB
import com.example.kotlincoroutines.mvp.BaseActivity
import com.example.kotlincoroutines.mvp.adapters.MyRecyclerTestViewAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_store.*
import kotlinx.android.synthetic.main.language_detail.*


class LanguagesActivity : BaseActivity(), LanguagesView, MyRecyclerTestViewAdapter.Listener{


    private var postPresenter: LanguagesPresenterImpl?=null
    private var myLanguageArrayList: ArrayList<LanguageRoomDB>? = null


    override fun setLayout(): Int {
        return R.layout.activity_main
    }

    override fun init(savedInstanceState: Bundle?) {
        getPresenter()?.getAllPosts()

        fab.setOnClickListener{
            newDialog()
        }
    }

    private fun newDialog(){
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_store)

        dialog.push_language.setOnClickListener {
            if (dialog.edit_language.text.toString().isNotEmpty()) {
                getPresenter()?.storePosts(dialog.edit_language.text.toString())
            }
        }
        dialog.show()
    }

    private fun getPresenter(): LanguagesPresenterImpl?{
        postPresenter = LanguagesPresenterImpl(this, application)
        return postPresenter
    }

    override fun onStartScreen() {
        Toast.makeText(applicationContext, "Hello", Toast.LENGTH_SHORT).show()
    }

    override fun stopScreen() {
        postPresenter?.let {
            postPresenter = null
            postPresenter?.onDestroy()
        }
    }

    override fun showAllPosts(languagesList: List<LanguageRoomDB>) {
        myLanguageArrayList = ArrayList(languagesList)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = MyRecyclerTestViewAdapter(myLanguageArrayList!!, this)
    }

    override fun storePost(languageData: LanguageRoomDB) {
        myLanguageArrayList?.add(languageData)
        recycler_view.adapter?.notifyItemInserted(myLanguageArrayList?.lastIndex!!)
    }

    override fun updatePost(position: Int, language:LanguageRoomDB) {
        myLanguageArrayList?.removeAt(position)
        myLanguageArrayList?.add(position,language)
        recycler_view.adapter?.notifyItemChanged(position)
    }

    override fun deletePost(position: Int) {
        myLanguageArrayList?.removeAt(position)
        recycler_view.adapter?.notifyItemRemoved(position)
    }

    override fun onItemClick(language: LanguageRoomDB, position: Int) {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.language_detail)

        dialog.textView.text = language.id.toString()
        dialog.textView2.text = language.languageName

        dialog.cancel.setOnClickListener {
            dialog.dismiss()
        }

        dialog.update.setOnClickListener {
            alertDialogUpdate(language,position)
        }

        dialog.delete.setOnClickListener {
            getPresenter()?.deletePosts(position,language.id)
        }
        dialog.show()
    }


    @SuppressLint("InflateParams")
    private fun alertDialogUpdate(language: LanguageRoomDB, position: Int){
        val view = layoutInflater.inflate(R.layout.edit_text, null)
        val editText = view.findViewById(R.id.edit) as EditText
        val builder = AlertDialog.Builder(this)

        builder.setTitle(language.id.toString())
        builder.setMessage(language.languageName)
        builder.setView(view)

        builder.setPositiveButton(android.R.string.yes) { _ , _ ->
            if(editText.text.toString().isNotEmpty()){
                getPresenter()?.updatePosts(position, editText.text.toString(),language.id)
            }

        }
        builder.setNegativeButton(android.R.string.no) { dialog, _ ->
            dialog.dismiss()
        }

        builder.show()
    }
}
