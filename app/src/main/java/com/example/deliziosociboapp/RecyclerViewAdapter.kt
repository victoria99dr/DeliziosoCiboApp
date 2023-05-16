package com.example.deliziosociboapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter :RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    private val itemTitles = arrayOf(
        "Lasagna",
        "Potato Salad",
        "Banana Smoothie",
        "Tomato Soup",
        "Orange Cake",
        "West Groundnut Chop"
    )
    private val itemDetails = arrayOf(
        "Firstly spoon meat sauce on the bottom of a lightly greased casserole dish.Add four boiled lasagna noodles(or use no-boil or fresh noodles).Spread one-third of the ricotta cheese mixture on top.Add 1.5 cups of meat sauce.Repeat the same layers two more times.Top with mozzarella cheese.Cover and bake at 375 degrees for 30-min.Remove cover and bake for more minutes.Broil at the end if desired.Let it rest for 15-min prior to serving with Garlic Bread with Cheese",
        "Peel and slice the potatoes while still warm.Put them in a salad bowl with the onions,garlic and seasoning.Bring the oil,vinegar and mustard slowly to the boil,pour over the potatoes.Mix carefully.Serve cold,garnished with parsely.",
        "Add 1 cup whole milk, banana, peanut butter, cinnamon, and ice to a blender carafe. Start the blender on low and gradually increase to high. Stop and scrape down the sides of the blender as needed. If the smoothie is too thick add additional milk, one tablespoon at a time, to reach desired consistency. Blend until the smoothie is frothy and smooth with ice completely blended. Serve.",
        "Quarter the tomatoes and put in a heavy pot,add the bay leaf,thyme,sliced onion.Crush the tomatoes with a wooden spoon and cook very gently fr 30-min,stirring often to prevent sticking.Sieve.To this puree add the water,salt,sugar,butter.Stir well,bring to the boil and take off heat.Pour over croutons and serve at once.",
        "Beat the egg yolks and the sugar until white.Beat in the orange juice and the rum.Add the sifted flour and the butter.Fold the stiffly beaten egg whites.Bake in a greased and floured tin for 40-min in a slow oven.Ice with rum icing(How:Rub the lump sugar with the lemon peel.Heat the icing sugar,the lump sugar and the rum slowly with a little water until it thickens",
        "Take a large saucepan and melt the oil in it.Add the peanut butter.Cook for 2-min.Add the meat,stir into the sauce,cover the pan and simmer gently for 7-min.Serve with hot rice and all or any of the accompanying dishes.",
    )
    private val itemImages = arrayOf(
        R.drawable.lasagna,
        R.drawable.potatosalad,
        R.drawable.bananasmoothie,
        R.drawable.tomatosoup,
        R.drawable.orangecake,
        R.drawable.westchop,
    )

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        var image:ImageView
        var textTitle :TextView
        var textDes :TextView

        init {
            image = itemView.findViewById(R.id.item_image)
            textTitle = itemView.findViewById(R.id.item_title)
            textDes = itemView.findViewById(R.id.item_des)

        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewHolder{
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_model,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return itemTitles.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textTitle.text = itemTitles[position]
        holder.textDes.text = itemDetails[position]
        holder.image.setImageResource(itemImages[position])

        holder.itemView.setOnClickListener {v:View ->

            Toast.makeText(v.context, "Clicked on the item",Toast.LENGTH_SHORT)
        }
    }
}