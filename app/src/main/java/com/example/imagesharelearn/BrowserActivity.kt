package com.example.imagesharelearn

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.EditText
import java.net.MalformedURLException

import android.util.Patterns

import android.webkit.URLUtil

import java.net.URL




class BrowserActivity : AppCompatActivity() {
    private lateinit var browser: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_browser)
        initView(getUrl()!!)
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun initView(url:String){
        browser = findViewById(R.id.wv_browser)
        browser.webViewClient = object : WebViewClient(){}
        browser.settings.javaScriptEnabled = true

        if (url != "" && url.isValidUrl())
            browser.loadUrl("https://$url")
        else
            browser.loadUrl("https://google.com/search?q=$url")
    }

    private fun getUrl(): String? {
        return intent.extras!!.getString(MainActivity().etKey)
    }

    fun String.isValidUrl(): Boolean = Patterns.WEB_URL.matcher(this).matches()
}