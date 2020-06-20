package com.example.trabalho3.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.trabalho3.Location
import com.example.trabalho3.R
import kotlinx.android.synthetic.main.city.view.*

class AdapterLocations (
    private val context: Context,
    private val list: List<Location>
    ) : RecyclerView.Adapter<AdapterLocations.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(context).inflate(R.layout.city, parent, false)
            return  ViewHolder(view)
        }

        override fun getItemCount(): Int {
            return list.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val item = list[position]
            holder.city.text = item.locationName
        }

        class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
            val city = itemView.textCity
        }
}