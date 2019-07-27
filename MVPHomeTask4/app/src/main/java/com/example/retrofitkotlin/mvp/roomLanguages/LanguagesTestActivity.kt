package com.example.retrofitkotlin.mvp.roomLanguages

import android.app.Dialog
import android.os.Bundle

import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitkotlin.R
import com.example.retrofitkotlin.data.LanguageRoomDB
import com.example.retrofitkotlin.roomdb.persistence.LanguagesDatabase
import com.example.retrofitkotlin.mvp.BaseActivity
import com.example.retrofitkotlin.mvp.adapters.MyRecyclerTestViewAdapter
import com.example.retrofitkotlin.mvp.presenter.LanguagesPresenterImpl
import com.example.retrofitkotlin.mvp.presenter.LanguagesView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_store.*
import kotlinx.android.synthetic.main.language_detail.*




class LanguagesTestActivity : BaseActivity(), IRoomLanguagesView,
    LanguagesView, MyRecyclerTestViewAdapter.Listener{
    private var postPresenterGetRequest: LanguagesPresenterImpl?=null
    private var postPresenter: RoomLanguagesPresenterImpl?=null
    private var myLanguageArrayList: ArrayList<LanguageRoomDB>? = null

    // ABSTRACT FUNCTION SET LAYOUT
    override fun setLayout(): Int {
        return R.layout.activity_main
    }

    // ABSTRACT FUNCTION INIT
    override fun init(savedInstanceState: Bundle?) {
        getPresenter()?.let {
            it.getAllLanguage()
        }

        fab.setOnClickListener{
            newDialog()
        }

        request.setOnClickListener {
            getPresenterRequest()?.let {
                it.getAllPosts()
            }
        }
    }


    private fun newDialog(){
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_store)

        dialog.push_language.setOnClickListener {
            if (dialog.edit_language.text.toString().isNotEmpty()) {
                getPresenter()?.let {
                    it.storeLanguage(dialog.edit_language.text.toString())
                }
            }
        }
        dialog.show()
    }

    // PRESENTER REST API (RETROFIT)
    private fun getPresenterRequest(): LanguagesPresenterImpl?{
        postPresenterGetRequest = LanguagesPresenterImpl(this, application)
        return postPresenterGetRequest

    }

    // PRESENTER ROOM DATABASE
    private fun getPresenter(): RoomLanguagesPresenterImpl?{
        val languageDatabase = LanguagesDatabase.getInstance(this)
        val viewModel = RoomLanguagesViewModel(languageDatabase.languageDao())
        postPresenter = RoomLanguagesPresenterImpl(this, viewModel)
        return postPresenter
    }


    // ABSTRACT FUNCTION
    override fun onStartScreen() {
        Toast.makeText(applicationContext, "Hello", Toast.LENGTH_SHORT).show()
    }

    // ABSTRACT FUNCTION
    override fun stopScreen() {
        postPresenter?.let {
            postPresenter!!.unbindView()
            postPresenter = null
        }
    }


    //GET DATA FROM SERVER REST API REQUEST

    override fun showAllPosts(languagesList: List<LanguageRoomDB>) {
        for (i in 0 until languagesList.count()) {
            myLanguageArrayList?.add(i, languagesList.elementAt(i))
        }

        getPresenter()?.let {
            it.storeLanguageAll(languagesList)
        }
        //myLanguageArrayList = ArrayList(languagesList)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = MyRecyclerTestViewAdapter(myLanguageArrayList!!, this)
    }

    override fun storePost(languageData: LanguageRoomDB) {
        myLanguageArrayList?.add(languageData)
        recycler_view.adapter?.notifyDataSetChanged()
    }

    override fun updatePost(position: Int, language:LanguageRoomDB) {
        myLanguageArrayList?.removeAt(position)
        myLanguageArrayList?.add(position,language)
        recycler_view.adapter?.notifyDataSetChanged()
    }

    override fun deletePost(position: Int) {
        myLanguageArrayList?.removeAt(position)
        recycler_view.adapter?.notifyItemRemoved(position)
    }

    // END


    // GET DATA FROM ROOM DATABASE LOCAL DATABASE(SQ_LITE)
    override fun showAllLanguage(languagesList: List<LanguageRoomDB>) {
        myLanguageArrayList = ArrayList(languagesList)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = MyRecyclerTestViewAdapter(myLanguageArrayList!!, this)
    }

    override fun storeLanguage(roomDB: LanguageRoomDB) {
        myLanguageArrayList?.add(roomDB)
        recycler_view.adapter?.notifyDataSetChanged()
    }

    override fun deleteLanguage(position: Int) {
        myLanguageArrayList?.removeAt(position)
        recycler_view.adapter?.notifyItemRemoved(position)
    }

    override fun updateLanguage(position: Int, languageData: LanguageRoomDB) {
        myLanguageArrayList?.removeAt(position)
        myLanguageArrayList?.add(position,languageData)
        recycler_view.adapter?.notifyDataSetChanged()
    }

    override fun deleteLanguageByLanguageID(position: Int) {
        myLanguageArrayList?.removeAt(position)
        recycler_view.adapter?.notifyItemRemoved(position)
    }
    // END



    override fun onItemClick(language: LanguageRoomDB, position: Int) {
        var dialog = Dialog(this@LanguagesTestActivity)
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
            getPresenter()?.let {
                it.deleteLanguageByID(position)
            }
        }
        dialog.show()
    }

    private fun alertDialogUpdate(language: LanguageRoomDB, position: Int){
        val view = layoutInflater.inflate(R.layout.edit_text, null)
        val editText = view.findViewById(R.id.edit) as EditText
        val builder = AlertDialog.Builder(this)

        builder.setTitle(language.id.toString())
        builder.setMessage(language.languageName)
        builder.setView(view)

        builder.setPositiveButton(android.R.string.yes) { _ , _ ->
            getPresenter()?.let {
                if(editText.text.toString().isNotEmpty()){
                    it.updateLanguageName(position,editText.text.toString())
                }
            }
        }
        builder.setNegativeButton(android.R.string.no) { dialog, _ ->
            dialog.dismiss()
        }

        builder.show()
    }
}
