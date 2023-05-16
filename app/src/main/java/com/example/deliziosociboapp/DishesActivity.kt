package com.example.deliziosociboapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DishesActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var foodList: ArrayList<Food>
    private lateinit var foodAdapter: FoodAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dishes)

        init()

    }
    private fun init(){
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = GridLayoutManager(this,2)

        foodList = ArrayList()
        addDataToList()

        foodAdapter = FoodAdapter(foodList)
        recyclerView.adapter = foodAdapter

    }
    private fun addDataToList(){
        foodList.add(Food(R.drawable.doughnouts, "Doughnuts"))
        foodList.add(Food(R.drawable.hotdog, "Hotdog"))
        foodList.add(Food(R.drawable.hamburger, "Hamburger"))
        foodList.add(Food(R.drawable.onion, "OnionDip"))
        foodList.add(Food(R.drawable.pizza, "Pizza"))
        foodList.add(Food(R.drawable.pudding, "Pudding"))
        foodList.add(Food(R.drawable.ravioli, "Ravioli"))
        foodList.add(Food(R.drawable.samosa, "Samosa"))
        foodList.add(Food(R.drawable.tacos, "Tacos"))
    }
}