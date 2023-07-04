package com.example.recyclerviewapplicationsabaorkoshneli

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewapplicationsabaorkoshneli.databinding.ItemViewBinding
import com.squareup.picasso.Picasso

class HomeRecyclerViewAdapter(val dataList : MutableList<Food>) : RecyclerView.Adapter<HomeRecyclerViewAdapter.HomeRecyclerViewViewHolder>() {

    inner class HomeRecyclerViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val binding = ItemViewBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeRecyclerViewViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return HomeRecyclerViewViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeRecyclerViewViewHolder, position: Int) {
        val item = dataList[position]
        holder.binding.apply {
            nameTV.text = item.name
            priceTV.text = item.price
            Picasso.get().load(item.photo).into(imageView);
        }

        holder.itemView.setOnClickListener {
            // Perform the desired action when the item view is clicked
            val context = holder.itemView.context

            // Create an intent to start the FoodActivity and pass the necessary data
            val intent = Intent(context, FoodActivity::class.java)
            intent.putExtra("name", item.name)
            intent.putExtra("price", item.price)
            intent.putExtra("image", item.photo)

            context.startActivity(intent)
        }
    }

    override fun getItemCount() = dataList.size
}