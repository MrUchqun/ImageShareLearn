package com.example.imagesharelearn

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu

import android.content.Intent
import android.os.Handler
import android.view.View
import com.tomer.fadingtextview.FadingTextView
import java.util.concurrent.TimeUnit
import kotlin.coroutines.coroutineContext


@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    private var fadingTextView : FadingTextView? = null
    private val appName = "Sharing Browser"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        splashTimer()
        fadingTextView = findViewById(R.id.fading_text_view)
        startExample(fadingTextView)
    }

    private fun splashTimer(){
        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 3500)
    }

    private fun startExample(v: View?) {
        val example = arrayOf("Welcome","to",appName)
        fadingTextView!!.setTexts(example)
        fadingTextView!!.setTimeout(1,TimeUnit.SECONDS)
    }
}