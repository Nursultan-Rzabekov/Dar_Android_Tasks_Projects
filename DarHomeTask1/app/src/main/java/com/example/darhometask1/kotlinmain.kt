package com.example.darhometask1


import android.app.*
import android.content.Context

import android.content.IntentFilter
import android.graphics.BitmapFactory
import android.graphics.Color
import android.net.ConnectivityManager
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BaseTransientBottomBar
import android.support.design.widget.Snackbar
import android.support.v4.app.NotificationCompat
import android.support.v4.app.NotificationManagerCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AlertDialog
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
    private val channelId = "com.example.vicky.notificationexample"
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

        override fun onPreExecute() {
            super.onPreExecute()
            progressDialog = ProgressDialog(context)
            progressDialog.setMessage("Download image from Internet")
            progressDialog.setCancelable(false)
            progressDialog.show()
        }

        override fun doInBackground(vararg p0: Void?): String {
            if (isNetworkAvailable()) {
                hasInternet = true
                val client = OkHttpClient()
                val url = "https://api.letsbuildthatapp.com/youtube/home_feed"
                val request = Request.Builder().url(url).build()
                val response = client.newCall(request).execute()



                client.newCall(request).enqueue(object: Callback {
                    override fun onResponse(call: Call?, response: Response?) {
                        val body = response?.body()?.string()
                        val gson = Gson() //GsonBuilder().create()
                        val fileName = cacheDir.absolutePath+"/PostJson.json"
                        val file= File(fileName)
                        val inputString:String
                        val long:Long
                        long = 0

                        println("!!!!!!!!!!!!!" + file.length())

                        if(!file.exists() && file.length() == long){
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



    override fun onNetworkConnectionChanged(isConnected: Boolean) {
        showNetworkMessage(isConnected)
    }


    override fun onResume() {
        super.onResume()
        ConnectivityReceiver.connectivityReceiverListener = this
    }


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


            val pendingIntent = PendingIntent.getActivity(this,0,intent, PendingIntent.FLAG_UPDATE_CURRENT)

            notificationChannel = NotificationChannel(channelId,description,NotificationManager.IMPORTANCE_HIGH)
            notificationChannel.enableLights(true)
            notificationChannel.lightColor = Color.GREEN
            notificationChannel.enableVibration(false)
            notificationManager.createNotificationChannel(notificationChannel)

            builder = Notification.Builder(this,channelId)
                .setContent(contentView)
                .setSmallIcon(R.drawable.ic_launcher_round)
                .setLargeIcon(BitmapFactory.decodeResource(this.resources,R.drawable.ic_launcher))
                .setContentIntent(pendingIntent)
            notificationManager.notify(1234,builder.build())



//            val notification = NotificationCompat.Builder(this,"image downloaded")
//                .setContentTitle("Example Service")
//                .setContentText("Image downloaded")
//                //.setSmallIcon(R.drawable.ic_android)
//                .setPriority(NotificationCompat.PRIORITY_HIGH)
//                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
//                .build()
//
//
//            notificationManager.notify(1, notification);
//            val serviceIntent = Intent(context, ExampleService::class.java)
//            serviceIntent.putExtra("inputExtra", "Image downloaded")
//            ContextCompat.startForegroundService(context, serviceIntent)
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
