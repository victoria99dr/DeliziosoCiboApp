package com.example.deliziosociboapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.deliziosociboapp.databinding.ActivityHomeBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {

    private lateinit var binding :ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        replaceFragment(Home())
        binding.chefs.setOnClickListener {
            startActivity(Intent(this,ChefsActivity::class.java))
        }
        binding.dishes.setOnClickListener {
            startActivity(Intent(this,DishesActivity::class.java))
        }
        binding.book.setOnClickListener {
            startActivity(Intent(this,CookActivity::class.java))
        }
        binding.offers.setOnClickListener {
            startActivity(Intent(this,OffersActivity::class.java))
        }
        binding.bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId){

                R.id.home -> {
                    startActivity(Intent(this,HomeActivity::class.java))
                }
                R.id.help -> {
                    startActivity(Intent(this,HelpActivity::class.java))
                }                else ->{

                }

            }
            true

        }

        }
}