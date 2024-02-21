package com.ubb.raiffaisen.thinktank.main.domain

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ubb.raiffaisen.thinktank.R

class GridItemAdapter(private val items: List<GridItem>) : RecyclerView.Adapter<GridItemAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val categoryNameTextView: TextView = view.findViewById(R.id.categoryNameTextView)
        var iconImageView: ImageView = view.findViewById(R.id.iconImageView)
        var budgetTextView: TextView = view.findViewById(R.id.budgetTextView)
        val usedSumTextView: TextView = view.findViewById(R.id.usedSumTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val contactView = inflater.inflate(R.layout.item_grid_card, parent, false)
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        // Here you can set the data on your views
        holder.categoryNameTextView.text = item.name
        holder.budgetTextView.text = String.format("Budget: %.2f", item.allocatedSum)
        holder.usedSumTextView.text = String.format("Used: %.2f", item.usedSum)
        holder.iconImageView.setImageResource(item.icon)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
