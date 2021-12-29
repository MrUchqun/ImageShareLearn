package com.example.imagesharelearn

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.widget.ImageView

class ShareActivity : AppCompatActivity() {
    private lateinit var imageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share)
        initView()
        intentContent()
    }

    private fun initView() {
        imageView = findViewById(R.id.iv_share)
    }

    private fun intentContent(){
        val intent = intent
        val action = intent.action
        val type = intent.type
        if (Intent.ACTION_SEND == action && type != null){
            if (type.startsWith("image/")){
                handleSendImage(intent)
            }
        }
    }

    private fun handleSendImage(intent: Intent) {
        val uri = intent.getParcelableExtra<Uri>(Intent.EXTRA_STREAM)
        imageView.setImageURI(uri)
    }
}