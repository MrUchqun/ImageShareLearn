package com.example.imagesharelearn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    lateinit var buttonSearch : Button
    lateinit var buttonShare1: Button
    lateinit var buttonShare2: Button
    lateinit var buttonShare3: Button
    lateinit var editText : EditText
    private val etKey = "editTextText"

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


}