package com.example.imagesharelearn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent
import android.widget.EditText


class EmailActivity : AppCompatActivity() {

    private lateinit var buttonSendEmail: Button
    private lateinit var editTextEmail: EditText
    private lateinit var editTextMessage: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email)
        initView()
    }


    private fun initView() {
        editTextEmail = findViewById(R.id.et_email_address)
        editTextMessage = findViewById(R.id.et_message)
        buttonSendEmail = findViewById(R.id.btn_email_send)
        buttonSendEmail.setOnClickListener {
            val email = Intent(Intent.ACTION_SEND)
            email.putExtra(Intent.EXTRA_EMAIL, arrayOf(editTextEmail.text))
            email.putExtra(Intent.EXTRA_SUBJECT, "subject")
            email.putExtra(Intent.EXTRA_TEXT, editTextMessage.text)
            email.type = "message/rfc822"
            startActivity(Intent.createChooser(email, "Choose an Email client :"))
        }
    }

}