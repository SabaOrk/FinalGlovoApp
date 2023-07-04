package com.example.recyclerviewapplicationsabaorkoshneli

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.squareup.picasso.Picasso

class FoodActivity : AppCompatActivity() {

    private lateinit var orderBtn : Button
    private lateinit var backBtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)
        init()
        listeners()

        // Retrieve the passed data from the intent
        val name = intent.getStringExtra("name")
        val price = intent.getStringExtra("price")
        val imageUrl = intent.getStringExtra("image")

        // Use the data to populate the views in activity_food.xml
        val nameTextView: TextView = findViewById(R.id.foodTitleTextView)
        val priceTextView: TextView = findViewById(R.id.foodPriceTextView)
        val imageView: ImageView = findViewById(R.id.foodImageView)

        nameTextView.text = name
        priceTextView.text = price
        Picasso.get().load(imageUrl).into(imageView);
    }


    private fun init() {
        orderBtn = findViewById(R.id.orderBtn)
        backBtn = findViewById(R.id.backBtn)
    }

    private fun listeners() {
        orderBtn.setOnClickListener {
            Toast.makeText(this, "you have successifully placed an order, please wait until it gets delivered!", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, OrderActivity::class.java))
        }

        backBtn.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}
