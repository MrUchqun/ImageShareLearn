package com.example.imagesharelearn

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.media.Image
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import java.io.ByteArrayOutputStream

class MainActivity : AppCompatActivity() {

    lateinit var buttonSearch : Button
    lateinit var buttonShare1: Button
    lateinit var buttonShare2: Button
    lateinit var buttonShare3: Button
    lateinit var editText : EditText
    val etKey = "editTextText"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView(){
        buttonSearch = findViewById(R.id.btn_search)
        buttonSearch.setOnClickListener {
            buttonSearch(editText())
        }

        buttonShare1 = findViewById(R.id.btn_share_1)
        buttonShare1.setOnClickListener {

        }
    }

    private fun buttonSearch(url:String){
        val intent = Intent(this@MainActivity, BrowserActivity::class.java)
        intent.putExtra(etKey,url)
        startActivity(intent)
    }

    private fun editText():String{
        editText = findViewById(R.id.et_search)
        return editText.text.toString()
    }

    private fun shareImage(uriToImage : Uri){
        val intent = Intent()
        intent.action = Intent.ACTION_SEND
        intent.putExtra(Intent.EXTRA_STREAM,uriToImage)
        intent.type = "image/*"
        startActivity(intent)
    }


    fun convertImageViewToBitmap(imageView : ImageView) {
        imageView.buildDrawingCache()
        val bitmap: Bitmap = imageView.drawingCache
        val uri = getImageUri(this, bitmap)
        shareImage(uri)
    }

    private fun getImageUri(inContext: Context, inImage: Bitmap): Uri {
        val bytes = ByteArrayOutputStream()
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes)
        val path =
            MediaStore.Images.Media.insertImage(inContext.contentResolver, inImage, "Title", null)
        return Uri.parse(path)
    }







//    private fun imageToUri(v :View){
//        val byte = ByteArrayOutputStream()
//
//    }



//    private fun imageToBitmap(v :View) : Uri{
//        v.buildDrawingCache()
//        val bitmap = v.drawingCache
//    }
}
