package com.example.deliziosociboapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FoodAdapter(private val foodList:ArrayList<Food>) :
    RecyclerView.Adapter<FoodAdapter.FoodViewHolder>(){

    class FoodViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
       val imageView : ImageView = itemView.findViewById(R.id.doughn)
        val textView :TextView = itemView.findViewById(R.id.txtdough)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_each_dish , parent ,false)
        return FoodViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  foodList.size
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val food = foodList[position]
        holder.imageView.setImageResource(food.image)
        holder.textView.text = food.name
    }
}