package com.example.deliziosociboapp

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var aboutBtn:Button
    lateinit var homeBtn:Button
    lateinit var start:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        aboutBtn = findViewById(R.id.aboutBtn)
        homeBtn = findViewById(R.id.home)
        start = findViewById(R.id.btnStart)

        //Set onclick listeners
        aboutBtn.setOnClickListener {
            var tembea = Intent(this,AboutActivity::class.java)
            startActivity(tembea)
        }

        homeBtn.setOnClickListener {
            var tembea = Intent(this,HomeActivity::class.java)
            startActivity(tembea)
        }

        start.setOnClickListener {
            var tembea = Intent(this,RegisterActivity::class.java)
            startActivity(tembea)
        }
    }
}