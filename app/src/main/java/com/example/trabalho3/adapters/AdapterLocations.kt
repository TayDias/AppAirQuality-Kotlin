package com.example.trabalho3.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.trabalho3.MainActivity
import com.example.trabalho3.R
import com.example.trabalho3.classes.location.Location
import kotlinx.android.synthetic.main.city.view.*

class AdapterLocations (
    private val context: Context,
    private val list: List<Location>
    ) : RecyclerView.Adapter<AdapterLocations.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(context).inflate(R.layout.city, parent, false)
            return  ViewHolder(view)
        }

        fun getItem(position: Int): Location {
            return list[position]
        }

        override fun getItemId(position: Int): Long {
            return list[position].id
        }

        override fun getItemCount(): Int {
            return list.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val item = list[position]
            holder.city.text = item.locationName
            holder.id.text = item.id.toString()

            var buttonView = holder.itemView.imageButtonDelete

            buttonView.setOnClickListener{
                val intent: Intent = Intent(context, MainActivity::class.java)
                intent.putExtra("op", "delete")
                intent.putExtra("location", item)

               context.startActivity(Intent(intent))
            }
        }

        class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
            val city = itemView.textCity
            val id = itemView.textViewId
        }

}