package com.example.deliziosociboapp

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class AboutActivity : AppCompatActivity() {
    lateinit var share:Button
    lateinit var call:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        share = findViewById(R.id.share)
        call = findViewById(R.id.btnContact)

        // Set onclick listeners
        share.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Hey, download this app!")
            startActivity(shareIntent)

        }
        call.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+0718057724"))
            if (ContextCompat.checkSelfPermission(
                    this@AboutActivity,
                    android.Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this@AboutActivity,
                    arrayOf(android.Manifest.permission.CALL_PHONE),
                    1
                )
            } else {
                startActivity(intent)
            }

        }
    }
}