package com.example.deliziosociboapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



class CookActivity : AppCompatActivity() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>? = null

    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book)
        recyclerView= findViewById(R.id.recyclerView)
        layoutManager = LinearLayoutManager (this)
//        recyclerView.LayoutManager = layoutManager

        adapter = RecyclerViewAdapter()
        recyclerView.adapter = adapter



    }
}