package com.example.cleanarhitecturewithmvp.mvp.roomLanguages

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle

import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cleanarhitecturewithmvp.R
import com.example.cleanarhitecturewithmvp.data.database.LanguagesDatabase
import com.example.cleanarhitecturewithmvp.domain.model.Language
import com.example.cleanarhitecturewithmvp.mvp.BaseActivity
import com.example.cleanarhitecturewithmvp.mvp.adapters.MyRecyclerTestViewAdapter

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_store.*
import kotlinx.android.synthetic.main.language_detail.*


class LanguagesTestActivity : BaseActivity(), IRoomLanguagesView, MyRecyclerTestViewAdapter.Listener{

    private var postPresenter: RoomLanguagesPresenterImpl?=null
    private var myLanguageArrayList: ArrayList<Language>? = null

    // ABSTRACT FUNCTION SET LAYOUT
    override fun setLayout(): Int {
        return R.layout.activity_main
    }

    // ABSTRACT FUNCTION INIT
    override fun init(savedInstanceState: Bundle?) {
        getPresenter()?.getAllLanguage()

        fab.setOnClickListener{
            newDialog()
        }

    }

    private fun newDialog(){
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_store)

        dialog.push_language.setOnClickListener {
            if (dialog.edit_language.text.toString().isNotEmpty()) {
                getPresenter()?.storeLanguage(dialog.edit_language.text.toString())
            }
        }
        dialog.show()
    }

    // PRESENTER ROOM DATABASE
    private fun getPresenter(): RoomLanguagesPresenterImpl?{
        postPresenter = RoomLanguagesPresenterImpl(this, application)
        return postPresenter
    }


    // ABSTRACT FUNCTION
    override fun onStartScreen() {
        Toast.makeText(applicationContext, "Hello", Toast.LENGTH_SHORT).show()
    }

    // ABSTRACT FUNCTION
    override fun stopScreen() {
        super.onStop()
        postPresenter?.let {
            postPresenter = null
            postPresenter?.onDestroy()
        }
    }

//    //GET DATA FROM SERVER REST API REQUEST
//    override fun showAllPosts(languagesList: List<LanguageRoomDB>) {
//        val a = myLanguageArrayList?.count()
//        for (i in 0 until languagesList.count()) {
//            myLanguageArrayList?.add(a!! + i, languagesList.elementAt(i))
//        }
//        getPresenter()?.storeLanguageAll(myLanguageArrayList)
//        recycler_view.adapter?.notifyDataSetChanged()
//    }
//
//    override fun storePost(languageData: LanguageRoomDB) {
//        myLanguageArrayList?.add(languageData)
//        recycler_view.adapter?.notifyItemInserted(myLanguageArrayList?.lastIndex!!)
//    }
//
//    override fun updatePost(position: Int, languageData:LanguageRoomDB) {
//        myLanguageArrayList?.removeAt(position)
//        myLanguageArrayList?.add(position,languageData)
//        recycler_view.adapter?.notifyDataSetChanged()
//    }
//
//    override fun deletePost(position: Int) {
//        myLanguageArrayList?.removeAt(position)
//        recycler_view.adapter?.notifyItemRemoved(position)
//    }
//
//    // END


    // GET DATA FROM ROOM DATABASE LOCAL DATABASE(SQ_LITE)
    override fun showAllLanguage(languagesList: List<Language>) {
        myLanguageArrayList = ArrayList(languagesList)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = MyRecyclerTestViewAdapter(myLanguageArrayList!!, this)
    }

    override fun storeLanguage(roomDB: Language) {
        myLanguageArrayList?.add(roomDB)
        recycler_view.adapter?.notifyItemInserted(myLanguageArrayList?.lastIndex!!)
    }

    override fun deleteLanguage() {
        recycler_view.adapter?.notifyItemRangeRemoved(0,myLanguageArrayList?.lastIndex!!)
        myLanguageArrayList?.clear()
    }

    override fun updateLanguage(position: Int, languageData: Language) {
        myLanguageArrayList?.removeAt(position)
        myLanguageArrayList?.add(position,languageData)
        recycler_view.adapter?.notifyDataSetChanged()
    }

    override fun deleteLanguageByLanguageID(position: Int) {
        myLanguageArrayList?.removeAt(position)
        recycler_view.adapter?.notifyItemRemoved(position)
    }

    // END


    override fun onItemClick(language: Language, position: Int) {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.language_detail)

        dialog.textView.text = language.id.toString()
        dialog.textView2.text = language.languageName
        dialog.textView3.text = language.created_at
        dialog.textView4.text = language.updated_at

        dialog.cancel.setOnClickListener {
            dialog.dismiss()
        }

        dialog.update.setOnClickListener {
            alertDialogUpdate(language,position)
        }

        dialog.delete.setOnClickListener {
            getPresenter()?.deleteLanguageByID(position)
        }
        dialog.show()
    }

    @SuppressLint("InflateParams")
    private fun alertDialogUpdate(language: Language, position: Int){
        val view = layoutInflater.inflate(R.layout.edit_text, null)
        val editText = view.findViewById(R.id.edit) as EditText
        val builder = AlertDialog.Builder(this)

        builder.setTitle(language.id.toString())
        builder.setMessage(language.languageName)
        builder.setView(view)

        builder.setPositiveButton(android.R.string.yes) { _ , _ ->
            if(editText.text.toString().isNotEmpty()){
                getPresenter()?.updateLanguageName(position,editText.text.toString())
            }
        }
        builder.setNegativeButton(android.R.string.no) { dialog, _ ->
            dialog.dismiss()
        }

        builder.show()
    }
}
