package com.example.imagesharelearn

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.widget.ImageView
import androidx.cardview.widget.CardView

class ShareActivity : AppCompatActivity() {
    private lateinit var imageView: ImageView
    private lateinit var cardView: CardView
    private lateinit var text: String
    private var uriParse: Uri? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share)
        initView()
    }

    private fun initView() {
        imageView = findViewById(R.id.iv_share)
        intentContent()

        cardView = findViewById(R.id.cv_set_image)
        cardView.setOnClickListener {
            setImageIntent()
        }
    }

    private fun setImageIntent() {
        val intent = Intent(this@ShareActivity, MainActivity::class.java)
        intent.putExtra("background",uriParse)
        startActivity(intent)
        this.finish()
    }

    private fun intentContent(){
        val intent = intent
        val action = intent.action
        val type = intent.type
        if (Intent.ACTION_SEND == action && type != null){
            if (type.startsWith("image/")){
                handleSendImage(intent)
            }
            else if (type == "text/plain"){
                handleSendText(intent)
            }
        }
    }

    private fun handleSendImage(intent: Intent) {
        uriParse = intent.getParcelableExtra(Intent.EXTRA_STREAM)
        imageView.setImageURI(uriParse)
    }

    private fun handleSendText(intent: Intent) {
        text = intent.getStringExtra(Intent.EXTRA_TEXT).toString()
        val intentText = Intent(this,BrowserActivity::class.java)
        intentText.putExtra(MainActivity().etKey,text)
        startActivity(intentText)
    }
}