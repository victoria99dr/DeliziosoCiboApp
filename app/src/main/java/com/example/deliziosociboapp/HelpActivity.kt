package com.example.deliziosociboapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent
import android.net.Uri

class HelpActivity : AppCompatActivity() {
   lateinit var email:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help)

        email= findViewById(R.id.sms)

        email.setOnClickListener {
            val emailIntent =
                Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "baritori27@gmail.com", null))
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "JOB APPLICATION")
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Dear sir, following the job advertisement")
            startActivity(Intent.createChooser(emailIntent, "Send email..."))

        }
    }
}