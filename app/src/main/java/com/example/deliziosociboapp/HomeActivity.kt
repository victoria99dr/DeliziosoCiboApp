package com.example.deliziosociboapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.deliziosociboapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Home())

    binding.bottomNavigationView.setOnItemSelectedListener {

        when(it.itemId){

            R.id.home -> replaceFragment(Home())
            R.id.account -> replaceFragment(Profile())
            R.id.help -> replaceFragment(Help())
            R.id.location -> replaceFragment(Location())

            else ->{

            }
        }
        true

    }

    }

    private fun replaceFragment(fragment: Fragment){

        val  fragmentManager = supportFragmentManager
        val  fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()
    }
}