package com.example.recyclerviewapplicationsabaorkoshneli

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
    }

    override fun getItemCount() = dataList.size
}