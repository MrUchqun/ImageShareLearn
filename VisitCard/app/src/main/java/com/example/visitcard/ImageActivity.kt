package com.example.visitcard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class ImageActivity : AppCompatActivity() {
    private lateinit var imageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)
        initView()
    }

    private fun initView() {
        imageView = findViewById(R.id.iv_image)
        imageView.setImageResource(intent.getIntExtra("image",10001))
    }
}