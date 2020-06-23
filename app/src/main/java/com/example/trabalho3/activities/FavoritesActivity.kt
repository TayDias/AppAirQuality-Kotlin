package com.example.trabalho3.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.trabalho3.classes.location.Location
import com.example.trabalho3.R
import com.example.trabalho3.adapters.AdapterLocations

class FavoritesActivity : AppCompatActivity() {
    var list = ArrayList<Location>()
    var adapter = AdapterLocations(this, list)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites)

        val bundle = intent.extras
        list = bundle?.getSerializable("list") as ArrayList<Location>
        adapter = AdapterLocations(this, list)

        adapter.notifyDataSetChanged()

        //Recycler View and Adapter connection
        val recyclerListView: RecyclerView = findViewById(R.id.recyclerListView)
        val layoutManager = LinearLayoutManager(this)
        recyclerListView.layoutManager = layoutManager
        recyclerListView.adapter = adapter

    }

}