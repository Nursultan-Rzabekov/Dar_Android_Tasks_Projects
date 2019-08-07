package com.example.cleanarhitecturewithmvvm.mvvm.logic

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.util.Log

import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cleanarhitecturewithmvvm.ApplicationClass
import com.example.cleanarhitecturewithmvvm.R
import com.example.cleanarhitecturewithmvvm.domain.model.Language
import com.example.cleanarhitecturewithmvvm.extension.observe
import com.example.cleanarhitecturewithmvvm.mvvm.BaseActivity
import com.example.cleanarhitecturewithmvvm.mvvm.adapters.MyRecyclerTestViewAdapter
import com.example.cleanarhitecturewithmvvm.mvvm.helpers.LocationListener

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_store.*
import kotlinx.android.synthetic.main.language_detail.*
import javax.inject.Inject


class LanguagesMVVMActivity : BaseActivity() , MyRecyclerTestViewAdapter.Listener{

    @Inject
    lateinit var provideLanguagesViewModelFactory: LanguagesViewModelFactory

    private lateinit var viewModel: LanguagesViewModel
    private var myLanguageArrayList: ArrayList<Language>? = null
    private lateinit var locationListener: LocationListener

    override fun setLayout(): Int {
        return R.layout.activity_main
    }

    override fun init(savedInstanceState: Bundle?) {
        (application as ApplicationClass).applicationComponent.inject(this)

        setupLocationListener()

        getViewModel()?.getAllLanguage().let{
            observe(viewModel.languagesList,::showAllLanguage)
        }

        fab.setOnClickListener{
            newDialog()
        }

    }

    private fun setupLocationListener() {
        locationListener = LocationListener(lifecycle) { location ->
            Log.d("MainActivity", "Location is $location")
        }
    }

    private fun newDialog(){
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_store)

        dialog.push_language.setOnClickListener {
            if (dialog.edit_language.text.toString().isNotEmpty()) {
                getViewModel()?.storeLanguage(dialog.edit_language.text.toString())
                val language = Language(dialog.edit_language.text.toString())
                storeLanguage(language)
            }
        }
        dialog.show()
    }

    private fun getViewModel(): LanguagesViewModel? {
        viewModel = ViewModelProviders.of(this, provideLanguagesViewModelFactory).
            get(LanguagesViewModel::class.java)

        return viewModel
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(applicationContext, "Stopped", Toast.LENGTH_SHORT).show()
        viewModel.onDestroy()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(applicationContext, "Destroyed", Toast.LENGTH_SHORT).show()
        viewModel.onDestroy()
    }

    private fun showAllLanguage(languagesList: List<Language>?) {
        locationListener.enable()
        myLanguageArrayList = ArrayList(languagesList)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = MyRecyclerTestViewAdapter(myLanguageArrayList!!, this)
    }

    private fun storeLanguage(roomDB: Language) {
        myLanguageArrayList?.add(roomDB)
        recycler_view.adapter?.notifyItemInserted(myLanguageArrayList?.lastIndex!!)
    }

    private fun updateLanguage(position: Int, languageData: Language) {
        myLanguageArrayList?.removeAt(position)
        myLanguageArrayList?.add(position,languageData)
        recycler_view.adapter?.notifyDataSetChanged()
    }

    private fun deleteLanguageByLanguageID(position: Int) {
        myLanguageArrayList?.removeAt(position)
        recycler_view.adapter?.notifyItemRemoved(position)
    }

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
            getViewModel()?.deleteLanguageByID(position)
            deleteLanguageByLanguageID(position)
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
                getViewModel()?.updateLanguageName(position,editText.text.toString())
                val languageModel = Language(editText.text.toString())
                updateLanguage(position,languageModel)
            }
        }
        builder.setNegativeButton(android.R.string.no) { dialog, _ ->
            dialog.dismiss()
        }

        builder.show()
    }
}
