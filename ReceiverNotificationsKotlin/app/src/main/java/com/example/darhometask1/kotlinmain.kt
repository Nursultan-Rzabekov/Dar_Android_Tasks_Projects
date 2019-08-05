package com.example.darhometask1


import android.app.*
import android.content.Context

import android.content.IntentFilter
import android.graphics.BitmapFactory
import android.graphics.Color
import android.net.ConnectivityManager
import android.os.AsyncTask
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.design.widget.BaseTransientBottomBar
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import com.google.gson.Gson
import okhttp3.*
import org.json.JSONException
import java.io.BufferedReader
import java.io.File
import java.io.IOException

@Suppress("DEPRECATION")
class kotlinmain : AppCompatActivity(),ConnectivityReceiver.ConnectivityReceiverListener  {
    lateinit var notificationManager : NotificationManager
    lateinit var notificationChannel : NotificationChannel
    lateinit var builder : Notification.Builder
    private val channelId = "qwerty"
    private val description = "Test notification"

    private var snackbar: Snackbar? = null
    lateinit var context: Context
    lateinit var recyclerView_main: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kotlin_main)
        context = this

        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        recyclerView_main = findViewById(R.id.recyclerView_main)
        recyclerView_main.layoutManager = LinearLayoutManager(this)

        registerReceiver(ConnectivityReceiver(), IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))


        getQuestions().execute()
    }

    internal inner class getQuestions : AsyncTask<Void, Void, String>() {

        lateinit var progressDialog: ProgressDialog
        var hasInternet = false

        override fun doInBackground(vararg p0: Void?): String {
            if (isNetworkAvailable()) {
                hasInternet = true
                val client = OkHttpClient()
                val url = "https://api.letsbuildthatapp.com/youtube/home_feed"
                val request = Request.Builder().url(url).build()
                val response = client.newCall(request).execute()

                client.newCall(request).enqueue(object: Callback {
                    @RequiresApi(Build.VERSION_CODES.O)
                    override fun onResponse(call: Call?, response: Response?) {
                        val body = response?.body()?.string()
                        val gson = Gson() //GsonBuilder().create()
                        val fileName = cacheDir.absolutePath+"/PostJson11.json"
                        val file= File(fileName)
                        val inputString:String
                        val long:Long
                        long = 0

                        println("!!!!!!!!!!!!!" + file.length())

                        if(!file.exists() && file.length() == long){
                            val pendingIntent = PendingIntent.getActivity(context,0,intent, PendingIntent.FLAG_UPDATE_CURRENT)

                            notificationChannel = NotificationChannel(channelId,description,NotificationManager.IMPORTANCE_HIGH)
                            notificationChannel.enableLights(true)
                            notificationChannel.lightColor = Color.GREEN
                            notificationChannel.enableVibration(false)
                            notificationManager.createNotificationChannel(notificationChannel)

                            builder = Notification.Builder(context,channelId)
                                .setSmallIcon(R.drawable.abc_ic_menu_cut_mtrl_alpha)
                                .setLargeIcon(BitmapFactory.decodeResource(context.resources,R.drawable.ic_launcher_background))
                                .setContentIntent(pendingIntent)
                            notificationManager.notify(1234,builder.build())

                            val homeFeed = gson.fromJson(body, HomeFeed::class.java)
                            var jsonString:String = gson.toJson(homeFeed)
                            file.writeText(jsonString)
                            val bufferedReader: BufferedReader = File(fileName).bufferedReader()
                            inputString = bufferedReader.use { it.readText() }
                            val homeFeed1 = gson.fromJson(inputString, HomeFeed::class.java)
                            runOnUiThread {
                                recyclerView_main.adapter = ImageViewAdapter(homeFeed1)
                            }
                        }
                        else{
                            val bufferedReader: BufferedReader = File(fileName).bufferedReader()
                            inputString = bufferedReader.use { it.readText() }
                            val homeFeed1 = gson.fromJson(inputString, HomeFeed::class.java)
                            runOnUiThread {
                                println("<<><><>><><>< "  + homeFeed1)
                                recyclerView_main.adapter = ImageViewAdapter(homeFeed1)
                            }
                        }
                    }

                    override fun onFailure(call: Call?, e: IOException?) {
                        println("Failed to execute request")
                    }
                })
                return response.body()?.string().toString()
            } else {
                return ""
            }
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            if (hasInternet) {
                try {
                } catch (e: JSONException) {

                }
            }
        }
    }
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onNetworkConnectionChanged(isConnected: Boolean) {
        showNetworkMessage(isConnected)
    }


    override fun onResume() {
        super.onResume()
        ConnectivityReceiver.connectivityReceiverListener = this
    }


    @RequiresApi(Build.VERSION_CODES.O)
    private fun showNetworkMessage(isConnected: Boolean) {
        if (!isConnected) {
            snackbar = Snackbar.make(findViewById(R.id.rootLayout), "You are offline", Snackbar.LENGTH_LONG)
            snackbar?.duration = BaseTransientBottomBar.LENGTH_INDEFINITE
            snackbar?.show()
            recyclerView_main.setVisibility(View.INVISIBLE)


        } else {
            snackbar = Snackbar.make(findViewById(R.id.rootLayout), "You are online", Snackbar.LENGTH_LONG)
            snackbar?.duration = BaseTransientBottomBar.LENGTH_INDEFINITE
            snackbar?.show()
            recyclerView_main.setVisibility(View.VISIBLE)
        }
    }

    private fun isNetworkAvailable(): Boolean {
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }
}

class HomeFeed(val videos: List<Video>)
class Video(val imageUrl: String)
