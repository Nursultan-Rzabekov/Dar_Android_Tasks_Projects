package com.example.darhometask1

import android.app.ProgressDialog
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.widget.ImageView
import android.widget.ProgressBar
import java.io.BufferedInputStream
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL

class ImageLoadAsync(internal var context: Context,internal var Url: String, internal var imgV: ImageView) : AsyncTask<ImageView, Void, Bitmap>()
{
    var pd: ProgressDialog? = null
    override fun onPreExecute() {
        super.onPreExecute()

        pd = ProgressDialog(context)
        pd!!.run {
            setTitle("Download in Progress")
            setMessage("Message")
            setProgressStyle(ProgressDialog.STYLE_HORIZONTAL)
            show()
        }

    }

    override fun onPostExecute(bitmap: Bitmap) {
        super.onPostExecute(bitmap)
        imgV.setImageBitmap(bitmap)
    }

    override fun onProgressUpdate(vararg values: Void?) {
        super.onProgressUpdate(*values)
    }

    private fun download_Image(url: String): Bitmap? {
        try {
            val urlstring = URL(url)
            val connection = urlstring.openConnection() as HttpURLConnection
            connection.doInput = true
            connection.connect()
            val input = connection.inputStream
            return BitmapFactory.decodeStream(input)
        } catch (mex: MalformedURLException) {
            println(mex)
            return null
        } catch (ioex: IOException) {
            println(ioex)
            return null
        }

    }

    override fun doInBackground(vararg params: ImageView): Bitmap? {
        //return download_Image(this.Url)
//
//        val path = params[0]
//        var file_length = 0
//        try {
//            val url = URL(path)
//            val urlConnection = url.openConnection()
//            urlConnection.connect()
//            file_length = urlConnection.contentLength
//            val new_folder = File("image")
//            if (!new_folder.exists()) {
//                new_folder.mkdir()
//            }
//            val input_file = File(new_folder, "download.jpg")
//            val inputStream = BufferedInputStream(url.openStream(), 8192)
//            val data = ByteArray(1024)
//            var total = 0
//            val count = 0
//
//            val outputStream = FileOutputStream(new_folder)
//            while ((count=inputStream.read(data))!=1) {
//                total += count
//                outputStream.write(data, 0, count)
//                val progress = total * 100 / file_length
//                publishProgress(progress)
//
//            }
//
//
//        } catch (e: MalformedURLException) {
//            e.printStackTrace()
//        }

        return null
    }
}