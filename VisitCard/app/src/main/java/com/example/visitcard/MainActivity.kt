package com.example.visitcard

import android.content.Intent
import android.net.Uri
import android.net.UrlQuerySanitizer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import java.net.URL

class MainActivity : AppCompatActivity() {
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView(){
        button1 = findViewById(R.id.btn_phone_number)
        button2 = findViewById(R.id.btn_instagram_page)
        button3 = findViewById(R.id.btn_photos)

        button1.setOnClickListener {
            callButton1("tel:+998971410425")
        }
        button2.setOnClickListener {
            callButton2("https://instagram.com/mruchqun")
        }
        button3.setOnClickListener {
            callButton3(R.drawable.stive_jobs)
        }
    }

    private fun callButton1(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse(phoneNumber)
        startActivity(intent)
    }

    private fun callButton2(url: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }

    private fun callButton3(image:Int) {
        val intent = Intent(this@MainActivity, ImageActivity::class.java)
        intent.putExtra("image",image)
        startActivity(intent)
    }
}